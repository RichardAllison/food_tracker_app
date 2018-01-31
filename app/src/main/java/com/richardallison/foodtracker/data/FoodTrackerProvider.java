package com.richardallison.foodtracker.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class FoodTrackerProvider extends ContentProvider {

    public static final String PROVIDER_NAME = "in.wptrafficanalyzer.sqllistviewdemo.customer";

    /** A uri to do operations on cust_master table. A content provider is identified by its uri */
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/customers" );

    /** Constants to identify the requested operation */
    private static final int CUSTOMERS = 1;


    private static final UriMatcher uriMatcher ;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "customers", CUSTOMERS);
    }

    /** This content provider does the database operations by this object */
    private FoodTrackerDbHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new FoodTrackerDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

//    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
//
//        if(uriMatcher.match(uri)==CUSTOMERS){
//            return dbHelper.getAllCustomers();
//        }else{
//            return null;
//        }
//    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
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