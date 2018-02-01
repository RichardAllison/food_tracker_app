package com.richardallison.foodtracker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.richardallison.foodtracker.models.Record;

import java.util.ArrayList;

public class RecordByDateAdapter extends ArrayAdapter<Record> {
    public RecordByDateAdapter(Context context, ArrayList<Record> records) {
        super(context, 0, records);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
        }


        return listItemView;
    }

}
