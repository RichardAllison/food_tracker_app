package com.codeclan.example.foodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.codeclan.example.foodtracker.R;

public class MainActivity extends AppCompatActivity {

    Button viewRecordsButton;
    Button addRecordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewRecordsButton = findViewById(R.id.view_records);
        addRecordButton = findViewById(R.id.add_record);
    }

    public void onViewRecordsButtonClicked(View button) {
        Intent intent = new Intent(this, ViewRecordsActivity.class);
        startActivity(intent);
    }

}
