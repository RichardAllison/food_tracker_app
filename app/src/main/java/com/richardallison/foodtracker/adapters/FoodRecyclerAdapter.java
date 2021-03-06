package com.richardallison.foodtracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.richardallison.foodtracker.models.Food;
import com.richardallison.foodtracker.R;

import java.util.ArrayList;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder> {

    private ArrayList<Food> foodArrayList;

    public FoodRecyclerAdapter(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.item_food;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        FoodViewHolder viewHolder = new FoodViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food food = foodArrayList.get(position);

        holder.name.setText(food.getName());
        holder.type.setText(food.getType());
        holder.brand.setText(food.getBrand());

        holder.addRecordButton.setTag(food.getID());
        holder.deleteButton.setTag(food.getID());
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        public TextView name, type, brand;
        ImageButton addRecordButton;
        ImageButton deleteButton;

        public FoodViewHolder(View itemView) {
            super(itemView);
            addRecordButton = itemView.findViewById(R.id.item_food_add_to_record);
            deleteButton = itemView.findViewById(R.id.item_food_delete_button);
            name = itemView.findViewById(R.id.item_food_name);
            type = itemView.findViewById(R.id.item_food_type);
            brand = itemView.findViewById(R.id.item_food_brand);
        }

    }
}
