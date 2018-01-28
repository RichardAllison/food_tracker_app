package com.richardallison.foodtracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

import java.util.ArrayList;

public class ViewFoodDatabaseActivity extends AppCompatActivity {

    SQLiteDatabase db;
    FoodTrackerDbHelper mDbHelper;
    Cursor cursor;
    Button createFoodButton;
    ListView foodDatabaseListView;
    TextView foodDatabaseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_database);

        createFoodButton = findViewById(R.id.create_food_button);
        foodDatabaseListView = findViewById(R.id.food_database_list);
        foodDatabaseTextView = findViewById(R.id.textView3);

//        ArrayList<Food> foodDatabase = new ArrayList<>();
//        FoodAdapter foodAdapter = new FoodAdapter(this, foodDatabase);

        displayDatabaseInfo();

    }

    public void onCreateFoodButtonClicked(View button) {
        Intent intent = new Intent(this, CreateFoodActivity.class);
        startActivity(intent);
    }


    private void displayDatabaseInfo() {

        mDbHelper = new FoodTrackerDbHelper(this);
        db = mDbHelper.getReadableDatabase();
//        foodDisplay.setAdapter(foodAdapter);

        String[] columns = {
                FoodTrackerContract.FoodTrackerEntry._ID,
                FoodTrackerContract.FoodTrackerEntry.KEY_NAME,
                FoodTrackerContract.FoodTrackerEntry.KEY_TYPE,
                FoodTrackerContract.FoodTrackerEntry.KEY_BRAND
        };

        String sortOrder =
                FoodTrackerContract.FoodTrackerEntry.KEY_NAME + " DESC";

        Cursor cursor = db.query(
                FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                columns,
                null,
                null,
                null,
                null,
                sortOrder
        );


        try {
            foodDatabaseTextView.setText(FoodTrackerContract.FoodTrackerEntry._ID + ": " + FoodTrackerContract.FoodTrackerEntry.KEY_NAME + "\n");
            int idColumnIndex = cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(FoodTrackerContract.FoodTrackerEntry.KEY_NAME);
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                foodDatabaseTextView.append(("\n" + currentID + ": " + currentName));
            }
        } finally {
            cursor.close();
        }

    }



}
