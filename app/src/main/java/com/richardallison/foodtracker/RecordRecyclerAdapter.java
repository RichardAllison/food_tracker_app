package com.richardallison.foodtracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class RecordRecyclerAdapter extends RecyclerView.Adapter<RecordRecyclerAdapter.RecordViewHolder>  {

    private ArrayList<Record> recordArrayList;

    public RecordRecyclerAdapter(ArrayList<Record> recordArrayList) {
        this.recordArrayList = recordArrayList;
    }

    @Override
    public RecordRecyclerAdapter.RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.item_record;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        RecordViewHolder viewHolder = new RecordViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecordRecyclerAdapter.RecordViewHolder holder, int position) {
        Record record = recordArrayList.get(position);

        holder.food.setText(record.getFoodName());
        holder.date.setText(record.getDate());
        holder.mealTime.setText(record.getMealtime());

        holder.deleteButton.setTag(record.getID());
    }

    @Override
    public int getItemCount() {
        return recordArrayList.size();
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {

        public TextView date, food, mealTime;
        public Button deleteButton;

        public RecordViewHolder(View itemView) {
            super(itemView);

            deleteButton = itemView.findViewById(R.id.item_record_delete_button);

            date = itemView.findViewById(R.id.item_record_date);
            food = itemView.findViewById(R.id.item_food_record_food_name);
            mealTime = itemView.findViewById(R.id.item_record_mealtime);

        }
    }
}
