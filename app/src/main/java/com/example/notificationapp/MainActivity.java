package com.example.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private static final int NOTIFICATION_ID = 0;

    private Button notifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notifyButton = (Button)findViewById(R.id.notify);

        notifyButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                sendNotification();
            }
        });
    }

    public void sendNotification(){
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notifiBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Content Title")
                .setContentText("Content Notification")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentIntent(notificationPendingIntent);

        Notification notification = notifiBuilder.build();
        notificationManager.notify(NOTIFICATION_ID,notification);
    }
}
