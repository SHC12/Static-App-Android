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

public class DetailTaratak extends AppCompatActivity {

    private  static ViewPager viewPagerTaratak;
    private  static int currenPager = 0;
    private static final Integer[] gambarTaratak = {R.drawable.taratak1, R.drawable.taratak2, R.drawable.taratak3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideTaratak adapterSlideTaratak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_taratak);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_taratak, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/Bukit+taratak/@-0.9803676,100.5747744,10z"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarTaratak.length; i++){
            imageAdd.add(gambarTaratak[i]);
        }

        viewPagerTaratak = (ViewPager) findViewById(R.id.viewPagerTaratak);
        adapterSlideTaratak = new AdapterSlideTaratak(DetailTaratak.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorTaratak);
        viewPagerTaratak.setAdapter(adapterSlideTaratak);
        indicator.setViewPager(viewPagerTaratak);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarTaratak.length){
                    currenPager = 0;
                }
                viewPagerTaratak.setCurrentItem(currenPager++, true);
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
