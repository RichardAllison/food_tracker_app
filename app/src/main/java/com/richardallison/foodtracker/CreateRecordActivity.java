package com.richardallison.foodtracker;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.text.DateFormat.getDateInstance;

public class CreateRecordActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button saveRecordButton;
    Button selectFoodButton;
    TextView recordFoodItem;
    TextView recordDateInput;
    EditText recordMealtimeInput;
    EditText recordPortionSizeInput;
    Food food;
    private DatePickerDialog.OnDateSetListener dateSetListener;

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

        recordDateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateRecordActivity.this, dateSetListener, year, month, day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//                datePickerDialog.getDatePicker().setCalendarViewShown(false);
//                datePickerDialog.getDatePicker().setSpinnersShown(true);
                datePickerDialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month +=1;
                String date = dayOfMonth + "/" + month + "/" + year;
                recordDateInput.setText(date);
            }
        };

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
        if (recordDateInput.getText().toString().length() == 0) return;
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