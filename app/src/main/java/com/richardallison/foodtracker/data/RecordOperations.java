package com.richardallison.foodtracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;

import com.richardallison.foodtracker.models.Record;
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

        Cursor cursor = db.query(
                FoodTrackerEntry.TABLE_RECORDS,
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

    public ArrayList<Record> findRecordsByDate(String date) {

        String selection = "date";
        String[] selectionArgs = new String[] {date};

        Cursor cursor = db.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                columns,
                selection + "=?",
                selectionArgs,
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
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getString(3),
                cursor.getString(4)
        );

        cursor.close();

        return record;
    }


// SELECT - SHOW ALL RECORD ITEMS

    public ArrayList<Record> getAllRecords() {

        Cursor cursor = db.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
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