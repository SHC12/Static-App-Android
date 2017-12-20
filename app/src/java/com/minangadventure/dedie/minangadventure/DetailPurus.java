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

public class DetailPurus extends AppCompatActivity {

    private  static ViewPager viewPagerPurus;
    private  static int currenPager = 0;
    private static final Integer[] gambarPurus = {R.drawable.pantaipurus1, R.drawable.pantaipurus2};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlidePurus adapterSlidePurus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_purus);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_purus, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/pantai+purus/@-0.9370278,100.3521646,16z"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarPurus.length; i++){
            imageAdd.add(gambarPurus[i]);
        }

        viewPagerPurus = (ViewPager) findViewById(R.id.viewPagerPurus);
        adapterSlidePurus = new AdapterSlidePurus(DetailPurus.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorPurus);
        viewPagerPurus.setAdapter(adapterSlidePurus);
        indicator.setViewPager(viewPagerPurus);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarPurus.length){
                    currenPager = 0;
                }
                viewPagerPurus.setCurrentItem(currenPager++, true);
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
