package com.example.supanijitt.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SupanijItt on 10/1/2015.
 */
public class CustomAdapter extends ArrayAdapter<ListModel> {

    Context context;
    List<ListModel> data;


    public CustomAdapter(Context context, List<ListModel> data) {
        super(context, R.layout.mylist, data);

        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View itemView = view;

        if(itemView == null)
        {

            LayoutInflater layout = ((Activity)context).getLayoutInflater();
            itemView = layout.inflate(R.layout.mylist, parent, false);
        }

        ListModel list = data.get(position);

        ImageView imageView = (ImageView)itemView.findViewById(R.id.icon);
        imageView.setImageResource(list.getImageUrl());

        TextView lText = (TextView)itemView.findViewById(R.id.itemName);
        lText.setText(list.getUserName());

        TextView sText = (TextView)itemView.findViewById(R.id.itemDesc);
        sText.setText(list.getImageDesc());

        return itemView;
    }

}
