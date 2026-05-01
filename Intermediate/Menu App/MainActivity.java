package com.example.menuapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu m){
        m.add("Call");
        m.add("Web");
        m.add("SMS");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem i){
        String t=i.getTitle().toString();

        if(t.equals("Call"))
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9999999999")));

        else if(t.equals("Web"))
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")));

        else
            startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:9999999999")));

        return true;
    }
}
