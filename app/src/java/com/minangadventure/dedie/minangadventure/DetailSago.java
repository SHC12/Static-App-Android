package com.minangadventure.dedie.minangadventure;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailSago extends AppCompatActivity {

    private  static ViewPager viewPagerSago;
    private  static int currenPager = 0;
    private static final Integer[] gambarSago = {R.drawable.sago1, R.drawable.sago2};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideSago adapterSlideSago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sago);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_sago, menu);

        return true;
    }
    private void initView(){
        for(int i=0; i < gambarSago.length; i++){
            imageAdd.add(gambarSago[i]);
        }

        viewPagerSago = (ViewPager) findViewById(R.id.viewPagerSago);
        adapterSlideSago = new AdapterSlideSago(DetailSago.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorSago);
        viewPagerSago.setAdapter(adapterSlideSago);
        indicator.setViewPager(viewPagerSago);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarSago.length){
                    currenPager = 0;
                }
                viewPagerSago.setCurrentItem(currenPager++, true);
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
