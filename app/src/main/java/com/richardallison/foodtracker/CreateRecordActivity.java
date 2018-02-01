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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;
import com.richardallison.foodtracker.data.RecordOperations;

import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateRecordActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button saveRecordButton;
    Button selectFoodButton;
    TextView recordFoodItem;
    TextView recordDateInput;
//    EditText recordMealtimeInput;
    EditText recordPortionSizeInput;
    Food food;
    Spinner mealSpinner;

    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_record);

        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra("food");

        FoodTrackerDbHelper mDbHelper = new FoodTrackerDbHelper(getApplicationContext());
        db = mDbHelper.getWritableDatabase();

        saveRecordButton = findViewById(R.id.record_save_button);
        selectFoodButton = findViewById(R.id.record_select_food_button);
        recordFoodItem = findViewById(R.id.record_food_item);
        recordDateInput = findViewById(R.id.record_date_input);
        recordPortionSizeInput = findViewById(R.id.record_portion_size_input);


        // Spinner
        mealSpinner = findViewById(R.id.record_mealtime_spinner);
        mealSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> mealTimes = new ArrayList<>();
        mealTimes.add("Breakfast");
        mealTimes.add("Morning snack");
        mealTimes.add("Lunch");
        mealTimes.add("Afternoon snack");
        mealTimes.add("Dinner");
        mealTimes.add("Evening snack");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mealTimes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mealSpinner.setAdapter(dataAdapter);

        // date picker
        recordDateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateRecordActivity.this, dateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                datePickerDialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                recordDateInput.setText(date);
            }
        };


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

        String date = recordDateInput.getText().toString().trim();
        String mealtime = ((Spinner)findViewById(R.id.record_mealtime_spinner)).getSelectedItem().toString();
        String portion = recordPortionSizeInput.getText().toString().trim();

        Record record = new Record(date, food.getID(), mealtime, portion);

        RecordOperations recordOperations = new RecordOperations(this);
        recordOperations.open();
        Record newRecord = recordOperations.addRecord(record);
        recordOperations.close();

        Toast.makeText(this, food.getName() + newRecord.id + " has been added to records", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, ViewAllRecordsActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}