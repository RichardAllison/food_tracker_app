package com.richardallison.foodtracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class CreateRecordActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button saveRecordButton;
    Button selectFoodButton;
    TextView recordFoodItem;
    EditText recordDateInput;
    EditText recordMealtimeInput;
    EditText recordPortionSizeInput;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_record);

        FoodTrackerDbHelper mDbHelper = new FoodTrackerDbHelper(getApplicationContext());
        db = mDbHelper.getWritableDatabase();
        saveRecordButton = findViewById(R.id.save_record_button);
        selectFoodButton = findViewById(R.id.record_select_food_button);
        recordFoodItem = findViewById(R.id.record_food_item);
        recordDateInput = findViewById(R.id.record_date_input);
        recordMealtimeInput = findViewById(R.id.record_mealtime_input);
        recordPortionSizeInput = findViewById(R.id.record_portion_size_input);

        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra("food");
        if (food != null) {
            recordFoodItem.setText(food.getName());
        }
    }

    public void onSelectFoodButtonClicked(View button) {
        Intent intent = new Intent(this, ViewFoodDatabaseActivity.class);
        startActivity(intent);
    }

    public void onSaveRecordButtonClicked(View button) {
        if (food == null) return;
//        String food = recordFoodInput.getText().toString().trim();

        String date = recordDateInput.getText().toString().trim();
        String mealtime = recordMealtimeInput.getText().toString().trim();
        String portion = recordPortionSizeInput.getText().toString().trim();
//        Integer.parseInt("1")

        ContentValues contentValues = new ContentValues();
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID, food.getID());
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_DATE, date);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME, mealtime);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_PORTION_SIZE, portion);


        long newRowId = db.insert(FoodTrackerContract.FoodTrackerEntry.TABLE_RECORDS, null, contentValues);


        Toast.makeText(this, food.getName() + " has been added to records", Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(this, CreateRecordActivity.class);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }
}