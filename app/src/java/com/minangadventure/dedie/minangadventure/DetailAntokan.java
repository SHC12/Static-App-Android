package com.minangadventure.dedie.minangadventure;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailAntokan extends AppCompatActivity {

    private  static ViewPager viewPagerAntokan;
    private  static int currenPager = 0;
    private static final Integer[] gambarAntokan = {R.drawable.antokan1, R.drawable.antokan2, R.drawable.antokan3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideAntokan adapterSlideAntokan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_antokan);
        initView();
    }
    private void initView(){
        for(int i=0; i < gambarAntokan.length; i++){
            imageAdd.add(gambarAntokan[i]);
        }

        viewPagerAntokan = (ViewPager) findViewById(R.id.viewPagerAntokan);
        adapterSlideAntokan = new AdapterSlideAntokan(DetailAntokan.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorAntokan);
        viewPagerAntokan.setAdapter(adapterSlideAntokan);
        indicator.setViewPager(viewPagerAntokan);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarAntokan.length){
                    currenPager = 0;
                }
                viewPagerAntokan.setCurrentItem(currenPager++, true);
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
