package com.example.rany.local_notificaiton.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.rany.local_notificaiton.R;

public class LocalNotificationHelper {

    public static final String CHANNEL_ID="user-01";
    public static final String CHANNEL_NAME="user";
    public void createNotificationChannel(Context context){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel ch=new NotificationChannel(
                    CHANNEL_ID,CHANNEL_NAME, NotificationCompat.PRIORITY_DEFAULT
            );
            ch.setDescription("this notification for user");
            ch.enableLights(true);
            ch.enableVibration(true);

            NotificationManager manager=
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            manager.createNotificationChannel(ch);

        }
    }

    public void pushSimpleNotification(Context context){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("local notification");
        builder.setContentText("local notification local notification local notification");

        NotificationManager manager=
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        int id=(int) System.currentTimeMillis()/1000;
        manager.notify(id,builder.build());


    }
}
