package com.richardallison.foodtracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.richardallison.foodtracker.data.FoodTrackerContract.FoodTrackerEntry.*;

public class FoodTrackerDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodTracker.db";

    public FoodTrackerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create tables

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FOOD_AND_DRINKS);
        db.execSQL(SQL_CREATE_TABLE_RECORD);
    }

    // Upgrade tables

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_RECORD);
        db.execSQL(SQL_DELETE_TABLE_FOOD_AND_DRINKS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // Create tables constants

    private static final String SQL_CREATE_TABLE_FOOD_AND_DRINKS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_FOOD_AND_DRINKS + "("
                    + _ID + " INTEGER PRIMARY KEY,"
                    + KEY_NAME + " TEXT,"
                    + KEY_TYPE + " TEXT,"
                    + KEY_DESCRIPTION + " TEXT,"
                    + KEY_BRAND + " TEXT,"
                    + KEY_SERVING_SIZE + " TEXT,"
                    + KEY_CALORIES + " INTEGER,"
                    + KEY_CARBOHYDRATES + " INTEGER,"
                    + KEY_FAT + " INTEGER,"
                    + KEY_SATURATED_FAT + " INTEGER,"
                    + KEY_TRANS_FAT + " INTEGER,"
                    + KEY_CHOLESTEROL + " INTEGER,"
                    + KEY_PROTEIN + " INTEGER,"
                    + KEY_SODIUM + " INTEGER,"
                    + KEY_POTASSIUM + " INTEGER,"
                    + KEY_FIBRE + " INTEGER,"
                    + KEY_SUGAR + " INTEGER,"
                    + KEY_GLYCEMIC_INDEX + " INTEGER,"
                    + KEY_ALCOHOL_CONTENT + " INTEGER"
            + ");";


    private static final String SQL_CREATE_TABLE_RECORD =
            "CREATE TABLE IF NOT EXISTS " + TABLE_RECORDS + "("
                    + _ID + " INTEGER PRIMARY KEY,"
                    + KEY_DATE + " TEXT NOT NULL,"
                    + KEY_MEAL_TIME + " INTEGER,"
                    + KEY_PORTION_SIZE + " INTEGER,"
                    + KEY_FD_ID + " INTEGER,"
                    + "FOREIGN KEY(" + KEY_FD_ID + ") REFERENCES " + TABLE_FOOD_AND_DRINKS + "(" + _ID + ")"
            + ");";

    // Delete table constants

    private static final String SQL_DELETE_TABLE_RECORD = "DROP TABLE IF EXISTS " + TABLE_RECORDS;
    private static final String SQL_DELETE_TABLE_FOOD_AND_DRINKS = "DROP TABLE IF EXISTS " + TABLE_FOOD_AND_DRINKS;

}
