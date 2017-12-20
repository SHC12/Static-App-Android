package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailSurfing extends AppCompatActivity {

    private  static ViewPager viewPagerSurfing;
    private  static int currenPager = 0;
    private static final Integer[] gambarSurfing = {R.drawable.mentawai1, R.drawable.mentawai2, R.drawable.mentawai3, R.drawable.mentawai4};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideSurfing adapterSlideSurfing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surfing);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_surfing, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Kabupaten+Kepulauan+Mentawai,+Sumatera+Barat,+Indonesia/@-2.4121468,100.2328597,6z/data=!4m2!3m1!1s0x2fd26ea82de46e3b:0x3039d80b220cb20"));
        startActivity(a);
        return true;
    }


    private void initView(){
        for(int i=0; i < gambarSurfing.length; i++){
            imageAdd.add(gambarSurfing[i]);
        }

        viewPagerSurfing = (ViewPager) findViewById(R.id.viewPagerSurfing);
        adapterSlideSurfing = new AdapterSlideSurfing(DetailSurfing.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorSurfing);
        viewPagerSurfing.setAdapter(adapterSlideSurfing);
        indicator.setViewPager(viewPagerSurfing);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarSurfing.length){
                    currenPager = 0;
                }
                viewPagerSurfing.setCurrentItem(currenPager++, true);
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
