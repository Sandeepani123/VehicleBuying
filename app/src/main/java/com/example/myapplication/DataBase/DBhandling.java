package com.example.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBhandling extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SellerInfo.db";
    public static final String TABLE_NAME = "comment";
    public static final String COLUMN_COMMENT_NAME = "comment name";


    public DBhandling(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + comment.commentsection.TABLE_NAME + " (" +
                        comment.commentsection._ID + "INTEGER PRIMARY KEY," +
                        comment.commentsection.COLUMN_COMMENT_NAME + "TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long send(String comment_name) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(comment.commentsection.COLUMN_COMMENT_NAME, comment_name);

        long newrowid = db.insert(comment.commentsection.TABLE_NAME, null, values);

        if (newrowid > 0) {
            Log.d("Insert", "Data Added Successfully");


        } else {
            Log.d("Insert", "Error");

        }
        return newrowid;

    }

    public boolean updateInfo(String comment_name) {
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(comment.commentsection.COLUMN_COMMENT_NAME, comment_name);

        String selection = comment.commentsection.COLUMN_COMMENT_NAME + " LIKE ?";
        String[] selectionArgs = {comment_name};

        long rs = db.update(
                comment.commentsection.TABLE_NAME,
                values,
                selection,
                selectionArgs

        );

        if (rs > 0) {

            return true;
        } else {
            return false;
        }
    }

        public int deleteUser (String comment_name){

            SQLiteDatabase db = this.getWritableDatabase();

            return  db.delete(TABLE_NAME,"NAME ?",new String[]{comment_name});


        }


    }