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

public class DetailTalang extends AppCompatActivity {

    private  static ViewPager viewPagerTalang;
    private  static int currenPager = 0;
    private static final Integer[] gambarTalang = {R.drawable.talang1, R.drawable.talang2, R.drawable.talang3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideTalang adapterSlideTalang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_talang);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_talang, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Gn.+Talang,+Air+Batumbuk,+Gn.+Talang,+Solok,+Sumatera+Barat,+Indonesia/@-0.9761111,100.6838889,17z/data=!4m2!3m1!1s0x2e2b4c6da50bd541:0x3f6bd78d294269f5"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarTalang.length; i++){
            imageAdd.add(gambarTalang[i]);
        }

        viewPagerTalang = (ViewPager) findViewById(R.id.viewPagerTalang);
        adapterSlideTalang = new AdapterSlideTalang(DetailTalang.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorTalang);
        viewPagerTalang.setAdapter(adapterSlideTalang);
        indicator.setViewPager(viewPagerTalang);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarTalang.length){
                    currenPager = 0;
                }
                viewPagerTalang.setCurrentItem(currenPager++, true);
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
