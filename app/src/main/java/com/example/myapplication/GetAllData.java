package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Filter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.DataBase.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class GetAllData extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    DBHandler db;
    ArrayList<String> ListUsers;
    ArrayAdapter<String> adapter;
    String USERNAME;
    String PASSWORD;
    String EMIAL;
    String NAME;
    String PHONE;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_get_all_data);

        String usnme;
        String psw;
        String mai;
        String name;
        String cont;

        db = new DBHandler(this);

        Intent intent = getIntent();

        usnme = intent.getStringExtra(SellerProfile.EXTRA_USER_NAME);
        psw = intent.getStringExtra(SellerProfile.EXTRA_PASSWORD);
        mai = intent.getStringExtra(SellerProfile.EXTRA_MAIL);
        name = intent.getStringExtra(SellerProfile.EXTRA_NAME);
        cont = intent.getStringExtra(SellerProfile.EXTRA_PHONE);

        listView = findViewById(R.id.listview);

        ListUsers = new ArrayList<>();

        ListUsers.add(usnme);
        ListUsers.add(psw);
        ListUsers.add(mai);
        ListUsers.add(name);
        ListUsers.add(cont);

        adapter = new ArrayAdapter<String>(this,R.layout.activity_get_all_data);

        listView.setAdapter(adapter);








    }



}













