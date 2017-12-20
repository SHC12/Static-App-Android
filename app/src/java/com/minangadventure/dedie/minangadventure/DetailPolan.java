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

public class DetailPolan extends AppCompatActivity {

    private  static ViewPager viewPagerPolan;
    private  static int currenPager = 0;
    private static final Integer[] gambarPolan = {R.drawable.polan1, R.drawable.polan2};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlidePolan adapterSlidePolan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_polan);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_polan, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/Puncak+polan/@-0.6799051,100.7790301,15z"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarPolan.length; i++){
            imageAdd.add(gambarPolan[i]);
        }

        viewPagerPolan = (ViewPager) findViewById(R.id.viewPagerPolan);
        adapterSlidePolan = new AdapterSlidePolan(DetailPolan.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorPolan);
        viewPagerPolan.setAdapter(adapterSlidePolan);
        indicator.setViewPager(viewPagerPolan);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarPolan.length){
                    currenPager = 0;
                }
                viewPagerPolan.setCurrentItem(currenPager++, true);
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
