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

public class DetailTalamau extends AppCompatActivity {

    private  static ViewPager viewPagerTalamau;
    private  static int currenPager = 0;
    private static final Integer[] gambarTalamau = {R.drawable.talamau1, R.drawable.talamau2, R.drawable.talamau3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideTalamau adapterSlideTalamau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_talamau);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_talamau, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Gn.+Talamau,+Malampah,+Tigo+Nagari,+Kabupaten+Pasaman,+Sumatera+Barat,+Indonesia/@0.0791666,99.9841666,17z/data=!4m2!3m1!1s0x302a8151027bc62f:0x319fbb0a1e0320de"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarTalamau.length; i++){
            imageAdd.add(gambarTalamau[i]);
        }

        viewPagerTalamau = (ViewPager) findViewById(R.id.viewPagerTalamau);
        adapterSlideTalamau = new AdapterSlideTalamau(DetailTalamau.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorTalamau);
        viewPagerTalamau.setAdapter(adapterSlideTalamau);
        indicator.setViewPager(viewPagerTalamau);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarTalamau.length){
                    currenPager = 0;
                }
                viewPagerTalamau.setCurrentItem(currenPager++, true);
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
