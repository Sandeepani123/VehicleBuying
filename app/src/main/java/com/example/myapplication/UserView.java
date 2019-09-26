package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class UserView extends AppCompatActivity {

    String un,pw,em,sn,ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);

        Intent intent = getIntent();

        String UN = intent.getStringExtra(SellerProfile.EXTRA_USER_NAME);
        String PW = intent.getStringExtra(SellerProfile.EXTRA_PASSWORD);
        String EM = intent.getStringExtra(SellerProfile.EXTRA_EMAIL);
        String SN = intent.getStringExtra(SellerProfile.EXTRA_SELLERNAME);
        String PH = intent.getStringExtra(SellerProfile.EXTRA_PHONE);

        EditText usern = findViewById(R.id.TextUser);
        EditText passw = findViewById(R.id.TextPass);
        EditText Ema = findViewById(R.id.TextM);
        EditText Sellname = findViewById(R.id.TxtName);
        EditText phne = findViewById(R.id.TxtPhone);

        usern.setText(UN);
        passw.setText(PW);
        Ema.setText(EM);
        Sellname.setText(SN);
        phne.setText(PH);



    }
}
