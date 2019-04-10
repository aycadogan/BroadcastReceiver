package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SystemBroadcastReceiver mySystemReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btnEnableReceiver = findViewById(R.id.activity_main__btn__enable_reciever);
        btnEnableReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySystemReceiver = new SystemBroadcastReceiver();
                registerReceiver(mySystemReceiver,
                        new IntentFilter(Intent.ACTION_BATTERY_LOW));
            }
        });

        final ConstraintLayout clRoot = findViewById(R.id.);
        clRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent = new Intent();
                customIntent.setAction("activity_main_cl__root");
                sendBroadcast(customIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mySystemReceiver);
    }
}


