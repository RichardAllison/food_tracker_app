package com.richardallison.foodtracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;

import com.richardallison.foodtracker.Food;
import com.richardallison.foodtracker.data.FoodTrackerContract.FoodTrackerEntry;

public class FoodOperations {

    private static FoodTrackerDbHelper dbHelper;
    private static SQLiteDatabase db;

    private static final String[] columns = {
            FoodTrackerEntry._ID,
            FoodTrackerEntry.KEY_NAME,
            FoodTrackerEntry.KEY_TYPE,
            FoodTrackerEntry.KEY_DESCRIPTION,
            FoodTrackerEntry.KEY_BRAND,
            FoodTrackerEntry.KEY_SERVING_SIZE,
            FoodTrackerEntry.KEY_CALORIES,
            FoodTrackerEntry.KEY_GLYCEMIC_INDEX,
            FoodTrackerEntry.KEY_CARBOHYDRATES,
            FoodTrackerEntry.KEY_FAT,
            FoodTrackerEntry.KEY_SATURATED_FAT,
            FoodTrackerEntry.KEY_TRANS_FAT,
            FoodTrackerEntry.KEY_CHOLESTEROL,
            FoodTrackerEntry.KEY_PROTEIN,
            FoodTrackerEntry.KEY_SODIUM,
            FoodTrackerEntry.KEY_POTASSIUM,
            FoodTrackerEntry.KEY_FIBRE,
            FoodTrackerEntry.KEY_SUGAR
    };

    public FoodOperations(Context context) {
        dbHelper = new FoodTrackerDbHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // INSERT - CREATE FOOD ITEM

    public Food addFood(Food food) {
        ContentValues values = new ContentValues();
        values.put(FoodTrackerEntry.KEY_NAME, food.getName());
        values.put(FoodTrackerEntry.KEY_TYPE, food.getType());
        values.put(FoodTrackerEntry.KEY_DESCRIPTION, food.getDescription());
        values.put(FoodTrackerEntry.KEY_BRAND, food.getBrand());
        values.put(FoodTrackerEntry.KEY_SERVING_SIZE, food.getServingSize());
        values.put(FoodTrackerEntry.KEY_CALORIES, food.getCalories());
        values.put(FoodTrackerEntry.KEY_GLYCEMIC_INDEX, food.getGlycemicIndex());
        values.put(FoodTrackerEntry.KEY_CARBOHYDRATES, food.getCarbohydrates());
        values.put(FoodTrackerEntry.KEY_FAT, food.getFat());
        values.put(FoodTrackerEntry.KEY_SATURATED_FAT, food.getSaturatedFat());
        values.put(FoodTrackerEntry.KEY_TRANS_FAT, food.getTransFat());
        values.put(FoodTrackerEntry.KEY_CHOLESTEROL, food.getCholesterol());
        values.put(FoodTrackerEntry.KEY_PROTEIN, food.getProtein());
        values.put(FoodTrackerEntry.KEY_SODIUM, food.getSodium());
        values.put(FoodTrackerEntry.KEY_POTASSIUM, food.getPotassium());
        values.put(FoodTrackerEntry.KEY_FIBRE, food.getFibre());
        values.put(FoodTrackerEntry.KEY_SUGAR, food.getSugar());

        long newRowId = db.insert(FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                null,
                values
        );
        food.setID(newRowId);
        return food;
    }

    // SELECT - SHOW FOOD ITEM

    public Food getFood(long id) {
        String[] foodID = new String[] {
                String.valueOf(id)
        };

        Cursor cursor = db.query(FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                columns,
                FoodTrackerEntry._ID + "=?",
                foodID,
                null,
                null,
                null,
                null
        );

        if (cursor != null)
            cursor.moveToFirst();

        Food food = new Food(Long.parseLong(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getInt(6),
                cursor.getInt(7),
                cursor.getInt(8),
                cursor.getInt(9),
                cursor.getInt(10),
                cursor.getInt(11),
                cursor.getInt(12),
                cursor.getInt(13),
                cursor.getInt(14),
                cursor.getInt(15),
                cursor.getInt(16),
                cursor.getInt(17)
        );

        cursor.close();

        return food;
    }

    // SELECT - SHOW ALL FOOD ITEMS

    public static Cursor getAllFood() {

        Cursor cursor = db.query(FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                columns,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public ArrayList<Food> showAllFood() {

        Cursor cursor = db.query(FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<Food> foods = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Food food = new Food();
                food.setID(cursor.getLong(cursor.getColumnIndex(FoodTrackerEntry._ID)));
                food.setName(cursor.getString(cursor.getColumnIndex(FoodTrackerEntry.KEY_NAME)));
                food.setType(cursor.getString(cursor.getColumnIndex(FoodTrackerEntry.KEY_TYPE)));
                food.setDescription(cursor.getString(cursor.getColumnIndex(FoodTrackerEntry.KEY_DESCRIPTION)));
                food.setBrand(cursor.getString(cursor.getColumnIndex(FoodTrackerEntry.KEY_BRAND)));
                food.setServingSize(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_SERVING_SIZE)));
                food.setCalories(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_CALORIES)));
                food.setGlycemicIndex(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_GLYCEMIC_INDEX)));
                food.setCarbohydrates(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_CARBOHYDRATES)));
                food.setFat(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_FAT)));
                food.setSaturatedFat(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_SATURATED_FAT)));
                food.setTransFat(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_TRANS_FAT)));
                food.setCholesterol(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_CHOLESTEROL)));
                food.setProtein(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_PROTEIN)));
                food.setSodium(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_SODIUM)));
                food.setPotassium(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_POTASSIUM)));
                food.setFibre(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_FIBRE)));
                food.setSugar(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_SUGAR)));
                foods.add(food);
            }
        }
        cursor.close();
        return foods;
    }

        // UPDATE - UPDATE FOOD ITEM BY ID

    public int updateFood(Food food) {
        String[] foodID = new String[] {
                String.valueOf(food.getID())
        };

        ContentValues values = new ContentValues();
        values.put(FoodTrackerEntry.KEY_NAME, food.getName());
        values.put(FoodTrackerEntry.KEY_TYPE, food.getType());
        values.put(FoodTrackerEntry.KEY_DESCRIPTION, food.getDescription());
        values.put(FoodTrackerEntry.KEY_BRAND, food.getBrand());
        values.put(FoodTrackerEntry.KEY_SERVING_SIZE, food.getServingSize());
        values.put(FoodTrackerEntry.KEY_CALORIES, food.getCalories());
        values.put(FoodTrackerEntry.KEY_GLYCEMIC_INDEX, food.getGlycemicIndex());
        values.put(FoodTrackerEntry.KEY_CARBOHYDRATES, food.getCarbohydrates());
        values.put(FoodTrackerEntry.KEY_FAT, food.getFat());
        values.put(FoodTrackerEntry.KEY_SATURATED_FAT, food.getSaturatedFat());
        values.put(FoodTrackerEntry.KEY_TRANS_FAT, food.getTransFat());
        values.put(FoodTrackerEntry.KEY_CHOLESTEROL, food.getCholesterol());
        values.put(FoodTrackerEntry.KEY_PROTEIN, food.getProtein());
        values.put(FoodTrackerEntry.KEY_SODIUM, food.getSodium());
        values.put(FoodTrackerEntry.KEY_POTASSIUM, food.getPotassium());
        values.put(FoodTrackerEntry.KEY_FIBRE, food.getFibre());
        values.put(FoodTrackerEntry.KEY_SUGAR, food.getSugar());

        return db.update(FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                values,
                FoodTrackerEntry._ID + "=?",
                foodID
        );
    }


    // DELETE FOOD ITEM BY ID

    public void removeFood(Food food) {
        String[] foodID = new String[] {
                String.valueOf(food.getID())
        };

        db.delete(FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                FoodTrackerEntry._ID + "=?",
                foodID
        );
    }

    public boolean removeFood(long id) {
        String[] foodID = new String[] {
                String.valueOf(id)
        };

        return db.delete(FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                FoodTrackerEntry._ID + "=?",
                foodID
        ) > 0;
    }


}