package com.codeclan.example.foodtracker.data;

import android.net.Uri;
import android.provider.BaseColumns;
import android.text.format.Time;

public class FoodTrackerContract {

    private FoodTrackerContract() {}

//    public static final String CONTENT_AUTHORITY = "com.codeclan.example.foodtracker.app";
//    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
//    public static long normalizeDate(long date) {
//        Time time = new Time();
//        time.set(date);
//        int julianDay = Time.getJulianDay(date, time.gmtoff);
//        return time.setJulianDay(julianDay);
//    }

    public static abstract class FoodTrackerEntry implements BaseColumns {

        // Table Names

        public static final String TABLE_FOOD_AND_DRINKS = "food_and_drinks";
        public static final String TABLE_RECORDS = "records";

        // Food and drinks table column names

        public static final String FD_COLUMN_NAME = "name";
        public static final String FD_COLUMN_TYPE = "type";
        public static final String FD_COLUMN_DESCRIPTION = "description";
        public static final String FD_COLUMN_HOME_MADE = "home_made";
        public static final String FD_COLUMN_BRAND = "brand";
        public static final String FD_COLUMN_CALORIES = "calories";
        public static final String FD_COLUMN_CARBOHYDRATES = "carbohydrates";
        public static final String FD_COLUMN_FAT= "fat";
        public static final String FD_COLUMN_SATURATED_FAT= "saturated_fat";
        public static final String FD_COLUMN_TRANS_FAT= "trans_fat";
        public static final String FD_COLUMN_CHOLESTEROL = "cholesterol";
        public static final String FD_COLUMN_PROTEIN = "protein";
        public static final String FD_COLUMN_SODIUM = "sodium";
        public static final String FD_COLUMN_POTASSIUM = "potassium";
        public static final String FD_COLUMN_FIBRE = "fibre";
        public static final String FD_COLUMN_SUGAR = "sugar";
        public static final String FD_COLUMN_GLYCEMIC_INDEX = "glycemic_index";
        public static final String FD_COLUMN_ALCOHOL_CONTENT = "alcohol_content";

        // Record table column names

        public static final String RECORD_COLUMN_FD_ID = "food_and_drinks_id";
        public static final String RECORD_COLUMN_DATE = "date";
        public static final String RECORD_COLUMN_MEAL_TIME = "meal_time";
        public static final String RECORD_COLUMN_PORTION_SIZE = "portion_size";
    }

}