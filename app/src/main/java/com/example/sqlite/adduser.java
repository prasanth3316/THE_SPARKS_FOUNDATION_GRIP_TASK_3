package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class adduser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
    }

    public void adduser(View view) {
        databasehelper helper=new databasehelper(getApplicationContext());
        SQLiteDatabase db=helper.getWritableDatabase();
        EditText name=(EditText)findViewById(R.id.name);
        EditText balance=(EditText)findViewById(R.id.balance);
        String n=name.getText().toString();
       double b=Double.valueOf(balance.getText().toString());
        helper.insert(db,n,b);
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();

    }
}