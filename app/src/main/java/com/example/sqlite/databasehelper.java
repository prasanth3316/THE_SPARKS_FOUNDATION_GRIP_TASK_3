package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class databasehelper extends SQLiteOpenHelper {
    public static final String DB_NAME="CREDIT MANAGEMENT";
    public  static final int DB_VERSION=1;
   databasehelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "Balance REAL );");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insert(SQLiteDatabase sqLiteDatabase,String name,double balance)
    {
        ContentValues c=new ContentValues();
        c.put("NAME",name);
        c.put("Balance",balance);
        sqLiteDatabase.insert("users",null,c);

    }

}
