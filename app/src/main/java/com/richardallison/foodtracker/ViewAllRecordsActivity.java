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

import com.richardallison.foodtracker.data.FoodTrackerContract;
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

    private void displayRecords() {

        mDbHelper = new FoodTrackerDbHelper(this);
        db = mDbHelper.getReadableDatabase();

        String[] columns = {
                FoodTrackerContract.FoodTrackerEntry._ID,
                FoodTrackerContract.FoodTrackerEntry.KEY_DATE,
                FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID,
                FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME
        };

        String sortOrder =
                FoodTrackerContract.FoodTrackerEntry._ID + " ASC";

        cursor = db.query(
                FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS,
                columns,
                null,
                null,
                null,
                null,
                sortOrder
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
}



