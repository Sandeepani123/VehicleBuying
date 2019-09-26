package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DataBase.DBhandling;

import org.w3c.dom.Text;

import static java.nio.file.attribute.AclEntryPermission.DELETE;

public class Main3Activity extends AppCompatActivity {

    String cn;
    TextView comview;
    EditText commname;
    DBhandling dBhandling;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();

        dBhandling = new DBhandling(this);

        String cn = intent.getStringExtra(MainActivity.EXTRA_COMMENT_NAME);

        TextView comview = (TextView) findViewById(R.id.txtcommview);

        comview.setText(cn);
    }


    public void update_comment(View view){

        EditText commname = findViewById(R.id.txtcommview);


        String commentn;

        boolean res = dBhandling.updateInfo(
                commentn = commname.getText().toString()
        );

        if (res == true) {
            Toast.makeText(getApplicationContext(), "Update suceesfull", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "Update got error", Toast.LENGTH_LONG).show();

        }



    }


    public  void  deleteSeller(View view){

        Integer deleteUser = dBhandling.deleteUser(comview.getText().toString());

                if(deleteUser > 0){

                    Toast.makeText(getApplicationContext(),"Delete Successful",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Deletion Unsuccess",Toast.LENGTH_LONG).show();

                }
            }


        }
