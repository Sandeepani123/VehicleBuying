package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.DataBase.DBHandler;


public class Register extends AppCompatActivity {

    TextView txtusername, txtpassword, txtemail, txtname, txtphone;
    DBHandler dbHandler;
    EditText mail, password, username;
    Button register;
    //ListView listView ;
    //SearchView searchSell;




    public static final String EXTRA_USERNAME = "com.example.myapplication.username";
    public static final String EXTRA_PASSWORD = "com.example.myapplication.password";
    public static final String EXTRA_EMAIL = "com.example.myapplication.email";
    public static final String EXTRA_SELLERNAME = "com.example.myapplication.sellername";
    public static final String EXTRA_PHONE = "com.example.myapplication.phone";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHandler = new DBHandler(this);

        mail = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);



        mail.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if(mail.getText().length() > 20){
                    mail.setError("Email is an invalid");
                }

            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(password.getText().length() > 10){

                    password.setError("Password is an invalid");

                }
            }
        });













    }

    /*private boolean validateEmail() {

        String inputemail = textInputEmail.getEditText().getText().toString().trim();

        if (inputemail.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        }
         else {
            textInputEmail.setError(null);
            return true;

        }

    }

    private boolean validatePassword(){

        String inputpass = textInputPassword.getEditText().getText().toString().trim();

        if(inputpass.isEmpty()){
            textInputPassword.setError("Field can't be empty");
            return false;
        }else{
                textInputPassword.setError(null);
                return true;

             }

    }

    public void confirmInput(View v){

        if(!validateEmail() | !validatePassword()){
            return;

        }

        String input = "Email " +textInputEmail.getEditText().toString();
        input += "\n";

        input += "Password " +textInputPassword.getEditText().getText().toString();

    }*/

    public void addUnregDetails(View view) {


        Intent intent = new Intent(Register.this,SellerProfile.class);
        //Intent intent1 = new Intent(Register.this,SellerLogin.class);

        txtusername = findViewById(R.id.txtUserName);
        txtpassword = findViewById(R.id.txtPassword);
        txtemail = findViewById(R.id.txtEmail);
        txtname = findViewById(R.id.TxtName);
        txtphone = findViewById(R.id.TxtPhone);


        String usname = txtusername.getText().toString();
        String pwd = txtpassword.getText().toString();
        String mail = txtemail.getText().toString();
        String name = txtname.getText().toString();
        String contact = txtphone.getText().toString();


        long rownum = dbHandler.addDetails(usname, pwd, mail, name, contact);

        if (rownum > 0) {
            Toast.makeText(getApplicationContext(),"Data Added Success",Toast.LENGTH_LONG).show();

        }

        else {
                Toast.makeText(getApplicationContext(),"Data Unsuccess Added",Toast.LENGTH_LONG).show();

             }



        //password.setError("Enter password");

        intent.putExtra(EXTRA_USERNAME,usname);
        intent.putExtra(EXTRA_PASSWORD,pwd);
        intent.putExtra(EXTRA_EMAIL,mail);
        intent.putExtra(EXTRA_SELLERNAME,name);
        intent.putExtra(EXTRA_PHONE,contact);

        startActivity(intent);


    }

    public void Login(View view)
    {

        //String usname,pwd, mail,name,contact;

        txtusername = findViewById(R.id.txtUserName);
        txtpassword = findViewById(R.id.txtPassword);
        txtemail = findViewById(R.id.txtEmail);
        txtname = findViewById(R.id.TxtName);
        txtphone = findViewById(R.id.TxtPhone);


        String Usern = txtusername.getText().toString();
        String Pass = txtpassword.getText().toString();
        String mai = txtemail.getText().toString();
        String selln = txtname.getText().toString();
        String cont = txtphone.getText().toString();


        Intent intent = new Intent(Register.this,SellerLogin.class);
        intent.putExtra(EXTRA_USERNAME,Usern);
        intent.putExtra(EXTRA_PASSWORD,Pass);
        intent.putExtra(EXTRA_EMAIL,mai);
        intent.putExtra(EXTRA_SELLERNAME,selln);
        intent.putExtra(EXTRA_PHONE,cont);



        startActivity(intent);


    }







}










