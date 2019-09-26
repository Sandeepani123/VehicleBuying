package com.example.myapplication.DataBase;

import android.provider.BaseColumns;

public final class Unregistered_Seller {

    public Unregistered_Seller(){ }

    protected static class UnregSeller implements BaseColumns{

        public static final String TABLE_NAME = "seller";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PHONE = "phone";




    }



}
