package com.example.busticketbookingsystem;





import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText name,password;
    Button signup,signin;
    DBhelper db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.username);
        password=findViewById(R.id.password);

        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        db=new DBhelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                // String pass = password.getText().toString();
                String pass=password.getText().toString();
                //String Repassword = repassword.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "please fill all feilds", Toast.LENGTH_SHORT).show();


                } else {
                    Boolean chacknamepass = db.chacknamePassword(user, pass);
                    if (chacknamepass == true) {
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "INVALID CREDINTALS", Toast.LENGTH_SHORT).show();
                    }
                }
                // if(user.equals("admin") and pass.equals("admin"))
                if(user.equals("admin")&& pass.equals("admin")){
                    Intent intent=new Intent(getApplicationContext(),AdminActivity.class);
                    startActivity(intent);
                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}
