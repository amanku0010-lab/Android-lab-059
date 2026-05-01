package com.example.masterdetail;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.OnSelect {

    boolean land;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        land = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (b == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.left, new ListFragment())
                    .commit();
        }
    }

    public void onItem(int i) {
        if (land) {
            DetailFragment f = DetailFragment.newInstance(i);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.right, f)
                    .commit();
        } else {
            Intent in = new Intent(this, DetailActivity.class);
            in.putExtra("id", i);
            startActivity(in);
        }
    }
}
