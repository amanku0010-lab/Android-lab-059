package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    EditText u,p;
    Button login,reg;
    DatabaseHelper db;

    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        u=findViewById(R.id.etUser);
        p=findViewById(R.id.etPass);
        login=findViewById(R.id.btnLogin);
        reg=findViewById(R.id.btnReg);

        db=new DatabaseHelper(this);

        login.setOnClickListener(v->{
            String user=u.getText().toString();
            String pass=p.getText().toString();

            boolean ok=db.checkLogin(user,pass);

            AlertDialog.Builder d=new AlertDialog.Builder(this);
            if(ok) d.setMessage("Login Success");
            else d.setMessage("Login Failed");
            d.setPositiveButton("OK",null).show();
        });

        reg.setOnClickListener(v->startActivity(new Intent(this,RegisterActivity.class)));
    }
}
