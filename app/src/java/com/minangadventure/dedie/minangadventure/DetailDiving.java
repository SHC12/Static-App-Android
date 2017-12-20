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

public class DetailDiving extends AppCompatActivity {


    private  static ViewPager viewPagerDiving;
    private  static int currenPager = 0;
    private static final Integer[] gambarDiving = {R.drawable.pagang, R.drawable.pagang2, R.drawable.pagang3, R.drawable.pagang4};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideDiving adapterSlideDiving;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diving);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_pagang, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/Pulau+pagang/@-0.9140566,100.4677578,10z"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarDiving.length; i++){
            imageAdd.add(gambarDiving[i]);
        }

        viewPagerDiving = (ViewPager) findViewById(R.id.viewPagerDiving);
        adapterSlideDiving = new AdapterSlideDiving(DetailDiving.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorDiving);
        viewPagerDiving.setAdapter(adapterSlideDiving);
        indicator.setViewPager(viewPagerDiving);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarDiving.length){
                    currenPager = 0;
                }
                viewPagerDiving.setCurrentItem(currenPager++, true);
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
