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

public class DetailTandikek extends AppCompatActivity {
    private  static ViewPager viewPagerTandikek;
    private  static int currenPager = 0;
    private static final Integer[] gambarTandikek = {R.drawable.tandikek1, R.drawable.tandikek2, R.drawable.tandikek3};
    private ArrayList<Integer> imageAdd = new ArrayList<Integer>();
    private AdapterSlideTandikek adapterSlideTandikek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tandikek);
        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_tandikek, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Gn.+Tandikat,+Singgalang,+Sepuluh+Koto,+Kabupaten+Tanah+Datar,+Sumatera+Barat,+Indonesia/@-0.4311111,100.3197222,17z/data=!4m2!3m1!1s0x2fd53cc44dc3a4d3:0xa19d8e8d0f175a4"));
        startActivity(a);
        return true;
    }

    private void initView(){
        for(int i=0; i < gambarTandikek.length; i++){
            imageAdd.add(gambarTandikek[i]);
        }

        viewPagerTandikek = (ViewPager) findViewById(R.id.viewPagerTandikek);
        adapterSlideTandikek = new AdapterSlideTandikek(DetailTandikek.this, imageAdd);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicatorTandikek);
        viewPagerTandikek.setAdapter(adapterSlideTandikek);
        indicator.setViewPager(viewPagerTandikek);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currenPager == gambarTandikek.length){
                    currenPager = 0;
                }
                viewPagerTandikek.setCurrentItem(currenPager++, true);
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
