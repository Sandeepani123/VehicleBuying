package com.example.vehicalparts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editDetails,editNumber,editTextId;
    Button btnAddData;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText3_name);
        editDetails = (EditText)findViewById(R.id.editText_details);
        editNumber = (EditText)findViewById(R.id.editText5_number);
        editTextId = (EditText)findViewById(R.id.editText_id);
        btnAddData = (Button)findViewById(R.id.button4_add);
        btnviewUpdate = (Button)findViewById(R.id.button_update);
        AddData();
        UpdateData();

    }
    public void UpdateData(){
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editDetails.getText().toString(),
                                editNumber.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Not Updated",Toast.LENGTH_LONG).show();


                    }
                }
        );
    }
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      boolean isInserted =  myDb.insertData(editName.getText().toString(),
                                editDetails.getText().toString(),
                                editNumber.getText().toString());
                      if(isInserted == true)
                          Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                      else
                          Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();



                    }
                }
        );
    }
}
