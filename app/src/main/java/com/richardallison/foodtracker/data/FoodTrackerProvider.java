package com.richardallison.foodtracker.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class FoodTrackerProvider extends ContentProvider {

    private static final int FOOD = 1;
    private static final int FOOD_ID = 2;
    private static final int RECORD = 3;
    private static final int RECORD_ID = 4;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(FoodTrackerContract.CONTENT_AUTHORITY, FoodTrackerContract.PATH_FOOD, FOOD);
        uriMatcher.addURI(FoodTrackerContract.CONTENT_AUTHORITY, FoodTrackerContract.PATH_FOOD  + "/#", FOOD_ID);
        uriMatcher.addURI(FoodTrackerContract.CONTENT_AUTHORITY, FoodTrackerContract.PATH_RECORDS, RECORD);
        uriMatcher.addURI(FoodTrackerContract.CONTENT_AUTHORITY, FoodTrackerContract.PATH_RECORDS  + "/#", RECORD_ID);
    }

    private FoodTrackerDbHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new FoodTrackerDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] projection,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor;

        int match = uriMatcher.match(uri);
        switch (match) {
            case FOOD:
                cursor = database.query(FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                         projection,
                         selection,
                         selectionArgs,
                        null,
                        null,
                         sortOrder
                );
                break;
            case FOOD_ID:
                selection = FoodTrackerContract.FoodTrackerEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                         projection,
                         selection,
                         selectionArgs,
                        null,
                        null,
                         sortOrder
                );
                break;
            case RECORD:
                cursor = database.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                         projection,
                         selection,
                         selectionArgs,
                        null,
                        null,
                         sortOrder
                );
                break;
            case RECORD_ID:
                selection = FoodTrackerContract.FoodTrackerEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                         projection,
                         selection,
                         selectionArgs,
                        null,
                        null,
                         sortOrder
                );
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = uriMatcher.match(uri);
        switch (match) {
            case FOOD:
                return insertFood(uri, values);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }


    private Uri insertFood(Uri uri, ContentValues values) {

        String name = values.getAsString(FoodTrackerContract.FoodTrackerEntry.KEY_NAME);
        if (name == null) {
            throw new IllegalArgumentException("Food needs a name");
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        long id = db.insert(FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                null,
                values);

        if (id == -1) {
            Log.e("CONTENT PROVIDER", "Failed to insert row for " + uri);
            return null;
        }

        return ContentUris.withAppendedId(uri, id);
    }



    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}

