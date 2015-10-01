package com.example.supanijitt.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NextPageActivity extends AppCompatActivity {
    TextView dispName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        dispName = (TextView)findViewById(R.id.displayName);

        Intent _b = getIntent();
        String str = _b.getStringExtra("name");

        //dispName.setText(str);
        if(_b == null || str.equals("")){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.setTitle("Error Dialog");
            alertDialog.setMessage("No display name...");

            alertDialog.show();
        }
        else {
            //String str = _b.getStringExtra("name");
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setPositiveButton("ok", null);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.setTitle("Success Dialog");
            alertDialog.setMessage(str);

            alertDialog.show();

            dispName.setText(str);
        }
    }


}
