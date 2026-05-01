package com.example.masterdetail;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_detail);

        int i = getIntent().getIntExtra("id", 0);

        if (b == null) {
            DetailFragment f = DetailFragment.newInstance(i);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail, f)
                    .commit();
        }
    }
}
