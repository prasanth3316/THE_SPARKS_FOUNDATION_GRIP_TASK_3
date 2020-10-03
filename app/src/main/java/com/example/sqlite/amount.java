package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class amount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);
        final EditText e=(EditText)findViewById(R.id.editTextNumberDecimal);

        Button b=(Button)findViewById(R.id.button);
        Intent i=getIntent();
        final String Name=i.getStringExtra("SendName");
        final String Sender=i.getStringExtra("Name");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String a=e.getText().toString();
                if(TextUtils.isEmpty(a))
                {
                    Toast.makeText(getApplicationContext(),"Enter Amount",Toast.LENGTH_SHORT).show();

                }
                else{ try{
                    Double d=Double.valueOf(a);


                    databasehelper helper=new databasehelper(getApplicationContext());
                    SQLiteDatabase db=helper.getReadableDatabase();

                    Cursor c=db.query("users",new String[]{"_id","NAME","Balance"},"NAME=?",new String[]{Sender},null,null,null);
                    Cursor c1=db.query("users",new String[]{"_id","NAME","Balance"},"NAME=?",new String[]{Name},null,null,null);
                    Double d2=0.0;
                    Double d1=0.0;
                    while(c.moveToNext())
                    { d1=c.getDouble(2);
                    Log.e("123456",d1.toString());}
                    while(c1.moveToNext())
                    {d2=c1.getDouble(2);}
                    if(d1-d<0)
                    {
                        Toast.makeText(getApplicationContext(),"Insufficient Balance",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        i.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK );
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        db.beginTransaction();
                        ContentValues con=new ContentValues();
                        con.put("Balance",d1-d);
                        ContentValues con1=new ContentValues();
                        con1.put("Balance",d2+d);
                        db.update("users",con,"NAME=?",new String[]{Sender});
                        db.update("users",con1,"NAME=?",new String[]{Name});
                        db.endTransaction();
                        Toast.makeText(getApplicationContext(),"Transfer Successful",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        i.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK );
                        startActivity(i);
                        finish();
                    }
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error In Input",Toast.LENGTH_SHORT).show();
                }

            }}
        });


    }
}