package com.minangadventure.dedie.minangadventure;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dedie on 7/3/17.
 */

public class AdapterSlideSurfing extends PagerAdapter {

    private ArrayList<Integer> gambar;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterSlideSurfing(Context context, ArrayList<Integer> gambar){
        this.gambar = gambar;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return gambar.size();

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View myView =  layoutInflater.inflate(R.layout.slider_image_surfing, container, false);
        ImageView imageView = (ImageView) myView.findViewById(R.id.slideSurfing);
        imageView.setImageResource(gambar.get(position));
        container.addView(myView, 0);
        return myView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
