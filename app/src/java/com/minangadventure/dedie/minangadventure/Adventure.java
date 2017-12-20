package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Adventure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

        Button btnSurfing = (Button)findViewById(R.id.btnSurfing);
        Button btnHiking = (Button)findViewById(R.id.btnHiking);
        Button btnRafting = (Button)findViewById(R.id.btnRafting);
        Button btnCycling = (Button)findViewById(R.id.btnCycling);
        Button btnClimbing = (Button)findViewById(R.id.btnClimbing);
        Button btnDiving = (Button)findViewById(R.id.btnDiving);
        Button btnCaving = (Button)findViewById(R.id.btnCaving);
        Button btnParalayang = (Button)findViewById(R.id.btnParalayang);
        ImageView imgSurfing = (ImageView)findViewById(R.id.gbrSurving);
        ImageView imgHiking = (ImageView)findViewById(R.id.gbrHiking);
        ImageView imgRafting = (ImageView)findViewById(R.id.gbrRafting);
        ImageView imgCycling = (ImageView)findViewById(R.id.gbrCycling);
        ImageView imgClimbing = (ImageView)findViewById(R.id.gbrClimbing);
        ImageView imgDiving = (ImageView)findViewById(R.id.gbrDiving);
        ImageView imgCaving = (ImageView)findViewById(R.id.gbrCaving);
        ImageView imgParalayang = (ImageView)findViewById(R.id.gbrParalayang);

        btnSurfing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surfing = new Intent(Adventure.this, Surfing.class);
                startActivity(surfing);
            }
        });
        btnHiking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hiking = new Intent(Adventure.this, Hiking.class);
                startActivity(hiking);
            }
        });

        btnRafting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rafting = new Intent(Adventure.this, Rafting.class);
                startActivity(rafting);
            }
        });
        btnCycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cycling = new Intent(Adventure.this, Cycling.class);
                startActivity(cycling);
            }
        });
        btnClimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent climbing = new Intent(Adventure.this, Climbing.class);
                startActivity(climbing);
            }
        });
        btnDiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diving = new Intent(Adventure.this, Diving.class);
                startActivity(diving);
            }
        });
        btnCaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent caving = new Intent(Adventure.this, Caving.class);
                startActivity(caving);
            }
        });
        btnParalayang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paralayang = new Intent(Adventure.this, Paralayang.class);
                startActivity(paralayang);
            }
        });

        imgSurfing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surfing = new Intent(Adventure.this, Surfing.class);
                startActivity(surfing);
            }
        });
        imgHiking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hiking = new Intent(Adventure.this, Hiking.class);
                startActivity(hiking);
            }
        });

        imgRafting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rafting = new Intent(Adventure.this, Rafting.class);
                startActivity(rafting);
            }
        });
        imgCycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cycling = new Intent(Adventure.this, Cycling.class);
                startActivity(cycling);
            }
        });
        imgClimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent climbing = new Intent(Adventure.this, Climbing.class);
                startActivity(climbing);
            }
        });
        imgDiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diving = new Intent(Adventure.this, Diving.class);
                startActivity(diving);
            }
        });
        imgCaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent caving = new Intent(Adventure.this, Caving.class);
                startActivity(caving);
            }
        });
        imgParalayang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paralayang = new Intent(Adventure.this, Paralayang.class);
                startActivity(paralayang);
            }
        });




    }
}
