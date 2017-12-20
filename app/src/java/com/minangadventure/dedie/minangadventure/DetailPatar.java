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

public class DetailPatar extends AppCompatActivity {


    private  static ViewPager viewPagerPatar;
    private  static int currenPager = 0;
    private static final Integer[] gambarPatar = {R.drawable.patar1, R.drawable.patar2, R.drawable.patar3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlidePatar adapterSlidePatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_patar);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_patar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/patar+bike+park/@-0.2776858,100.5083942,17z"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarPatar.length; i++){
            imageAdd.add(gambarPatar[i]);
        }

        viewPagerPatar = (ViewPager) findViewById(R.id.viewPagerPatar);
        adapterSlidePatar = new AdapterSlidePatar(DetailPatar.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorPatar);
        viewPagerPatar.setAdapter(adapterSlidePatar);
        indicator.setViewPager(viewPagerPatar);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarPatar.length){
                    currenPager = 0;
                }
                viewPagerPatar.setCurrentItem(currenPager++, true);
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
