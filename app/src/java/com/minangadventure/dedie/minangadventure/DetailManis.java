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

public class DetailManis extends AppCompatActivity {

    private  static ViewPager viewPagerManis;
    private  static int currenPager = 0;
    private static final Integer[] gambarManis = {R.drawable.airmanis1, R.drawable.airmanis2, R.drawable.airmanis3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideManis adapterSlideManis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_manis);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_manis, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Pantai+Air+Manis,+Sumatera+Barat,+Indonesia/@-0.9916393,100.3609933,15z/data=!4m2!3m1!1s0x2fd4bb8fd5268b13:0xa991ccf7184d219b"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarManis.length; i++){
            imageAdd.add(gambarManis[i]);
        }

        viewPagerManis = (ViewPager) findViewById(R.id.viewPagerManis);
        adapterSlideManis = new AdapterSlideManis(DetailManis.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorManis);
        viewPagerManis.setAdapter(adapterSlideManis);
        indicator.setViewPager(viewPagerManis);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarManis.length){
                    currenPager = 0;
                }
                viewPagerManis.setCurrentItem(currenPager++, true);
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
