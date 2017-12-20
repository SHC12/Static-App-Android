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

public class DetailSipora extends AppCompatActivity {


    private  static ViewPager viewPagerSipora;
    private  static int currenPager = 0;
    private static final Integer[] gambarSipora = {R.drawable.sipora1, R.drawable.sipora2};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideSipora adapterSlideSipora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sipora);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_sipora, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Pulau+Sipura,+Kabupaten+Kepulauan+Mentawai,+Sumatera+Barat,+Indonesia/@-2.21387,99.696147,10z/data=!4m2!3m1!"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarSipora.length; i++){
            imageAdd.add(gambarSipora[i]);
        }

        viewPagerSipora = (ViewPager) findViewById(R.id.viewPagerSipora);
        adapterSlideSipora = new AdapterSlideSipora(DetailSipora.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorSipora);
        viewPagerSipora.setAdapter(adapterSlideSipora);
        indicator.setViewPager(viewPagerSipora);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarSipora.length){
                    currenPager = 0;
                }
                viewPagerSipora.setCurrentItem(currenPager++, true);
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
