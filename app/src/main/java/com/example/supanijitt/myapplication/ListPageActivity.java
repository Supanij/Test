package com.example.supanijitt.myapplication;

import com.example.supanijitt.myapplication.CustomAdapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListPageActivity extends Activity {
    private List<ListModel> list_data = new ArrayList<ListModel>();
    String[] itemname = {"A","B","C","D","E"};

    ListView listView;

    private ListView mlist;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        createListData();
        createListView();
        createListClick();
    }

    private void createListData() {
        list_data.add(new ListModel("Left", R.drawable.core01, "Transparency"));
        list_data.add(new ListModel("Down", R.drawable.core02, "Care"));
        list_data.add(new ListModel("Flower", R.drawable.core03, "Intrigrity"));
        list_data.add(new ListModel("Pillow", R.drawable.core04, "Collaboration"));
        list_data.add(new ListModel("Girls", R.drawable.core05, "Achievement"));
    }

    private void createListView(){
        ArrayAdapter<ListModel> adapter = new CustomAdapter(this,list_data);
        listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    public void createListClick(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = list_data.get(position).getImageDesc();

                // Show Alert
                Toast.makeText(getApplicationContext(),"Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}
