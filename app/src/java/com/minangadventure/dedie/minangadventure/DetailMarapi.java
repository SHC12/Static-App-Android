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

public class DetailMarapi extends AppCompatActivity {
    private  static ViewPager viewPagerMarapi;
    private  static int currenPager = 0;
    private static final Integer[] gambarMarapi = {R.drawable.marapi1, R.drawable.marapi2, R.drawable.marapi3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideMarapi adapterSlideMarapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_marapi);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_marapi, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Gn.+Marapi,+Pasie+Laweh,+Sungai+Tarab,+Kabupaten+Tanah+Datar,+Sumatera+Barat,+Indonesia/@-0.3799999,100.4741666,17z/data=!4m2!3m1!1s0x2fd530c146ae4ed7:0xb4afd8f79061afb6"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarMarapi.length; i++){
            imageAdd.add(gambarMarapi[i]);
        }

        viewPagerMarapi = (ViewPager) findViewById(R.id.viewPagerMarapi);
        adapterSlideMarapi = new AdapterSlideMarapi(DetailMarapi.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorMarapi);
        viewPagerMarapi.setAdapter(adapterSlideMarapi);
        indicator.setViewPager(viewPagerMarapi);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarMarapi.length){
                    currenPager = 0;
                }
                viewPagerMarapi.setCurrentItem(currenPager++, true);
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
