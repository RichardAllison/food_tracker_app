package com.richardallison.foodtracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.richardallison.foodtracker.R;

public class MainActivity extends AppCompatActivity {

    Button viewFoodDatabaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFoodDatabaseButton = findViewById(R.id.view_food_database);
    }

    public void onViewFoodDatabaseButtonClicked(View button) {
        Intent intent = new Intent(this, ViewFoodDatabaseActivity.class);
        startActivity(intent);
    }

    public void onViewRecordsButtonClicked(View button) {
        Intent intent = new Intent(this, ViewAllRecordsActivity.class);
        startActivity(intent);
    }

    public void onViewByDateButtonClicked(View button) {
        Intent intent = new Intent(this, ViewAllRecordsByDateActivity.class);
        startActivity(intent);
    }
}
