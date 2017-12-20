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

public class DetailCaving extends AppCompatActivity {


    private  static ViewPager viewPagerCaving;
    private  static int currenPager = 0;
    private static final Integer[] gambarCaving = {R.drawable.ngalau1, R.drawable.ngalau2, R.drawable.ngalau3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideCaving adapterSlideCaving;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_caving);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_indah, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Ngalau+Indah,+Pakan+Sinayan,+Payakumbuh+Bar.,+Kota+Payakumbuh,+Sumatera+Barat+26225,+Indonesia/@-0.2549512,100.60435,17z/data=!4m2!3m1!1s0x2fd54b26e12a0159:0xbfc2b13876cb93e5"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarCaving.length; i++){
            imageAdd.add(gambarCaving[i]);
        }

        viewPagerCaving = (ViewPager) findViewById(R.id.viewPagerCaving);
        adapterSlideCaving = new AdapterSlideCaving(DetailCaving.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorCaving);
        viewPagerCaving.setAdapter(adapterSlideCaving);
        indicator.setViewPager(viewPagerCaving);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarCaving.length){
                    currenPager = 0;
                }
                viewPagerCaving.setCurrentItem(currenPager++, true);
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
