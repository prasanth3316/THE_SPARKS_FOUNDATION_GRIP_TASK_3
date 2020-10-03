package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class loadusers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadusers);
        databasehelper helper=new databasehelper(getApplicationContext());
        SQLiteDatabase db=helper.getReadableDatabase();
        final ArrayList<String>Name=new ArrayList<>();
        final ArrayList<Double>balance=new ArrayList<>();
        Cursor c=db.query("users",new String[]{"_id","NAME","Balance"},null,null,null,null,null);
        while(c.moveToNext())
        {
            Name.add(c.getString(1));
            balance.add(c.getDouble(2));
        }
        //db.execSQL("DROP TABLE IF EXISTS "+"users");
        final ListView list=(ListView)findViewById(R.id.listofusers);
        final SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                c,
                new String[]{"NAME"},
                new int[]{android.R.id.text1},
                0);
        list.setAdapter(listAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
Intent i=new Intent(getApplicationContext(),details.class);
i.putExtra("NAME",Name.get(position));
                i.putExtra("Balance",balance.get(position));
startActivity(i);
            }
        });
    }
}