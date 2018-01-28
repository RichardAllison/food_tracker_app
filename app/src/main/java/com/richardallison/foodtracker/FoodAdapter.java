package com.richardallison.foodtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(Context context, ArrayList<Food> food) {
        super(context,0, food);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        Food currentFood = getItem(position);

        TextView name = listItemView.findViewById(R.id.name);
        name.setText(currentFood.getName().toString());

        TextView type = listItemView.findViewById(R.id.type);
        type.setText(currentFood.getType());

        TextView brand = listItemView.findViewById(R.id.brand);
        brand.setText(currentFood.getBrand().toString());

        return listItemView;
    }

}
