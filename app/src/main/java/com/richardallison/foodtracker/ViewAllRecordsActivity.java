package com.richardallison.foodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.richardallison.foodtracker.data.RecordOperations;

public class ViewAllRecordsActivity extends AppCompatActivity {

    RecordRecyclerAdapter recordRecyclerAdapter;
    private RecordOperations recordOperations;

    Button createRecordButton;
    RecyclerView recordDatabaseRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_records);

        createRecordButton = findViewById(R.id.record_add_button);
        recordDatabaseRecyclerView = findViewById(R.id.record_database_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recordDatabaseRecyclerView.setLayoutManager(layoutManager);

        recordDatabaseRecyclerView.setHasFixedSize(true);

        recordOperations = new RecordOperations(this);
        recordOperations.open();

        recordRecyclerAdapter = new RecordRecyclerAdapter(recordOperations.displayRecords());
        recordDatabaseRecyclerView.setAdapter(recordRecyclerAdapter);
        recordOperations.close();

    }

    public void onCreateRecordButtonClicked(View button) {
        Intent intent = new Intent(this, CreateRecordActivity.class);
        startActivity(intent);
    }

    public void onRecordDeleteButtonClicked(View button) {
        long id = (long) button.getTag();
        recordOperations = new RecordOperations(this);
        recordOperations.open();
        boolean recordRemoved = recordOperations.removeRecord(id);
        if (recordRemoved) {
            Toast.makeText(this, "Record deleted", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ViewRecordActivity.class);
            startActivity(intent);
        }
        recordOperations.close();
    }

    public void onListItemClick(View listItem) {
        Record record = (Record) listItem.getTag();

        Intent intent = new Intent(this, ViewRecordActivity.class);
//        intent.putExtra("record", record);
        startActivity(intent);
    }

}

