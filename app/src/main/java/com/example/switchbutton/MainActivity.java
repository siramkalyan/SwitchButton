package com.example.switchbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
ToggleButton t;
EditText t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.toggleButton);
        t2=findViewById(R.id.editTextTime2);
 t.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         if(t.isChecked() == false)
         {
             t.setBackgroundColor(Color.RED);
             Toast.makeText(getApplicationContext(),t2.getText().toString(),Toast.LENGTH_SHORT).show();
         }
         else
         {

             String p=t2.getText().toString();
             t.setBackgroundColor(Color.GREEN);
             startAlert();
         }
     }
 });

    }
    public void startAlert() {
        EditText text = (EditText) findViewById(R.id.editTextTime2);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();
    }

}