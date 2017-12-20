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

public class DetailClimbing extends AppCompatActivity {

    private  static ViewPager viewPagerClimbing;
    private  static int currenPager = 0;
    private static final Integer[] gambarClimbing = {R.drawable.harau1, R.drawable.harau2, R.drawable.harau3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideClimbing adapterSlideClimbing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_climbing);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_arau, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/Lembah+harau/@-0.1258994,100.6651378,13z"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarClimbing.length; i++){
            imageAdd.add(gambarClimbing[i]);
        }

        viewPagerClimbing = (ViewPager) findViewById(R.id.viewPagerClimbing);
        adapterSlideClimbing = new AdapterSlideClimbing(DetailClimbing.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorClimbing);
        viewPagerClimbing.setAdapter(adapterSlideClimbing);
        indicator.setViewPager(viewPagerClimbing);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarClimbing.length){
                    currenPager = 0;
                }
                viewPagerClimbing.setCurrentItem(currenPager++, true);
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
