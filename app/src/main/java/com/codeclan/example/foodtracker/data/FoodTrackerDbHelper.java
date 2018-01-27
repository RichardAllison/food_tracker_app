package com.codeclan.example.foodtracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.codeclan.example.foodtracker.data.FoodTrackerContract.FoodTrackerEntry.*;

public class FoodTrackerDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodTracker.db";

    public FoodTrackerDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create tables

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FD);
        db.execSQL(SQL_CREATE_TABLE_RECORD);
    }

    // Upgrade tables

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_FD);
        db.execSQL(SQL_DELETE_TABLE_RECORD);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // Create tables constants

    private static final String SQL_CREATE_TABLE_FD =
            "CREATE TABLE " + TABLE_FOOD_AND_DRINKS + "("
                    + "_id" + " INTEGER PRIMARY KEY,"
                    + FD_COLUMN_NAME + " TEXT,"
                    + FD_COLUMN_TYPE + " TEXT,"
                    + FD_COLUMN_DESCRIPTION + " TEXT,"
                    + FD_COLUMN_HOME_MADE + " TEXT,"
                    + FD_COLUMN_BRAND + " TEXT,"
                    + FD_COLUMN_CALORIES + " INTEGER,"
                    + FD_COLUMN_CARBOHYDRATES + " INTEGER,"
                    + FD_COLUMN_FAT + " INTEGER,"
                    + FD_COLUMN_SATURATED_FAT + " INTEGER,"
                    + FD_COLUMN_TRANS_FAT + " INTEGER,"
                    + FD_COLUMN_CHOLESTEROL + " INTEGER,"
                    + FD_COLUMN_PROTEIN + " INTEGER,"
                    + FD_COLUMN_SODIUM + " INTEGER,"
                    + FD_COLUMN_POTASSIUM + " INTEGER,"
                    + FD_COLUMN_FIBRE + " INTEGER,"
                    + FD_COLUMN_SUGAR + " INTEGER,"
                    + FD_COLUMN_GLYCEMIC_INDEX + " INTEGER,"
                    + FD_COLUMN_ALCOHOL_CONTENT + " INTEGER"
            + ")";


    private static final String SQL_CREATE_TABLE_RECORD =
            "CREATE TABLE " + TABLE_RECORDS + "("
                    + "_id" + " INTEGER PRIMARY KEY,"
                    + "FOREIGN KEY(" + RECORD_COLUMN_FD_ID + ") REFERENCES " + TABLE_FOOD_AND_DRINKS + "(_id) NOT NULL,"
                    + RECORD_COLUMN_DATE + " TEXT,"
                    + RECORD_COLUMN_MEAL_TIME + " INTEGER,"
                    + RECORD_COLUMN_PORTION_SIZE + " INTEGER"
            + ")";

    // Delete table constants

    private static final String SQL_DELETE_TABLE_FD = "DROP TABLE IF EXISTS " + TABLE_FOOD_AND_DRINKS;
    private static final String SQL_DELETE_TABLE_RECORD = "DROP TABLE IF EXISTS " + TABLE_RECORDS;

}
