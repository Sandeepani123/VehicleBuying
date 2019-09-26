package com.example.parts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Vehical.db";
    public static final String TABLE_NAME = "Parts_table";
    public static final String Col_1 = "Item ID";
    public static final String Col_2 = "Name";
    public static final String Col_3 = "Price";
    public static final String Col_4 = "Date";
    public static final String Col_5 = "Details";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 0b1);

    }


    public void onCreate(SQLiteDatabase db ) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE INTEGER,DATE INTEGER,DETAILS STRING)");
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String price,String date,String details){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,price);
        contentValues.put(Col_4,date);
        contentValues.put(Col_5,details);
        long result = db.insert(TABLE_NAME,null,  contentValues);
        if(result == -1){
            return false;}
        else{
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }


    public Integer deleteData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME,"id  ?",new String[]{id});


        return null;
    }
}
