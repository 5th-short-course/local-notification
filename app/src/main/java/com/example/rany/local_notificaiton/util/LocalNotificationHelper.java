package com.example.rany.local_notificaiton.util;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.rany.local_notificaiton.DetailActivity;
import com.example.rany.local_notificaiton.R;

public class LocalNotificationHelper {

    public static final String CHANNEL_ID="user-01";
    public static final String CHANNEL_NAME="user";
    public void createNotificationChannel(Context context){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel ch=new NotificationChannel(
                    CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH
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

    public void pushNotificationWithBigText(Context context, String title,String content,String bigText){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(content);

        //use BigTextStyle
        NotificationCompat.BigTextStyle style=new NotificationCompat.BigTextStyle();
        //style.setSummaryText(bigText);
        style.bigText(bigText);
        builder.setStyle(style);

        NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int id= (int) System.currentTimeMillis()/1000;
        manager.notify(id,builder.build());

    }

    public void pushNotificationWithBigPicture(
            Context context,String title,String content,@DrawableRes int picture
    ){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(content);
        //BigPictureStyle;
        NotificationCompat.BigPictureStyle style =new NotificationCompat.BigPictureStyle();
        style.bigPicture(BitmapFactory.decodeResource(context.getResources(),picture));
        builder.setStyle(style);
        //set Content Intent
        Intent intent =new Intent(context,DetailActivity.class);
        intent.putExtra("message",content);
        PendingIntent pendingIntent=PendingIntent.getActivity(
                context,
                1,
                intent,
                //PendingIntent.FLAG_CANCEL_CURRENT
                PendingIntent.FLAG_ONE_SHOT
                );
        builder.setContentIntent(pendingIntent);
        builder.setNumber(0);
        NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int id= (int) System.currentTimeMillis()/1000;
        manager.notify(id,builder.build());

    }


}
