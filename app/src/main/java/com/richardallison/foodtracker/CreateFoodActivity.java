package com.richardallison.foodtracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class CreateFoodActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button saveFoodButton;
    EditText nameInput;
    EditText typeInput;
    EditText brandInput;

//    private Uri currentFoodEntryUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_food);

//        setTitle(R.string.new_or_edit_title);
//        Bundle extras = intent.getExtras();
//        Intent intent = getIntent();



        FoodTrackerDbHelper mDbHelper = new FoodTrackerDbHelper(getApplicationContext());
        db = mDbHelper.getWritableDatabase();
        saveFoodButton = findViewById(R.id.save_food);
        nameInput = findViewById(R.id.name_input);
        typeInput = findViewById(R.id.type_input);
        brandInput = findViewById(R.id.brand_input);
    }

    public void onSaveButtonClicked(View button) {
        if (nameInput.getText().length() == 0) return;
        String name = nameInput.getText().toString().trim();
        String type = typeInput.getText().toString().trim();
        String brand = brandInput.getText().toString().trim();
//        Integer.parseInt("1")

        ContentValues contentValues = new ContentValues();
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_NAME, name);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_TYPE, type);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_BRAND, brand);


        long newRowId = db.insert(FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS, null, contentValues);
        Toast.makeText(this, name + " has been added to food database", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, CreateFoodActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
