package com.richardallison.foodtracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class CreateFoodActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button saveFoodButton;
    EditText nameInput;
    EditText typeInput;
    EditText brandInput;
    Button advancedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_food);

        FoodTrackerDbHelper mDbHelper = new FoodTrackerDbHelper(getApplicationContext());
        db = mDbHelper.getWritableDatabase();
        saveFoodButton = findViewById(R.id.food_save_button);
        nameInput = findViewById(R.id.food_name_input);
        typeInput = findViewById(R.id.food_type_input);
        brandInput = findViewById(R.id.food_brand_input);
        advancedButton = findViewById(R.id.advanced_button);
    }

    public void onSaveButtonClicked(View button) {
        if (nameInput.getText().length() == 0) return;
        String name = nameInput.getText().toString().trim();
        String type = typeInput.getText().toString().trim();
        String brand = brandInput.getText().toString().trim();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_NAME, name);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_TYPE, type);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_BRAND, brand);

        long newRowId = db.insert(FoodTrackerContract.FoodTrackerEntry.TABLE_FOOD_AND_DRINKS, null, contentValues);
        Toast.makeText(this, name + " has been added to food database", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, ViewFoodDatabaseActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onAdvancedSwitchClick(View switchButton) {
        TextView caloriesLabel = findViewById(R.id.food_calories_label);
        TextView caloriesInput = findViewById(R.id.food_calories_input);
        TextView fatLabel = findViewById(R.id.food_fat_label);
        TextView fatInput = findViewById(R.id.food_fat_input);
        TextView carbsLabel = findViewById(R.id.food_carbs_label);
        TextView carbsInput = findViewById(R.id.food_carbs_input);
        TextView proteinLabel = findViewById(R.id.food_protein_label);
        TextView proteinInput = findViewById(R.id.food_protein_input);
        TextView saltLabel = findViewById(R.id.food_salt_label);
        TextView saltInput = findViewById(R.id.food_salt_input);
        TextView sugarLabel = findViewById(R.id.food_sugar_label);
        TextView sugarInput = findViewById(R.id.food_sugar_input);
        caloriesLabel.setVisibility(View.VISIBLE);
        caloriesInput.setVisibility(View.VISIBLE);
        fatLabel.setVisibility(View.VISIBLE);
        fatInput.setVisibility(View.VISIBLE);
        carbsLabel.setVisibility(View.VISIBLE);
        carbsInput.setVisibility(View.VISIBLE);
        proteinLabel.setVisibility(View.VISIBLE);
        proteinInput.setVisibility(View.VISIBLE);
        saltLabel.setVisibility(View.VISIBLE);
        saltInput.setVisibility(View.VISIBLE);
        sugarLabel.setVisibility(View.VISIBLE);
        sugarInput.setVisibility(View.VISIBLE);
        advancedButton.setVisibility(View.INVISIBLE);
    }

}
