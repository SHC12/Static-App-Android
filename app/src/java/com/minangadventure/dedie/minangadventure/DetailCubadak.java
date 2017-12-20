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

public class DetailCubadak extends AppCompatActivity {


    private  static ViewPager viewPagerCubadak;
    private  static int currenPager = 0;
    private static final Integer[] gambarCubadak = {R.drawable.cubadak, R.drawable.cubadak2, R.drawable.cubadak3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideCubadak adapterSlideCubadak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cubadak);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_cubadak, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Pulau+Cubadak,+Ampang+Pulai,+Koto+XI+Tarusan,+Kabupaten+Pesisir+Selatan,+Sumatera+Barat,+Indonesia/@-1.2136111,100.3872222,17z/data=!4m2!3m1!1s0x2fd358ee1d071215:0x51d4b4e29782b4ea"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarCubadak.length; i++){
            imageAdd.add(gambarCubadak[i]);
        }

        viewPagerCubadak = (ViewPager) findViewById(R.id.viewPagerCubadak);
        adapterSlideCubadak = new AdapterSlideCubadak(DetailCubadak.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorCubadak);
        viewPagerCubadak.setAdapter(adapterSlideCubadak);
        indicator.setViewPager(viewPagerCubadak);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarCubadak.length){
                    currenPager = 0;
                }
                viewPagerCubadak.setCurrentItem(currenPager++, true);
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
