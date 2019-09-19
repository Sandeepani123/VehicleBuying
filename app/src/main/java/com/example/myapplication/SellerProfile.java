package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DataBase.DBHandler;

import java.util.List;

import static com.example.myapplication.Register.EXTRA_EMAIL;
import static com.example.myapplication.Register.EXTRA_SELLERNAME;

public class SellerProfile extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "com.example.myapplication.username";
    public static final String EXTRA_PASSWORD = "com.example.myapplication.password";
    public static final String EXTRA_MAIL = "com.example.myapplication.email";
    public static final String EXTRA_NAME = "com.example.myapplication.name";
    public static final String EXTRA_PHONE = "com.example.myapplication.phone";

    String txtusername, txtpassword, txtemail, txtname, txtphone;
    DBHandler dbHandler = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_profile);

        Intent intent = getIntent();

        String TXTUSERNAME = intent.getStringExtra(Register.EXTRA_USERNAME);
        String TXTPASSWORD = intent.getStringExtra(Register.EXTRA_PASSWORD);
        String TXTEMAIL = intent.getStringExtra(EXTRA_EMAIL);
        String TXTNAME = intent.getStringExtra(EXTRA_SELLERNAME);
        String TXTPHONE = intent.getStringExtra(Register.EXTRA_PHONE);

        TextView username = findViewById(R.id.txtUserName);
        TextView password = findViewById(R.id.txtPassword);
        TextView email = findViewById(R.id.txtEmail);
        TextView name = findViewById(R.id.TxtName);
        TextView conphone = findViewById(R.id.TxtPhone);

        username.setText(TXTUSERNAME);
        password.setText(TXTPASSWORD);
        email.setText(TXTEMAIL);
        name.setText(TXTNAME);
        conphone.setText(TXTPHONE);


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
        intent.putExtra(EXTRA_MAIL, mailtext);
        intent.putExtra(EXTRA_NAME, sellernametext);
        intent.putExtra(EXTRA_PHONE, phonenotext);

        startActivity(intent);


    }


    public void deleteUser(View view) {

        TextView usename;
        String usnametext;

        usename = findViewById(R.id.txtUserName);

        int res = dbHandler.delete(
                usnametext = usename.getText().toString()
        );

        if (res == 1) {
            Toast.makeText(getApplicationContext(), "Delete Successful", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(getApplicationContext(), "Delete error", Toast.LENGTH_LONG).show();

        }

    }

    public void displaySeller(View view) {

            Intent intent = new Intent(SellerProfile.this,GetAllData.class);

            TextView usnametext = findViewById(R.id.txtUserName);
            TextView pswdtext = findViewById(R.id.txtPassword);
            TextView mailtext = findViewById(R.id.txtEmail);
            TextView nametext = findViewById(R.id.TxtName);
            TextView contactext = findViewById(R.id.TxtPhone);

            String username = usnametext.getText().toString();
            String psword = pswdtext.getText().toString();
            String E_mail =  mailtext.getText().toString();
            String sel_name = nametext.getText().toString();
            String phnum = nametext.getText().toString();

            intent.putExtra(EXTRA_USER_NAME,username);
            intent.putExtra(EXTRA_PASSWORD,psword);
            intent.putExtra(EXTRA_MAIL,E_mail);
            intent.putExtra(EXTRA_NAME,sel_name);
            intent.putExtra(EXTRA_PHONE,phnum);

        startActivity(intent);



    }




}




