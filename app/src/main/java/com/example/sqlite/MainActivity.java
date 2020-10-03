package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addUser(View view) {
        Intent i =new Intent(getApplicationContext(),adduser.class);
        startActivity(i);

    }

    public void loadUsers(View view) {
        Intent i=new Intent(getApplicationContext(),loadusers.class);
        startActivity(i);

    }


}