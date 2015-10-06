package com.example.supanijitt.myapplication;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txt_user, txt_pass;
    TextView txt_regist;
    Button btn_Login, btn_LoginFb, btn_LoginGp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_user = (EditText)findViewById(R.id.userName);
        txt_pass = (EditText)findViewById(R.id.passWord);
        txt_regist = (TextView)findViewById(R.id.register);
        btn_Login = (Button)findViewById(R.id.btnLogin);
        btn_LoginFb = (Button)findViewById(R.id.btnFb);
        btn_LoginGp = (Button)findViewById(R.id.btnGp);

        btn_Login.setOnClickListener(this);
        btn_LoginFb.setOnClickListener(this);
        btn_LoginGp.setOnClickListener(this);
        txt_regist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String sUsername = txt_user.getText().toString();
        String sPassword = txt_pass.getText().toString();

        switch (v.getId()){
            case R.id.btnLogin :
                Login(sUsername);//Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnFb :
                //Toast.makeText(getApplicationContext(), sUsername , Toast.LENGTH_SHORT).show();
                GotoFacebook();
                break;
            case R.id.btnGp :
                //Toast.makeText(getApplicationContext(), sUsername , Toast.LENGTH_SHORT).show();
                CustomListView();
                break;
            case R.id.register :
                //Toast.makeText(getApplicationContext(), "Register !!!", Toast.LENGTH_LONG).show();
                msgBox("Register..");
                break;
            default: break;
        }
    }

    public void msgBox(String s){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setTitle("Fisrt Dialog");
        alertDialog.setMessage(s);
        alertDialog.show();
    }

    public void Login(String s){
        //Log.d("s : ", s.toString());
        Intent i = new Intent(this, NextPageActivity.class);

        i.putExtra("name", s);
        startActivity(i);
    }

    public void CustomListView(){
        Intent i = new Intent(this, second_page.class);
        startActivity(i);
    }

    public void GotoFacebook(){
        Intent i = new Intent(this, LoginFB_Activity.class);
        startActivity(i);
    }
}
