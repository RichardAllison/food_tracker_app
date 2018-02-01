package com.richardallison.foodtracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.richardallison.foodtracker.R;
import com.richardallison.foodtracker.activities.CreateRecordActivity;
import com.richardallison.foodtracker.activities.ViewRecordActivity;
import com.richardallison.foodtracker.adapters.DateAdapter;
import com.richardallison.foodtracker.data.DateOperations;
import com.richardallison.foodtracker.data.RecordOperations;
import com.richardallison.foodtracker.models.Record;
import com.richardallison.foodtracker.models.RecordDate;

import java.util.ArrayList;


public class ViewAllRecordsByDateActivity extends AppCompatActivity {
    private DateOperations dateOperations;
    private RecordOperations recordOperations;

    private Button createRecordButton;
    private RecyclerView dateRecyclerView;
    private ListView recordListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_records_by_date);

        createRecordButton = findViewById(R.id.record_add_button2);
        dateRecyclerView = findViewById(R.id.date_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dateRecyclerView.setLayoutManager(layoutManager);

        dateRecyclerView.setHasFixedSize(false);


        RecordOperations recordOperations = new RecordOperations(this);
        recordOperations.open();
        ArrayList<Record> recordArrayList = recordOperations.getAllRecords();
        recordOperations.close();


        dateOperations = new DateOperations(this);
        dateOperations.open();
        ArrayList<RecordDate> recordDates = dateOperations.getAllRecordDates();
        dateOperations.close();


        DateAdapter dateAdapter = new DateAdapter(recordDates, recordArrayList);
        dateRecyclerView.setAdapter(dateAdapter);
    }

    public void onCreateRecordButtonClicked(View button) {
        Intent intent = new Intent(this, CreateRecordActivity.class);
        startActivity(intent);
    }

    public void onListItemClick(View listItem) {
        Record record = (Record) listItem.getTag();

        Intent intent = new Intent(this, ViewRecordActivity.class);
        //        intent.putExtra("record", record);
        startActivity(intent);
    }


}