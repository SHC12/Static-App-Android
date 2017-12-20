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

public class DetailPieh extends AppCompatActivity {

    private  static ViewPager viewPagerPieh;
    private  static int currenPager = 0;
    private static final Integer[] gambarPieh = {R.drawable.pieh1, R.drawable.pieh2, R.drawable.pieh3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlidePieh adapterSlidePieh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pieh);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_pieh, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Pulau+Pieh,+Indonesia/@-0.8747222,100.1022222,17z/data=!4m2!3m1!1s0x2fd4ed4065aed1f7:0x47e448313340b5db"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarPieh.length; i++){
            imageAdd.add(gambarPieh[i]);
        }

        viewPagerPieh = (ViewPager) findViewById(R.id.viewPagerPieh);
        adapterSlidePieh = new AdapterSlidePieh(DetailPieh.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorPieh);
        viewPagerPieh.setAdapter(adapterSlidePieh);
        indicator.setViewPager(viewPagerPieh);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarPieh.length){
                    currenPager = 0;
                }
                viewPagerPieh.setCurrentItem(currenPager++, true);
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
