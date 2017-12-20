package com.minangadventure.dedie.minangadventure;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailRafting extends AppCompatActivity {

    private  static ViewPager viewPagerRafting;
    private  static int currenPager = 0;
    private static final Integer[] gambarRafting = {R.drawable.tarusan1, R.drawable.tarusan2, R.drawable.tarusan3, R.drawable.tarusan4};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideRafting adapterSlideRafting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rafting);
        initView();
    }
    private void initView(){
        for(int i=0; i < gambarRafting.length; i++){
            imageAdd.add(gambarRafting[i]);
        }

        viewPagerRafting = (ViewPager) findViewById(R.id.viewPagerRafting);
        adapterSlideRafting = new AdapterSlideRafting(DetailRafting.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorRafting);
        viewPagerRafting.setAdapter(adapterSlideRafting);
        indicator.setViewPager(viewPagerRafting);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarRafting.length){
                    currenPager = 0;
                }
                viewPagerRafting.setCurrentItem(currenPager++, true);
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
