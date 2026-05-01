package com.example.alarmapp;

import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.btn);

        btn.setOnClickListener(v->{
            Calendar c=Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY,8);

            AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent i=new Intent(this,Receiver.class);
            PendingIntent pi=PendingIntent.getBroadcast(this,0,i,PendingIntent.FLAG_IMMUTABLE);

            am.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
        });
    }
}
