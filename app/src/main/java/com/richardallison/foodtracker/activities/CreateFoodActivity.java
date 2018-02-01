package com.richardallison.foodtracker.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.richardallison.foodtracker.adapters.DateAdapter;
import com.richardallison.foodtracker.R;
import com.richardallison.foodtracker.models.Record;
import com.richardallison.foodtracker.data.DateOperations;
import com.richardallison.foodtracker.data.FoodOperations;
import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;
import com.richardallison.foodtracker.data.RecordOperations;

public class CreateFoodActivity extends AppCompatActivity {

    SQLiteDatabase db;
    FoodOperations foodOperations;

    Button saveFoodButton;
    EditText nameInput;
    EditText typeInput;
    EditText brandInput;
    EditText servingSizeInput;
    EditText caloriesInput;
    EditText carbsInput;
    EditText fatInput;
    EditText proteinInput;
    EditText saltInput;
    EditText sugarInput;
    Button advancedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_food);

        FoodTrackerDbHelper dbHelper = new FoodTrackerDbHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        saveFoodButton = findViewById(R.id.food_save_button);
        nameInput = findViewById(R.id.food_name_input);
        typeInput = findViewById(R.id.food_type_input);
        brandInput = findViewById(R.id.food_brand_input);
        advancedButton = findViewById(R.id.advanced_button);
        servingSizeInput = findViewById(R.id.food_serving_size_input);
        caloriesInput = findViewById(R.id.food_calories_input);
        carbsInput = findViewById(R.id.food_carbs_input);
        fatInput = findViewById(R.id.food_fat_input);
        proteinInput = findViewById(R.id.food_protein_input);
        saltInput = findViewById(R.id.food_salt_input);
        sugarInput = findViewById(R.id.food_sugar_input);
    }

    public void onSaveButtonClicked(View button) {
        if (nameInput.getText().length() == 0) return;
        String name = nameInput.getText().toString().trim();
        String type = typeInput.getText().toString().trim();
        String brand = brandInput.getText().toString().trim();
        String servingSize = servingSizeInput.getText().toString().trim();
        String calories = caloriesInput.getText().toString().trim();
        String carbs = carbsInput.getText().toString().trim();
        String fat = fatInput.getText().toString().trim();
        String protein = proteinInput.getText().toString().trim();
        String salt = saltInput.getText().toString().trim();
        String sugar = sugarInput.getText().toString().trim();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_NAME, name);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_TYPE, type);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_BRAND, brand);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_SERVING_SIZE, servingSize);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_CALORIES, calories);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_CARBOHYDRATES, carbs);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_FAT, fat);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_PROTEIN, protein);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_SODIUM, salt);
        contentValues.put(FoodTrackerContract.FoodTrackerEntry.KEY_SUGAR, sugar);

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
