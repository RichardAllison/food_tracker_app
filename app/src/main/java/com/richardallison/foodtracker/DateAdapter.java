package com.richardallison.foodtracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {

    private ArrayList<RecordDate> dateArrayList;

    public DateAdapter(ArrayList<RecordDate> dateArrayList) {
        this.dateArrayList = dateArrayList;
    }


    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.item_date;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        DateViewHolder viewHolder = new DateViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DateViewHolder holder, int position) {
        RecordDate recordDate = dateArrayList.get(position);

//        ArrayList<Record> recordsByDate = new ArrayList<>();
//        for(Record record : recordsByDate){
//            if (record.getDate() == recordDate.getDate()) {
//                recordArrayList.add(record);
//            }
//        }


        holder.date.setText(recordDate.getDate());
//        holder.addRecordButton.setTag(food.getID());
//        holder.deleteButton.setTag(food.getID());
    }

    @Override
    public int getItemCount() {
        return dateArrayList.size();
    }

    public class DateViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView foodItems;
//        ImageButton addRecordButton;
//        ImageButton deleteButton;

        public DateViewHolder(View itemView) {
            super(itemView);
//            addRecordButton = itemView.findViewById(R.id.item_food_add_to_record);
//            deleteButton = itemView.findViewById(R.id.item_food_delete_button);
            date = itemView.findViewById(R.id.item_date_date);
            foodItems = itemView.findViewById(R.id.food_items_text_view);
        }
    }
}