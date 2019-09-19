package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserView extends AppCompatActivity {

    String un,pw,em,sn,ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);

        Intent intent = getIntent();

        String UN = intent.getStringExtra(SellerProfile.EXTRA_USER_NAME);
        String PW = intent.getStringExtra(SellerProfile.EXTRA_PASSWORD);
        String EM = intent.getStringExtra(SellerProfile.EXTRA_MAIL);
        String SN = intent.getStringExtra(SellerProfile.EXTRA_NAME);
        String PH = intent.getStringExtra(SellerProfile.EXTRA_PHONE);

        TextView usern = findViewById(R.id.TxtUname);
        TextView passw = findViewById(R.id.TxtPassword);
        TextView Ema = findViewById(R.id.TxtEmail);
        TextView Sellname = findViewById(R.id.TxtName);
        TextView phne = findViewById(R.id.TxtPhone);

        usern.setText(UN);
        passw.setText(PW);
        Ema.setText(EM);
        Sellname.setText(SN);
        phne.setText(PH);



    }
}
