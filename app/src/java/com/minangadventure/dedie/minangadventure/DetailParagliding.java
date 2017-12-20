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

public class DetailParagliding extends AppCompatActivity {

    private  static ViewPager viewPagerParagliding;
    private  static int currenPager = 0;
    private static final Integer[] gambarParagliding = {R.drawable.lawang, R.drawable.lawang2, R.drawable.lawang3, R.drawable.lawang4};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideParagliding adapterSlideParagliding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_paragliding);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_lawang, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Puncak+Lawang,+Lawang,+Matur,+Kabupaten+Agam,+Sumatera+Barat+26471,+Indonesia/@-0.263961,100.2424986,17z/data=!4m2!3m1!1s0x2fd56a8c17698059:0x83416c96b66fd2cd"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarParagliding.length; i++){
            imageAdd.add(gambarParagliding[i]);
        }

        viewPagerParagliding = (ViewPager) findViewById(R.id.viewPagerParagliding);
        adapterSlideParagliding = new AdapterSlideParagliding(DetailParagliding.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorParagliding);
        viewPagerParagliding.setAdapter(adapterSlideParagliding);
        indicator.setViewPager(viewPagerParagliding);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarParagliding.length){
                    currenPager = 0;
                }
                viewPagerParagliding.setCurrentItem(currenPager++, true);
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
