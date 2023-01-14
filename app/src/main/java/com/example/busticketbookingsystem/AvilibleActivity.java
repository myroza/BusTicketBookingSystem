package com.example.busticketbookingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AvilibleActivity extends AppCompatActivity {
CardView avv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avilible2);
        avv=findViewById(R.id.bus);
        avv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   Intent intent=new Intent(getApplicationContext(),Userlist.class);
                  startActivity(intent);
               // startActivity(new Intent(AvilibleActivity.this, Userlist.class));
            }
        });

    }
}