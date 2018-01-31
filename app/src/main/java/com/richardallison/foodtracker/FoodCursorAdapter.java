package com.richardallison.foodtracker;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.richardallison.foodtracker.data.FoodTrackerContract;

public class FoodCursorAdapter extends CursorAdapter {

    public FoodCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        view.setTag(getItem(cursor.getPosition()));
        ImageButton deleteButton = view.findViewById(R.id.item_food_delete_button);
        ImageButton addRecordButton = view.findViewById(R.id.item_food_add_to_record);
        long id = cursor.getLong(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry._ID));
        deleteButton.setTag(id);
        addRecordButton.setTag(id);

        TextView name = view.findViewById(R.id.item_food_name);
        name.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_NAME)));

        TextView type = view.findViewById(R.id.item_food_type);
        type.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_TYPE)));

        TextView brand = view.findViewById(R.id.item_food_brand);
        brand.setText(cursor.getString(cursor.getColumnIndexOrThrow(FoodTrackerContract.FoodTrackerEntry.KEY_BRAND)));

    }
}
