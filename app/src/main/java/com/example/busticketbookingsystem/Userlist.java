package com.example.busticketbookingsystem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

public class Userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, source, destination,start,Arrive,Fare,Date;
    Button Book;
  DataBaseHelper DB;
    MyAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        DB = new DataBaseHelper(this);
        name = new ArrayList<>();
        source= new ArrayList<>();
        destination= new ArrayList<>();
        start= new ArrayList<>();
        Arrive= new ArrayList<>();
        Fare= new ArrayList<>();
        Date= new ArrayList<>();


        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, name, source,destination,start,Arrive,Date,Fare);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata()
    {
        Cursor cursor = DB.getdata2();
        if(cursor.getCount()==0)
        {
            Toast.makeText(Userlist.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                source.add(cursor.getString(1));
                destination.add(cursor.getString(2));
                start.add(cursor.getString(3));
                Arrive.add(cursor.getString(4));
                Fare.add(cursor.getString(6));
                Date.add(cursor.getString(5));


            }

        }

    }
}