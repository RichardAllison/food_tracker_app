package com.richardallison.foodtracker;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.richardallison.foodtracker.data.FoodTrackerContract;
import com.richardallison.foodtracker.data.FoodTrackerDbHelper;

public class RecordCursorAdapter extends CursorAdapter {
    public RecordCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_record, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        Button deleteButton = view.findViewById(R.id.delete_record_button);
        long id = cursor.getLong(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry._ID));
        deleteButton.setTag(id);

        TextView date = view.findViewById(R.id.food_record_date);
        date.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_DATE)));

        TextView food = view.findViewById(R.id.food_record_food_name);
        food.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_NAME)));

        TextView mealTime = view.findViewById(R.id.food_record_mealtime);
        mealTime.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME)));

    }




}


