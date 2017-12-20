package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Hiking extends AppCompatActivity {
    String[] judulHiking = {"Gunung Singgalang","Gunung Marapi","Gunung Talang","Gunung Tandikek","Gunung Talamau","Gunung Sago"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking);

        ListView hiking = (ListView)findViewById(R.id.lvHiking);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_hiking, R.id.judulHiking, judulHiking);

        hiking.setAdapter(arrayAdapter);
        hiking.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtList = adapterView.getItemAtPosition(i).toString();

                if(txtList.equals("Gunung Singgalang")){
                    Intent in = new Intent(Hiking.this, DetailHiking.class);
                    startActivity(in);
                }else if(txtList.equals("Gunung Marapi")){
                    Intent in = new Intent(Hiking.this, DetailMarapi.class);
                    startActivity(in);
                }else if(txtList.equals("Gunung Talang")){
                    Intent in = new Intent(Hiking.this, DetailTalang.class);
                    startActivity(in);
                }else if(txtList.equals("Gunung Tandikek")){
                    Intent in = new Intent(Hiking.this, DetailTandikek.class);
                    startActivity(in);
                }else if(txtList.equals("Gunung Talamau")){
                    Intent in = new Intent(Hiking.this, DetailTalamau.class);
                    startActivity(in);
                }else if(txtList.equals("Gunung Sago")){
                    Intent in = new Intent(Hiking.this, DetailSago.class);
                    startActivity(in);
                }

            }
        });
    }
}
