package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.recyclerview.widget.ListAdapter;

import android.app.Notification;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DataBase.DBHandler;

import java.util.ArrayList;
//import static com.example.myapplication.Register.EXTRA_EMAIL;
//import static com.example.myapplication.Register.EXTRA_SELLERNAME;
//import static com.example.myapplication.ViewSellers.EXTRA_ID;

public class SellerProfile extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "com.example.myapplication.username";
    public static final String EXTRA_PASSWORD = "com.example.myapplication.password";
    public static final String EXTRA_EMAIL = "com.example.myapplication.email";
    public static final String EXTRA_SELLERNAME = "com.example.myapplication.name";
    public static final String EXTRA_PHONE = "com.example.myapplication.phone";

    String username, password, email, name, phone;
    TextView TxtName;
    //ListView listView;
    Button viewall;
    Button btndel;
    //private AdapterView sellview;
    DBHandler dbHandler;
    //private Message message;
    //private AdapterView.OnItemClickListener adapterView;
    //int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_profile);

        dbHandler = new DBHandler(this);

        viewall = (Button)findViewById(R.id.viewAll);

        //listView = findViewById(R.id.sellList);

        Intent intent = getIntent();

        String username = intent.getStringExtra(Register.EXTRA_USERNAME);
        String password = intent.getStringExtra(Register.EXTRA_PASSWORD);
        String email = intent.getStringExtra(Register.EXTRA_EMAIL);
        String name = intent.getStringExtra(Register.EXTRA_SELLERNAME);
        String phone = intent.getStringExtra(Register.EXTRA_PHONE);

        TextView Username = findViewById(R.id.txtUserName);
        TextView Passowrd = findViewById(R.id.txtPassword);
        TextView Email = findViewById(R.id.txtEmail);
        TextView Name  = findViewById(R.id.TxtName);
        TextView Phone = findViewById(R.id.TxtPhone);

        Username.setText(username);
        Passowrd.setText(password);
        Email.setText(email);
        Name.setText(name);
        Phone.setText(phone);

        //public void SellerList(){}



    }


    public void updateDetails(View view) {

        Intent intent = new Intent(SellerProfile.this, UserView.class);

        EditText usename = findViewById(R.id.txtUserName);
        EditText pswd = findViewById(R.id.txtPassword);
        EditText mail = findViewById(R.id.txtEmail);
        EditText sellername = findViewById(R.id.TxtName);
        EditText phoneno = findViewById(R.id.TxtPhone);


        String usnametext, pswdtext, mailtext, sellernametext, phonenotext;

        boolean res = dbHandler.updateInfo(
                usnametext = usename.getText().toString(),
                pswdtext = pswd.getText().toString(),
                mailtext = mail.getText().toString(),
                sellernametext = sellername.getText().toString(),
                phonenotext = phoneno.getText().toString()

        );

        if (res == true) {
            Toast.makeText(getApplicationContext(), "Update suceesfull", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "Update got error", Toast.LENGTH_LONG).show();

        }

        intent.putExtra(EXTRA_USER_NAME, usnametext);
        intent.putExtra(EXTRA_PASSWORD, pswdtext);
        intent.putExtra(EXTRA_EMAIL, mailtext);
        intent.putExtra(EXTRA_SELLERNAME, sellernametext);
        intent.putExtra(EXTRA_PHONE, phonenotext);

        startActivity(intent);


    }

    public void viewdata(View view){

         //show (Button) = findViewById(R.id.viewAll);

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor data = dbHandler.getSeller();
                if(data.getCount() == 0){

                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (data.moveToNext()){

                    buffer.append("User Name" +data.getString(0)+ "\n");
                    buffer.append("Password" +data.getString(1)+ "\n");
                    buffer.append("Email" +data.getString(2)+"\n");
                    buffer.append("Seller Name" +data.getString(3)+"\n");
                    buffer.append("Contatct" +data.getString(4)+"\n\n");

                    //ShowableListMenu("Data",buffer.toString());
                    showMessage("Data",buffer.toString());

                }

            }
        });


    }

    public void showMessage(String title,String msg){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();





    }

    public  void  deleteSeller(View view){

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deleterow = dbHandler.deleteUser(TxtName.getText().toString());

                if(deleterow > 0){

                    Toast.makeText(SellerProfile.this,"Delete Successful",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(SellerProfile.this,"Deletion Unsuccess",Toast.LENGTH_LONG).show();

                }
            }
        });






    }




}






