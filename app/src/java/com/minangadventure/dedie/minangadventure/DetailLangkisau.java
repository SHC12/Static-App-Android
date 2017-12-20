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

public class DetailLangkisau extends AppCompatActivity {

    private  static ViewPager viewPagerLangkisau;
    private  static int currenPager = 0;
    private static final Integer[] gambarLangkisau = {R.drawable.langkisau, R.drawable.langkisau2, R.drawable.langkisau3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideLangkisau adapterSlideLangkisau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_langkisau);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_langkisau, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Bukit+Langkisau,+bukit+langkisau,+Salido,+Iv+Jurai,+Kabupaten+Pesisir+Selatan,+Sumatera+Barat+25651,+Indonesia/@-1.3409928,100.5739794,17z/data=!4m2!3m1!1s0x2fd3527fd1ee69ff:0x2628a25b4f764d81"));
        startActivity(a);
        return true;
    }
    private void initView(){
        for(int i=0; i < gambarLangkisau.length; i++){
            imageAdd.add(gambarLangkisau[i]);
        }

        viewPagerLangkisau = (ViewPager) findViewById(R.id.viewPagerLangkisau);
        adapterSlideLangkisau = new AdapterSlideLangkisau(DetailLangkisau.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorLangkisau);
        viewPagerLangkisau.setAdapter(adapterSlideLangkisau);
        indicator.setViewPager(viewPagerLangkisau);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarLangkisau.length){
                    currenPager = 0;
                }
                viewPagerLangkisau.setCurrentItem(currenPager++, true);
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
