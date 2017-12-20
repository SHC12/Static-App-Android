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

public class DetailHiking extends AppCompatActivity {

    private  static ViewPager viewPagerHiking;
    private  static int currenPager = 0;
    private static final Integer[] gambarHiking = {R.drawable.singgalang1, R.drawable.singgalang2, R.drawable.singgalang3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideHiking adapterSlideHiking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hiking);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_singgalang, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Gn.+Singgalang,+Balingka,+Iv+Koto,+Kabupaten+Agam,+Sumatera+Barat,+Indonesia/@-0.39,100.3308333,17z/data=!4m2!3m1!1s0x2fd53b8760830fa3:0xf209e220504e56f5"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarHiking.length; i++){
            imageAdd.add(gambarHiking[i]);
        }

        viewPagerHiking = (ViewPager) findViewById(R.id.viewPagerHiking);
        adapterSlideHiking = new AdapterSlideHiking(DetailHiking.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorHiking);
        viewPagerHiking.setAdapter(adapterSlideHiking);
        indicator.setViewPager(viewPagerHiking);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarHiking.length){
                    currenPager = 0;
                }
                viewPagerHiking.setCurrentItem(currenPager++, true);
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
