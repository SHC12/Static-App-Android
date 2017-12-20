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

public class DetailPandan extends AppCompatActivity {

    private  static ViewPager viewPagerPandan;
    private  static int currenPager = 0;
    private static final Integer[] gambarPandan = {R.drawable.pandan1, R.drawable.pandan2};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlidePandan adapterSlidePandan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pandan);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_pandan, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/pulau+pandan+sumatera+barat/@-0.9496229,100.1413725,17z"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarPandan.length; i++){
            imageAdd.add(gambarPandan[i]);
        }

        viewPagerPandan = (ViewPager) findViewById(R.id.viewPagerPandan);
        adapterSlidePandan = new AdapterSlidePandan(DetailPandan.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorPandan);
        viewPagerPandan.setAdapter(adapterSlidePandan);
        indicator.setViewPager(viewPagerPandan);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarPandan.length){
                    currenPager = 0;
                }
                viewPagerPandan.setCurrentItem(currenPager++, true);
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
