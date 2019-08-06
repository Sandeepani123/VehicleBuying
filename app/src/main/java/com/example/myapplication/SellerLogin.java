package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SellerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);

        setTitle("Login");
    }
    public void register(View view){

        Intent intent = new Intent(SellerLogin.this,Register.class);
        startActivity(intent);

    }

    public void sendforgot(View view){

        Intent intent = new Intent(SellerLogin.this,Forgot.class);
        startActivity(intent);

    }
}
