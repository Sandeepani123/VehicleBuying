package com.example.myapplication.DataBase;

import android.provider.BaseColumns;

public final class comment {

    public comment(){ }

        protected static class commentsection implements BaseColumns{
            public static final String TABLE_NAME = "comment";
            public static final String COLUMN_COMMENT_NAME = "comment name";

        }


}
