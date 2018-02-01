package com.richardallison.foodtracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

import com.richardallison.foodtracker.Food;
import com.richardallison.foodtracker.Record;
import com.richardallison.foodtracker.data.FoodTrackerContract.FoodTrackerEntry;

public class RecordOperations {

    private SQLiteDatabase db;
    private FoodTrackerDbHelper dbHelper;

    private static final String[] columns = {
            FoodTrackerContract.FoodTrackerEntry._ID,
            FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID,
            FoodTrackerContract.FoodTrackerEntry.KEY_NAME,
            FoodTrackerContract.FoodTrackerEntry.KEY_DATE,
            FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME,
            FoodTrackerContract.FoodTrackerEntry.KEY_PORTION_SIZE
    };

    public RecordOperations(Context context) {
        dbHelper = new FoodTrackerDbHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

// INSERT - CREATE RECORD ITEM

    public Record addRecord(Record record) {
        ContentValues values = new ContentValues();
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_DATE, record.getDate());
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID, record.getItemID());
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_NAME, record.getFoodName());
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME, record.getMealtime());
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_PORTION_SIZE, record.getPortionSize());

        long newRowId = db.insert(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                null,
                values);
        record.setID(newRowId);
        return record;
    }

    public ArrayList<Record> displayRecords() {

        String recordsTable = FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS;

        String[] columns = {
                FoodTrackerContract.FoodTrackerEntry._ID,
                FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID,
                FoodTrackerContract.FoodTrackerEntry.KEY_NAME,
                FoodTrackerContract.FoodTrackerEntry.KEY_DATE,
                FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME,
                FoodTrackerContract.FoodTrackerEntry.KEY_PORTION_SIZE
        };

        Cursor cursor = db.query(
                recordsTable,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<Record> records = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Record record = new Record();
                record.setID(cursor.getLong(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry._ID)));
                record.setDate(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_DATE)));
                record.setItemID(cursor.getInt(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID)));
                record.setMealtime(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME)));
                record.setPortionSize(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_PORTION_SIZE)));
                record.setFoodName(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_NAME)));
                records.add(record);
            }
        }
        cursor.close();
        return records;
    }


// SELECT - SHOW RECORD ITEM

    public Record getRecord(long id) {
        String[] recordID = new String[]{
                String.valueOf(id)
        };

        Cursor cursor = db.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                columns,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordID,
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Record record = new Record(Long.parseLong(cursor.getString(0)),
//                cursor.getInt(1),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getString(3),
                cursor.getString(4)
        );

        cursor.close();

        return record;
    }


// SELECT - SHOW ALL RECORD ITEMS

    public List<Record> getAllRecords() {

        Cursor cursor = db.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        List<Record> records = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Record record = new Record();
                record.setID(cursor.getLong(cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry._ID)));
                record.setDate(cursor.getString(cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry.KEY_DATE)));
                record.setItemID(cursor.getInt(cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID)));
                record.setMealtime(cursor.getString(cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME)));
                record.setPortionSize(cursor.getString(cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry.KEY_PORTION_SIZE)));
                records.add(record);
            }
        }
        cursor.close();
        return records;
    }


//    private List<Record> displayRecords() {
//
//        String records = FoodTrackerEntry.TABLE_RECORDS;
//        String foodAndDrinks = FoodTrackerEntry.TABLE_FOOD_AND_DRINKS;
//
//        String[] columns = {
//                FoodTrackerEntry.TABLE_RECORDS + "." + FoodTrackerEntry._ID,
//                FoodTrackerEntry.KEY_DATE_ID,
//                FoodTrackerEntry.KEY_FD_ID,
//                FoodTrackerEntry.KEY_MEAL_TIME,
//                FoodTrackerEntry.KEY_NAME
//        };
//
////        String sortOrder =
////                FoodTrackerEntry.KEY_NAME + " ASC";
//
//        String table = records + " inner join " + foodAndDrinks
//                + " on " + records + "." + FoodTrackerEntry.KEY_FD_ID
//                + " = " + foodAndDrinks + "." + FoodTrackerEntry._ID;
//
//        Cursor cursor = db.query(
//                table,
//                columns,
//                null,
//                null,
//                null,
//                null,
//                null
//        );
//
//        List<Record> recordsArray = new ArrayList<>();
//        if (cursor.getCount() > 0) {
//            while (cursor.moveToNext()) {
//                Record record = new Record();
//                record.setID(cursor.getLong(cursor.getColumnIndex(FoodTrackerEntry._ID)));
//                record.setDateID(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_DATE_ID)));
//                record.setItemID(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_FD_ID)));
//                record.setMealtime(cursor.getInt(cursor.getColumnIndex(FoodTrackerEntry.KEY_MEAL_TIME)));
//                record.setPortionSize(cursor.getString(cursor.getColumnIndex(FoodTrackerEntry.KEY_PORTION_SIZE)));
//                record.setFoodName(cursor.getString(cursor.getColumnIndex(FoodTrackerEntry.KEY_NAME)));
//                recordsArray.add(record);
//            }
//        }
//        cursor.close();
//        return recordsArray;
//    }


// UPDATE - UPDATE RECORD ITEM BY ID

    public int updateRecord(Record record) {
        String[] recordID = new String[]{
                String.valueOf(record.getID())
        };

        ContentValues values = new ContentValues();
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_DATE, record.getDate());
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID, record.getItemID());
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME, record.getMealtime());
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_PORTION_SIZE, record.getPortionSize());

        return db.update(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                values,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordID
        );
    }


// DELETE RECORD ITEM BY ID

    public boolean removeRecord(long id) {
        String[] recordID = new String[]{
                String.valueOf(id)
        };

        return db.delete(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordID
        ) > 0;
    }

    public void removeRecord(Record record) {
        String[] recordID = new String[]{
                String.valueOf(record.getID())
        };

        db.delete(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordID
        );
    }

}