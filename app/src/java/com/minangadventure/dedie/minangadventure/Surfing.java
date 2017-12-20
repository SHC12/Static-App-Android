package com.minangadventure.dedie.minangadventure;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Surfing extends AppCompatActivity {

    String[] judul = {"Pantai Mentawai","Pulau Sipora","Pantai Purus","Pantai Air Manis"};
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfing);

        ListView surfing = (ListView)findViewById(R.id.lvSurfing);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_surfing, R.id.judul, judul);
        surfing.setAdapter(arrayAdapter);


        surfing.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String txtList = adapterView.getItemAtPosition(i).toString();

                if(txtList.equals("Pantai Mentawai")){
                    Intent in = new Intent(Surfing.this, DetailSurfing.class);
                    startActivity(in);
                }else if(txtList.equals("Pulau Sipora")) {
                    Intent in = new Intent(Surfing.this, DetailSipora.class);
                    startActivity(in);
                }else if(txtList.equals("Pantai Purus")) {
                    Intent in = new Intent(Surfing.this, DetailPurus.class);
                    startActivity(in);
                }else if(txtList.equals("Pantai Air Manis")) {
                    Intent in = new Intent(Surfing.this, DetailManis.class);
                    startActivity(in);
                }
            }
        });



    }
}
