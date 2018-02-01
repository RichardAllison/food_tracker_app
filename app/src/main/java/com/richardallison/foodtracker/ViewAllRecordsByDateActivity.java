package com.richardallison.foodtracker;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.richardallison.foodtracker.data.DateOperations;

public class ViewAllRecordsByDateActivity extends AppCompatActivity {


    DateAdapter dateAdapter;
    private DateOperations dateOperations;

    Button createRecordButton;
    RecyclerView dateRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_records_by_date);

        createRecordButton = findViewById(R.id.record_add_button2);
        dateRecyclerView = findViewById(R.id.date_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dateRecyclerView.setLayoutManager(layoutManager);

        dateRecyclerView.setHasFixedSize(true);

        dateOperations = new DateOperations(this);
        dateOperations.open();

        dateAdapter = new DateAdapter(dateOperations.getAllRecordDates());
        dateRecyclerView.setAdapter(dateAdapter);
        dateOperations.close();
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


