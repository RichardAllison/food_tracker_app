package com.richardallison.foodtracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerContract.FoodTrackerEntry;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class ViewAllRecordsActivity extends AppCompatActivity {

    SQLiteDatabase db;
    FoodTrackerDbHelper mDbHelper;
    Cursor cursor;

    RecordCursorAdapter recordCursorAdapter;

    Button createRecordButton;
    ListView recordDatabaseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_records);

        createRecordButton = findViewById(R.id.add_record);
        recordDatabaseListView = findViewById(R.id.record_database_list_view);

        displayRecords();
    }

    public void onCreateRecordButtonClicked(View button) {
        Intent intent = new Intent(this, CreateRecordActivity.class);
        startActivity(intent);
    }

    public void onRecordDeleteButtonClicked(View button) {
        long id = (long) button.getTag();
        boolean recordRemoved = removeRecord(id);
        if (recordRemoved) {
            Toast.makeText(this, "Record deleted", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ViewAllRecordsActivity.class);
            startActivity(intent);
        }
    }

    private void displayRecords() {

        mDbHelper = new FoodTrackerDbHelper(this);
        db = mDbHelper.getReadableDatabase();
        String records = FoodTrackerEntry.TABLE_RECORDS;
        String foodAndDrinks = FoodTrackerEntry.TABLE_FOOD_AND_DRINKS;

        String[] columns = {
                FoodTrackerEntry.TABLE_RECORDS + "." + FoodTrackerEntry._ID,
                FoodTrackerEntry.KEY_DATE,
                FoodTrackerEntry.KEY_FD_ID,
                FoodTrackerEntry.KEY_MEAL_TIME,
                FoodTrackerEntry.KEY_NAME
        };

//        String sortOrder =
//                FoodTrackerEntry.KEY_NAME + " ASC";

        String table = records + " inner join " + foodAndDrinks
                + " on " + records + "." + FoodTrackerEntry.KEY_FD_ID
                + " = " + foodAndDrinks + "." + FoodTrackerEntry._ID;

        cursor = db.query(
                table,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        recordCursorAdapter = new RecordCursorAdapter(this, cursor);
        recordDatabaseListView.setAdapter(recordCursorAdapter);
//        emptyView = findViewById(R.id.empty_view);
//        recordDatabaseListView.setEmptyView(emptyView);
    }

    public void onListItemClick(View listItem) {
        Record record = (Record) listItem.getTag();

        Intent intent = new Intent(this, ViewRecordActivity.class);
//        intent.putExtra("record", record);
        startActivity(intent);
    }

    private boolean removeRecord(long id) {
        return db.delete(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                FoodTrackerContract.FoodTrackerEntry._ID + "=?",
                new String[] {String.valueOf(id)}) > 0;
    }

}

