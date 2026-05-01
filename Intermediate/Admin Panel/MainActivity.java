package com.example.adminapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    List<String> list;

    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        ListView lv=findViewById(R.id.list);

        db=new DatabaseHelper(this);
        list=db.getUsers();

        lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list));

        lv.setOnItemClickListener((p,v,pos,id)->{
            String data=list.get(pos);
            EditText e=new EditText(this);
            e.setText(data);

            new AlertDialog.Builder(this)
                    .setView(e)
                    .setPositiveButton("Save",(d,w)->{
                        db.update(pos,e.getText().toString());
                    }).show();
        });
    }
}
