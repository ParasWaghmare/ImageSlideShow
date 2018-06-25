package com.example.paras.materialimageslideshow;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    ViewPager viewPager;
    SlideShowAdapter adapter;
    private CircleIndicator circleIndicator;
    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        circleIndicator = (CircleIndicator) findViewById(R.id.circleIndicator);


        viewPager = findViewById(R.id.viewPager);
        adapter = new SlideShowAdapter(this);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);

        handler = new Handler();
        runnable =new Runnable() {
            @Override
            public void run() {

                int i = viewPager.getCurrentItem();

                if (i==adapter.images.length-1){
                    i=0;
                    viewPager.setCurrentItem(i,true);
                }else {
                i++;
                viewPager.setCurrentItem(i,true);
                }

            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);

            }
        },4000,4000);

    }
}
