package com.example.rany.local_notificaiton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.rany.local_notificaiton.util.LocalNotificationHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnSimpleNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleNotification=findViewById(R.id.simpleNotification);

        btnSimpleNotification.setOnClickListener(v->{
            new LocalNotificationHelper().pushSimpleNotification(this);
        });
    }
}
