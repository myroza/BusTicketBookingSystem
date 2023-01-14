package com.example.busticketbookingsystem;

import androidx.appcompat.app.AppCompatActivity;


        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    EditText name, source, destination,start,arrive,fare,dat,dur;
    Button insert, view, delete;
    DataBaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        name = findViewById(R.id.name);
        source= findViewById(R.id.source);
        destination= findViewById(R.id.destination);
        start = findViewById(R.id.start);
        arrive = findViewById(R.id.Arrive);
        fare= findViewById(R.id.Fare);
        dat=findViewById(R.id.Date);
        dur = findViewById(R.id.duration);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);

        DB = new DataBaseHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, Userlist.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameTXT = name.getText().toString();
                String sourceTXT = source.getText().toString();
                String destinationTXT = destination.getText().toString();
                String startTXT = start.getText().toString();
                String ArriveTXT = arrive.getText().toString();
                String FareTXT = fare.getText().toString();
                String DateTXT = dat.getText().toString();
                String durationTXT = dur.getText().toString();

                Boolean checkinsertdata  = DB.insertuserdata2(nameTXT, sourceTXT,destinationTXT,startTXT,ArriveTXT,FareTXT,DateTXT,durationTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(AdminActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AdminActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();

                Boolean checkdeletedata  = DB.deleteuserdata2(nameTXT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(AdminActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AdminActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
