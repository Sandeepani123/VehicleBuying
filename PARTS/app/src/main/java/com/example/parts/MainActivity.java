package com.example.parts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    DatabaseHelper myDb;
    EditText editName,editPrice,editDate,editDetails,editID;
    Button btnAddData;
    Button btnViewAll;
    Button btnViewUpdate;
    Button btndelete;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);


        editName = (EditText)findViewById(R.id.editText_name);
        editPrice = (EditText)findViewById(R.id.editText3_price);
        editDate = (EditText)findViewById(R.id.editText8_date);
        editDetails = (EditText)findViewById(R.id.editText6_i);
        editID = (EditText) findViewById(R.id.editText_id);
        btnAddData = (Button)findViewById(R.id.button_add2);
        btnViewAll = (Button)findViewById(R.id.button_view);

        btndelete = (Button)findViewById(R.id.button_delete);

        AddData();
        ViewAll();
        DeleteData();



    }
    public void DeleteData(){
        btndelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb.deleteData(editID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }




    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    public  void onClick(View v){
                        boolean isInserted = myDb.insertData(editName.getText().toString(),editPrice.getText().toString(),editDate.getText().toString(),editDetails.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();



                    }



                }


        );

    }

     public void ViewAll(){
         btnViewAll.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Cursor res = myDb.getAllData();
                         if(res.getCount() == 0) {
                             //show massage
                             showMessage("Error","Nothing found");
                             return;
                         }
                         StringBuffer buffer = new StringBuffer();
                         while(res.moveToNext()){
                             buffer.append("Part Id :" + res.getString(0)+ "\n");
                             buffer.append("Name :" + res.getString(1)+ "\n");
                             buffer.append("Price :" + res.getString(2)+ "\n");
                             buffer.append("Date :" + res.getString(3)+ "\n");
                             buffer.append("Details :" + res.getString(4)+ "\n\n");

                         }

                         //show all data
                         showMessage("Data",buffer.toString());
                     }
                 }
         );
     }
     public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

     }









         }