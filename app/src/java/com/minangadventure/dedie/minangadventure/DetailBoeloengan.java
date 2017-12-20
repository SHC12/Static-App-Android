package com.minangadventure.dedie.minangadventure;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailBoeloengan extends AppCompatActivity {

    private  static ViewPager viewPagerBoeloengan;
    private  static int currenPager = 0;
    private static final Integer[] gambarBoeloengan = {R.drawable.boeloengan1, R.drawable.boeloengan2, R.drawable.boeloengan3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideBoeloengan adapterSlideBoeloengan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_boeloengan);
        initView();
    }
    private void initView(){
        for(int i=0; i < gambarBoeloengan.length; i++){
            imageAdd.add(gambarBoeloengan[i]);
        }

        viewPagerBoeloengan = (ViewPager) findViewById(R.id.viewPagerBoeloengan);
        adapterSlideBoeloengan = new AdapterSlideBoeloengan(DetailBoeloengan.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorBoeloengan);
        viewPagerBoeloengan.setAdapter(adapterSlideBoeloengan);
        indicator.setViewPager(viewPagerBoeloengan);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarBoeloengan.length){
                    currenPager = 0;
                }
                viewPagerBoeloengan.setCurrentItem(currenPager++, true);
            }
        };

        Timer swiperTimer = new Timer();
        swiperTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 2000, 2000);
    }
}
