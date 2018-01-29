package com.richardallison.foodtracker;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class ViewFoodDatabaseActivity extends AppCompatActivity {

    SQLiteDatabase db;
    FoodTrackerDbHelper mDbHelper;
    Cursor cursor;

    FoodCursorAdapter foodCursorAdapter;

    Button createFoodButton;
    ListView foodDatabaseListView;
//    View emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_database);

        createFoodButton = findViewById(R.id.create_food_button);
        foodDatabaseListView = findViewById(R.id.food_database_list);

        foodDatabaseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor foodItemCursor = (Cursor) parent.getItemAtPosition(position);
                Long iD = foodItemCursor.getLong(foodItemCursor.getColumnIndex("_id"));
                String name = foodItemCursor.getString(foodItemCursor.getColumnIndex("name"));
                String brand = foodItemCursor.getString(foodItemCursor.getColumnIndex("brand"));
                Food food = new Food(name, brand);
                food.setID(iD);

                Intent intent = new Intent(ViewFoodDatabaseActivity.this, CreateRecordActivity.class);
                intent.putExtra("food", food);
                startActivity(intent);
            }
        });

        displayFoodDatabase();

    }




    public void onCreateFoodButtonClicked(View button) {
        Intent intent = new Intent(this, CreateFoodActivity.class);
        startActivity(intent);
    }

//    public void onListItemClick(View listItem) {

//        Cursor foodItemCursor = (Cursor) listItem.getTag();
//        Long id = foodItemCursor.getLong(foodItemCursor.getColumnIndex("_id"));
//        String name = foodItemCursor.getString(foodItemCursor.getColumnIndex("name"));
//        String brand = foodItemCursor.getString(foodItemCursor.getColumnIndex("brand"));
//        Food food = new Food(name, brand);
//        food.setID(id);
//
//        Intent intent = new Intent(this, CreateRecordActivity.class);
//        intent.putExtra("food", food);
//        startActivity(intent);
//    }

    private void displayFoodDatabase() {

        mDbHelper = new FoodTrackerDbHelper(this);
        db = mDbHelper.getReadableDatabase();

        String[] columns = {
                FoodTrackerContract.FoodTrackerEntry._ID,
                FoodTrackerContract.FoodTrackerEntry.KEY_NAME,
                FoodTrackerContract.FoodTrackerEntry.KEY_TYPE,
                FoodTrackerContract.FoodTrackerEntry.KEY_BRAND
        };

        String sortOrder =
                FoodTrackerContract.FoodTrackerEntry._ID + " ASC";

        cursor = db.query(
                FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS,
                columns,
                null,
                null,
                null,
                null,
                sortOrder
        );

        foodCursorAdapter = new FoodCursorAdapter(this, cursor);
        foodDatabaseListView.setAdapter(foodCursorAdapter);

//        emptyView = findViewById(R.id.empty_view);
//        foodDatabaseListView.setEmptyView(emptyView);
    }




//    public void onListItemClick(ListView listView, View view, int position, long id) {
//        Intent intent = new Intent();
//        intent.putExtra("Food", cursor.getPosition());
//    }




//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//        Intent intent = new Intent(ViewFoodDatabaseActivity.this, CreateFoodActivity.class);
//
//        Uri currentFoodEntryUri = ContentUris.withAppendedId(FoodTrackerContract.FoodTrackerEntry.CONTENT_URI, id);
//
//        intent.setData(currentFoodEntryUri);
//    }

}



