package com.example.busticketbookingsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    EditText name,Password,Repassword;
    Button signup;
    DBhelper db;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.username);
        // password=findViewById(R.id.password);
        Password=findViewById(R.id.password);
        Repassword=findViewById(R.id.repassword);
        // signin=findViewById(R.id.signin);
        signup=findViewById(R.id.register);
        db=new DBhelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                //String Pass = Password.getText().toString();
                String password=Password.getText().toString();
                String repass = Repassword.getText().toString();

                if (user.equals("") || password.equals("") || repass.equals("")) {
                    Toast.makeText(SignupActivity.this, "please fill all feilds", Toast.LENGTH_SHORT).show();


                } else{
                    if (password.equals(repass)) {
                        boolean result = db.chackusername(user);
                        if (result == false) {
                            boolean regresult = db.insertData(user, password);
                            if (regresult == true) {
                                Toast.makeText(SignupActivity.this, "register sucessfully", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);


                            } else {
                                Toast.makeText(SignupActivity.this, "registration failed", Toast.LENGTH_SHORT).show();
                            }


                        } else {
                            Toast.makeText(SignupActivity.this, "user already exist \n please siginin", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignupActivity.this, "password not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });


//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//            }
        //  });

    }
}
