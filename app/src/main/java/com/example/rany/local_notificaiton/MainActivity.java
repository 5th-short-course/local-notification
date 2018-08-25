package com.example.rany.local_notificaiton;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.rany.local_notificaiton.util.LocalNotificationHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnSimpleNotification,btnNotificationWithBigTextStyle,btnNotificationWithBigPictureStyle;
    private LocalNotificationHelper localNotificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setBadgeNumber to zero
        /*NotificationCompat.Builder builder=new NotificationCompat.Builder(this,LocalNotificationHelper.CHANNEL_ID);
        builder.setNumber(0);
        ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).notify(0,builder.build());
*/
        btnSimpleNotification=findViewById(R.id.simpleNotification);
        btnNotificationWithBigTextStyle=findViewById(R.id.notificationWithBigTextStyle);
        btnNotificationWithBigPictureStyle=findViewById(R.id.notificationWithBigPictureStyle);


        localNotificationHelper=new LocalNotificationHelper();

        btnSimpleNotification.setOnClickListener(v->{
            //new LocalNotificationHelper().pushSimpleNotification(this);
            localNotificationHelper.pushSimpleNotification(this);
        });

        btnNotificationWithBigTextStyle.setOnClickListener(v->{
            localNotificationHelper.pushNotificationWithBigText(
                    this,
                    "Hot new",
                    "At the end of the operation, progress should equal max.",
                    "At the end of the operation, progress should equal max. You can either leave the progress bar showing when the operation is done, or remove it."
            );

        });


        btnNotificationWithBigPictureStyle.setOnClickListener(v->{
            localNotificationHelper.pushNotificationWithBigPicture(
                    this,
                    "big picture style"
                    ,"At the end of the operation, progress should equal max.",
                    R.drawable.images_2
            );
        });
    }
}
