package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.music_file);

        Button play = findViewById(R.id.btnPlay);
        Button pause = findViewById(R.id.btnPause);
        Button stop = findViewById(R.id.btnStop);

        play.setOnClickListener(v -> mp.start());

        pause.setOnClickListener(v -> {
            if (mp.isPlaying()) mp.pause();
        });

        stop.setOnClickListener(v -> {
            if (mp != null) {
                mp.stop();
                mp = MediaPlayer.create(this, R.raw.music_file);
            }
        });
    }

    protected void onStop() {
        super.onStop();
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }
}
