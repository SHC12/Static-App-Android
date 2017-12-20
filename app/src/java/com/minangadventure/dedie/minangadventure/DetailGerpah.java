package com.minangadventure.dedie.minangadventure;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailGerpah extends AppCompatActivity {

    private  static ViewPager viewPagerGerpah;
    private  static int currenPager = 0;
    private static final Integer[] gambarGerpah = {R.drawable.gerpah1, R.drawable.gerpah2, R.drawable.gerpah3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideGerpah adapterSlideGerpah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gerpah);
        initView();
    }
    private void initView(){
        for(int i=0; i < gambarGerpah.length; i++){
            imageAdd.add(gambarGerpah[i]);
        }

        viewPagerGerpah = (ViewPager) findViewById(R.id.viewPagerGerpah);
        adapterSlideGerpah = new AdapterSlideGerpah(DetailGerpah.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorGerpah);
        viewPagerGerpah.setAdapter(adapterSlideGerpah);
        indicator.setViewPager(viewPagerGerpah);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarGerpah.length){
                    currenPager = 0;
                }
                viewPagerGerpah.setCurrentItem(currenPager++, true);
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
