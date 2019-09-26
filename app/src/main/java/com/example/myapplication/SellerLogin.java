package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DataBase.DBHandler;

public class SellerLogin extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "com.example.myapplication.username";
    public static final String EXTRA_PASSWORD = "com.example.myapplication.password";
    public static final String EXTRA_EMAIL = "com.example.myapplication.email";
    public static final String EXTRA_SELLERNAME = "com.example.myapplication.sellername";
    public static final String EXTRA_PHONE = "com.example.myapplication.contact";



    DBHandler dbHandler = new DBHandler(this);

    String username,pass,email,name,phone;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);


        DBHandler dbHandler;
        TextView txtusname, txtpswd;

        Intent intent = getIntent();

        String username = intent.getStringExtra(Register.EXTRA_USERNAME);
        String pass = intent.getStringExtra(Register.EXTRA_PASSWORD);
        String email = intent.getStringExtra(Register.EXTRA_EMAIL);
        String name = intent.getStringExtra(Register.EXTRA_SELLERNAME);
        String phone = intent.getStringExtra(Register.EXTRA_PHONE);

        EditText us = findViewById(R.id.txtUserName);
        EditText pa = findViewById(R.id.txtpass);



    }

        public void matchdata(View view){

            if ((username == Register.EXTRA_USERNAME   &&  pass == Register.EXTRA_PASSWORD )) {

                Toast.makeText(getApplicationContext(), "Authorized Person", Toast.LENGTH_SHORT).show();


            } else if (username != Register.EXTRA_USERNAME && pass != Register.EXTRA_PASSWORD) {
                Toast.makeText(getApplicationContext(), "Unauthorized Person", Toast.LENGTH_SHORT).show();


            }






        }


    }




