package com.example.supanijitt.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class second_page extends AppCompatActivity {
    String[] itemname = {"A","B","C","D","E"};
    Integer[] imgid={
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };
    ListModel list_data[] = new ListModel[]
            {
                    new ListModel("Left",R.drawable.image1,""),
                    new ListModel("Down",R.drawable.image2,""),
                    new ListModel("Flower",R.drawable.image3,""),
                    new ListModel("Pillow",R.drawable.image4,""),
                    new ListModel("Girls",R.drawable.image5,"")
            };
    ListView listView;
    private ListView mlist;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        listView = (ListView)findViewById(R.id.list);
        //mlist = (ListView)findViewById(R.id.list)
        CustomAdapter adapter = new CustomAdapter(this, list_data);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itemname);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),"Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}
