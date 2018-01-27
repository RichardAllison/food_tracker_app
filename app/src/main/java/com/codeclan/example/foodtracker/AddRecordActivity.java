package com.codeclan.example.foodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddRecordActivity extends AppCompatActivity {

    Button addFoodRecordButton;
    Button addDrinkRecordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        addFoodRecordButton = findViewById(R.id.add_food_button);
        addDrinkRecordButton = findViewById(R.id.add_drink_button);
    }

    public void onAddFoodRecordButtonClicked(View button) {
        Intent intent = new Intent(this, SearchFoodActivity.class);
        startActivity(intent);
    }
}
