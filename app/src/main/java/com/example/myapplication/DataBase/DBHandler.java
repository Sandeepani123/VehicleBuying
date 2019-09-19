package com.example.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME =  "SellerInfo.db";


    public DBHandler(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Unregistered_Seller.UnregSeller.TABLE_NAME + " (" +
                        Unregistered_Seller.UnregSeller._ID + " INTEGER PRIMARY KEY," +
                        Unregistered_Seller.UnregSeller.COLUMN_NAME_USERNAME + " TEXT," +
                        Unregistered_Seller.UnregSeller.COLUMN_PASSWORD + " TEXT," +
                        Unregistered_Seller.UnregSeller.COLUMN_NAME_EMAIL + " TEXT," +
                        Unregistered_Seller.UnregSeller.COLUMN_NAME_NAME + " TEXT," +
                        Unregistered_Seller.UnregSeller.COLUMN_NAME_PHONE + " TEXT)";

                        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addDetails(String username,String password,String Email,String Name,String phone){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Unregistered_Seller.UnregSeller.COLUMN_NAME_USERNAME,username);
        values.put(Unregistered_Seller.UnregSeller.COLUMN_PASSWORD,password);
        values.put(Unregistered_Seller.UnregSeller.COLUMN_NAME_EMAIL,Email);
        values.put(Unregistered_Seller.UnregSeller.COLUMN_NAME_NAME,Name);
        values.put(Unregistered_Seller.UnregSeller.COLUMN_NAME_PHONE,phone);

        long newrowid = db.insert(Unregistered_Seller.UnregSeller.TABLE_NAME,null,values);

        if(newrowid > 0){
            Log.d("Insert","Data Added Successfully");


        }
        else
        {
            Log.d("Insert","Error");

        }
            return newrowid;

    }

    public Cursor readDetails(){

        SQLiteDatabase db = getReadableDatabase();
        String query = "Select * from "+ Unregistered_Seller.UnregSeller.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        return cursor;


    }


    public boolean updateInfo(String username,String password,String Email,String Name,String phone) {
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(Unregistered_Seller.UnregSeller.COLUMN_PASSWORD,password);
        values.put(Unregistered_Seller.UnregSeller.COLUMN_NAME_EMAIL,Email);
        values.put(Unregistered_Seller.UnregSeller.COLUMN_NAME_NAME,Name);
        values.put(Unregistered_Seller.UnregSeller.COLUMN_NAME_PHONE,phone);

        String selection = Unregistered_Seller.UnregSeller.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs  ={username};

        long rs = db.update(
                Unregistered_Seller.UnregSeller.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        if(rs > 0){

            return  true;
        }
        else
        {
            return false;
        }


    }

    public int delete(String username){

        SQLiteDatabase db = getReadableDatabase();

        String selection = Unregistered_Seller.UnregSeller.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionargs = {username};

        long result = db.delete(Unregistered_Seller.UnregSeller.TABLE_NAME,selection,selectionargs);

        if(result > 0){

            return 1;
        }
        else
        {
            return -1;

        }


    }
}
