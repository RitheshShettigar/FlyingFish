package com.example.flyingfish;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private  FlyingFish gameview;

    private Handler handler=new Handler();
    private final static long Interval=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_game);

        gameview=new FlyingFish(this);
        setContentView(gameview);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameview.invalidate();

                    }
                });
            }
        },0,Interval);
    }
}