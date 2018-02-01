package com.richardallison.foodtracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.richardallison.foodtracker.models.RecordDate;

import java.util.ArrayList;

public class DateOperations {

    private SQLiteDatabase db;

    private FoodTrackerDbHelper dbHelper;

    private static final String[] columns = {
            FoodTrackerContract.FoodTrackerEntry._ID,
            FoodTrackerContract.FoodTrackerEntry.KEY_DATE,
    };

    public DateOperations(Context context) {
        dbHelper = new FoodTrackerDbHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // INSERT - CREATE RECORD DATE

    public RecordDate addRecordDate(RecordDate recordDate) {
        ContentValues values = new ContentValues();
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_DATE, recordDate.getDate());

        if (!dateExists(recordDate.getDate())) {
            long newRowId = db.insert(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORD_DATES,
                    null,
                    values);
            recordDate.setID(newRowId);
        }
        return recordDate;
    }

    public boolean dateExists(String date) {
        ArrayList<RecordDate> allDates = displayRecordDates();
        int occurrences = 0;
        long id = 0;
        for(RecordDate recordDate : allDates){
            if (recordDate.getDate() == date) {
                occurrences++;
            }
        }
        if (occurrences > 0) {
            return true;
        } else {
            return false;
        }
    }

    // show all
    public ArrayList<RecordDate> displayRecordDates() {

        Cursor cursor = db.query(
                FoodTrackerContract.FoodTrackerEntry.TABLE_RECORD_DATES,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<RecordDate> recordDates = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                RecordDate recordDate = new RecordDate();
                recordDate.setID(cursor.getLong(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry._ID)));
                recordDates.add(recordDate);
            }
        }
        cursor.close();
        return recordDates;
    }


    // SELECT - SHOW RECORD DATE

    public RecordDate getRecordDate(long id) {
        String[] recordDateID = new String[]{
                String.valueOf(id)
        };

        Cursor cursor = db.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORD_DATES,
                columns,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordDateID,
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        RecordDate recordDate = new RecordDate(Long.parseLong(cursor.getString(0)),
                cursor.getString(1)
        );

        cursor.close();

        return recordDate;
    }


    // SELECT - SHOW ALL RECORD DATES

    public ArrayList<RecordDate> getAllRecordDates() {

        Cursor cursor = db.query(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORD_DATES,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<RecordDate> recordDates = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                RecordDate recordDate = new RecordDate();
                recordDate.setID(cursor.getLong(cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry._ID)));
                recordDate.setDate(cursor.getString(cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry.KEY_DATE)));
                recordDates.add(recordDate);
            }
        }
        cursor.close();
        return recordDates;
    }


    // UPDATE - UPDATE RECORD DATE BY ID

    public int updateRecordDate(RecordDate recordDate) {
        String[] recordDateID = new String[]{
                String.valueOf(recordDate.getID())
        };

        ContentValues values = new ContentValues();
        values.put(FoodTrackerContract.FoodTrackerEntry.KEY_DATE, recordDate.getDate());

        return db.update(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORD_DATES,
                values,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordDateID
        );
    }


    // DELETE RECORD DATE BY ID

    public boolean removeRecordDate(long id) {
        String[] recordDateID = new String[]{
                String.valueOf(id)
        };

        return db.delete(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORD_DATES,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordDateID
        ) > 0;
    }

    public void removeRecordDate(RecordDate recordDate) {
        String[] recordDateID = new String[]{
                String.valueOf(recordDate.getID())
        };

        db.delete(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORD_DATES,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                recordDateID
        );
    }

}

