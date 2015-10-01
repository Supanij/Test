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
    com.example.supanijitt.myapplication.ListModel data[] = null;


    public CustomAdapter(Context context, com.example.supanijitt.myapplication.ListModel[] data) {
        super(context, R.layout.mylist, data);

        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row = view;
        ListModelHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.mylist, parent, false);

            holder = new ListModelHolder();
            holder.imgUrl = (ImageView)row.findViewById(R.id.icon);
            holder.uName = (TextView)row.findViewById(R.id.Itemname);

            row.setTag(holder);
        }
        else
        {
            holder = (ListModelHolder)row.getTag();
        }

        ListModel list = data[position];
        holder.uName.setText(list.UserName);
        holder.imgUrl.setImageResource(list.ImageUrl);

        return row;
    }

    static class ListModelHolder
    {
        ImageView imgUrl;
        TextView uName;
    }
    /*public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.Itemname);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;

    };*/
}
