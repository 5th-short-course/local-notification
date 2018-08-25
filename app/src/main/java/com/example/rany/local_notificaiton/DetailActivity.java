package com.example.rany.local_notificaiton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView=findViewById(R.id.message);
        if(getIntent()!=null){
            textView.setText(getIntent().getStringExtra("message"));

        }
    }
}
