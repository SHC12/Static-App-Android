package com.minangadventure.dedie.minangadventure;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailCycling extends AppCompatActivity {

    private  static ViewPager viewPagerCycling;
    private  static int currenPager = 0;
    private static final Integer[] gambarCycling = {R.drawable.batubusuk1, R.drawable.batubusuk2};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideCycling adapterSlideCycling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cycling);
        initView();
    }
    private void initView(){
        for(int i=0; i < gambarCycling.length; i++){
            imageAdd.add(gambarCycling[i]);
        }

        viewPagerCycling = (ViewPager) findViewById(R.id.viewPagerCycling);
        adapterSlideCycling = new AdapterSlideCycling(DetailCycling.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorCycling);
        viewPagerCycling.setAdapter(adapterSlideCycling);
        indicator.setViewPager(viewPagerCycling);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarCycling.length){
                    currenPager = 0;
                }
                viewPagerCycling.setCurrentItem(currenPager++, true);
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
