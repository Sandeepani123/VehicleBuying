package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DataBase.DBhandling;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button sendbutton;
    CheckBox checkBox4;
    DBhandling dBhandling;
    TextView txtComment;

    public static final String EXTRA_COMMENT_NAME = "com.example.myapplication";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dBhandling = new DBhandling(this);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
            }
        });

    }


        public void send(View view){

            String name;

            Intent intent = new Intent(MainActivity.this,Main3Activity.class);

            txtComment = (TextView) findViewById(R.id.txtcomment);

            name = txtComment.getText().toString();

            long rownum = dBhandling.send(name);

            if(rownum > 0){

                Toast.makeText(getApplicationContext(),"Send Successful",Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_SHORT).show();

            }



            intent.putExtra(EXTRA_COMMENT_NAME,name);
            startActivity(intent);




        }

    }


