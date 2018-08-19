package com.example.rany.local_notificaiton;

import android.app.Application;

import com.example.rany.local_notificaiton.util.LocalNotificationHelper;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new LocalNotificationHelper().createNotificationChannel(this);
    }
}
