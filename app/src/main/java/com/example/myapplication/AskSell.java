package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AskSell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_sell);

        setTitle("Dashboard");
    }

    public void Login(View view)
    {
        Intent intent = new Intent(AskSell.this,SellerLogin.class);
        startActivity(intent);

    }

    public void Register(View view){

        Intent intent = new Intent(AskSell.this,Register.class);
        startActivity(intent);

    }
}
