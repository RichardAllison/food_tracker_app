package com.codeclan.example.foodtracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codeclan.example.foodtracker.data.FoodTrackerContract;
import com.codeclan.example.foodtracker.data.FoodTrackerDbHelper;

public class SearchFoodActivity extends AppCompatActivity {

    Button createFoodButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);

        createFoodButton = findViewById(R.id.add_food);
        textView = findViewById(R.id.textView);
        displayDatabaseInfo();
    }

    public void onCreateFoodButtonClicked(View button) {
        Intent intent = new Intent(this, CreateFoodActivity.class);
        startActivity(intent);
    }

    private void displayDatabaseInfo() {
        FoodTrackerDbHelper mDbHelper = new FoodTrackerDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS, null);
        try {
           textView.setText("Number of rows in database table: " + cursor.getCount());
        } finally {
            cursor.close();
        }
    }

}
