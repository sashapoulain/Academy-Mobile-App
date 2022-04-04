package com.example.fb.tz.tez.academy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewX;
    private TextView textViewX;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewX=findViewById(R.id.imageViewX);
        textViewX=findViewById(R.id.textViewX);

        timer= new Timer(  );
        timer.schedule(new TimerTask( ) {
            @Override
            public void run() {
                Intent yeniIntent = new Intent( getApplicationContext(), DrawerActivity2.class );
                startActivity(yeniIntent);
            }
        }, 5000);

    }

}