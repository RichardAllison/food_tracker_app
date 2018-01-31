package com.richardallison.foodtracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.richardallison.foodtracker.data.FoodOperations;
import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class ViewFoodDatabaseActivity extends AppCompatActivity {

    SQLiteDatabase db;
    FoodTrackerDbHelper dbHelper;
    FoodOperations foodOperations;

    Cursor cursor;

    FoodCursorAdapter foodCursorAdapter;

    Button createFoodButton;
    ListView foodDatabaseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_database);

        createFoodButton = findViewById(R.id.create_food_button);
        foodDatabaseListView = findViewById(R.id.food_database_list);

        displayFoodDatabase();

    }

    public void onCreateFoodButtonClicked(View button) {
        Intent intent = new Intent(this, CreateFoodActivity.class);
        startActivity(intent);
    }


    public void onDeleteFoodItemButtonClicked(View button) {
        long id = (long) button.getTag();
        foodOperations = new FoodOperations(ViewFoodDatabaseActivity.this);
        foodOperations.open();
        boolean foodItemRemoved = foodOperations.removeFood(id);
        if (foodItemRemoved) {
            Toast.makeText(this, "Record deleted", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ViewFoodDatabaseActivity.class);
            startActivity(intent);
        }
        foodOperations.close();
    }

    public void onAddRecordButtonClicked(View button) {
        long id = (long) button.getTag();
        foodOperations = new FoodOperations(ViewFoodDatabaseActivity.this);
        foodOperations.open();
        Food food = foodOperations.getFood(id);
        foodOperations.close();
        Intent intent = new Intent(this, CreateRecordActivity.class);
        intent.putExtra("food", food);
        startActivity(intent);
    }


    private void displayFoodDatabase() {
        dbHelper = new FoodTrackerDbHelper(this);
        db = dbHelper.getReadableDatabase();

        String[] columns = {
                FoodTrackerContract.FoodTrackerEntry._ID,
                FoodTrackerContract.FoodTrackerEntry.KEY_NAME,
                FoodTrackerContract.FoodTrackerEntry.KEY_TYPE,
                FoodTrackerContract.FoodTrackerEntry.KEY_BRAND
        };

//        String sortOrder =
//                FoodTrackerContract.FoodTrackerEntry._ID + " ASC";

        cursor = db.query(
                FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        foodCursorAdapter = new FoodCursorAdapter(this, cursor);
        foodDatabaseListView.setAdapter(foodCursorAdapter);

    }

}



