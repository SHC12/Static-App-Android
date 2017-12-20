package com.minangadventure.dedie.minangadventure;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailTalago extends AppCompatActivity {
    private  static ViewPager viewPagerTalago;
    private  static int currenPager = 0;
    private static final Integer[] gambarTalago = {R.drawable.talago1, R.drawable.talago2, R.drawable.talago3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideTalago adapterSlideTalago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_talago);
        initView();
    }
    private void initView(){
        for(int i=0; i < gambarTalago.length; i++){
            imageAdd.add(gambarTalago[i]);
        }

        viewPagerTalago = (ViewPager) findViewById(R.id.viewPagerTalago);
        adapterSlideTalago = new AdapterSlideTalago(DetailTalago.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorTalago);
        viewPagerTalago.setAdapter(adapterSlideTalago);
        indicator.setViewPager(viewPagerTalago);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarTalago.length){
                    currenPager = 0;
                }
                viewPagerTalago.setCurrentItem(currenPager++, true);
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
