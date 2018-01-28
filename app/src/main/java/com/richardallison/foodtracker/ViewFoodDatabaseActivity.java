package com.richardallison.foodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewFoodDatabaseActivity extends AppCompatActivity {

    Button createFoodButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_database);

        createFoodButton = findViewById(R.id.create_food_button);

        ArrayList<Food> foodDatabase = new ArrayList<>();

        FoodAdapter foodAdapter = new FoodAdapter(this, foodDatabase);

        ListView foodDisplay = findViewById(R.id.food_database_list);
        foodDisplay.setAdapter(foodAdapter);
    }

    public void onCreateFoodButtonClicked(View button) {
        Intent intent = new Intent(this, CreateFoodActivity.class);
        startActivity(intent);
    }

}
