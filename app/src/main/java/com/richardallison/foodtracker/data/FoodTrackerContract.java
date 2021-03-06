package com.richardallison.foodtracker.data;

import android.provider.BaseColumns;

public class FoodTrackerContract {

    public FoodTrackerContract() {}

    public static abstract class FoodTrackerEntry implements BaseColumns {

        // Table names

        public static final String TABLE_FOOD_AND_DRINKS = "food_and_drinks";
        public static final String TABLE_RECORDS = "user_records";
        public static final String TABLE_RECORD_DATES = "record_dates";

        // Food and drinks table column names

        public static final String KEY_NAME = "name";
        public static final String KEY_TYPE = "type";
        public static final String KEY_DESCRIPTION = "description";
        public static final String KEY_BRAND = "brand";
        public static final String KEY_SERVING_SIZE = "serving_size";
        public static final String KEY_CALORIES = "calories";
        public static final String KEY_CARBOHYDRATES = "carbohydrates";
        public static final String KEY_FAT = "fat";
        public static final String KEY_SATURATED_FAT = "saturated_fat";
        public static final String KEY_TRANS_FAT = "trans_fat";
        public static final String KEY_CHOLESTEROL = "cholesterol";
        public static final String KEY_PROTEIN = "protein";
        public static final String KEY_SODIUM = "sodium";
        public static final String KEY_POTASSIUM = "potassium";
        public static final String KEY_FIBRE = "fibre";
        public static final String KEY_SUGAR = "sugar";
        public static final String KEY_GLYCEMIC_INDEX = "glycemic_index";
        public static final String KEY_ALCOHOL_CONTENT = "alcohol_content";

        // Record table column names

        public static final String KEY_FD_ID = "food_and_drinks_id";
        public static final String KEY_DATE = "date";
        public static final String KEY_MEAL_TIME = "meal_time";
        public static final String KEY_PORTION_SIZE = "portion_size";
    }

}