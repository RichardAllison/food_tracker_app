package com.richardallison.foodtracker;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.richardallison.foodtracker.data.FoodTrackerContract;

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

        TextView name = view.findViewById(R.id.food_record_date);
        name.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_DATE)));

        TextView type = view.findViewById(R.id.food_record_food_name);
        type.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_FD_ID)));

        TextView brand = view.findViewById(R.id.food_record_mealtime);
        brand.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_MEAL_TIME)));

    }

}


