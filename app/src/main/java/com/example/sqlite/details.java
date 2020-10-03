package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class details extends AppCompatActivity {
String Name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i=getIntent();
        Name=i.getStringExtra("NAME");
        TextView t=(TextView)findViewById(R.id.detail);
        t.setText("Name : "+i.getStringExtra("NAME")+"\n"+"Balance : $"+i.getDoubleExtra("Balance",0.0));
    }

    public void maketrans(View view) {
        Intent i=new Intent(getApplicationContext(),transdata.class);

        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK );
        i.putExtra("Name",Name);
        startActivity(i);
        finish();
    }
}