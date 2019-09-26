package com.example.vehicalparts;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "parts.db";
    public static final String TABLE_NAME = "vehical_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DETAILS";
    public static final String COL_4 = "NUMBER";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,DETAILS TEXT,NUMBER INTEGER)" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);



    }
    public boolean insertData(String name,String details,String number ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put( COL_2, name);
        contentValues.put( COL_3, details);
        contentValues.put( COL_4, number);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;


    }
    public boolean updateData(String id,String name,String details,String number ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put( COL_1, id);
        contentValues.put( COL_2, name);
        contentValues.put( COL_3, details);
        contentValues.put( COL_4, number);
        db.update(TABLE_NAME, contentValues,"ID = ?",new String[]{id});
        return true;




    }
}
