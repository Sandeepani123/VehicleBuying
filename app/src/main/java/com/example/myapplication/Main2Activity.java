package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {


    private static final String TAG = "ccsl";

    Button commentbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       commentbtn = findViewById(R.id.commentbtn);

       commentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {

              Intent i = new Intent(getApplicationContext(),MainActivity.class);
               startActivity(i);
            }
        });
   }


}
