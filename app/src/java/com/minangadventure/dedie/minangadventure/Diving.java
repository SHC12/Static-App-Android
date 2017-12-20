package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Diving extends AppCompatActivity {
    String[] judulDiving = {"Pulau Pagang","Pulau Cubadak","Pulau Pieh","Pulau Pandan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diving);


        ListView diving = (ListView)findViewById(R.id.lvDiving);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_diving, R.id.judulDiving, judulDiving);

        diving.setAdapter(arrayAdapter);
        diving.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtList = adapterView.getItemAtPosition(i).toString();

                if (txtList.equals("Pulau Pagang")) {
                    Intent in = new Intent(Diving.this, DetailDiving.class);
                    startActivity(in);
                }else if (txtList.equals("Pulau Cubadak")) {
                    Intent in = new Intent(Diving.this, DetailCubadak.class);
                    startActivity(in);
                } else if (txtList.equals("Pulau Pieh")) {
                    Intent in = new Intent(Diving.this, DetailPieh.class);
                    startActivity(in);
                } else if (txtList.equals("Pulau Pandan")) {
                    Intent in = new Intent(Diving.this, DetailPandan.class);
                    startActivity(in);
                }
            }

    });
}
}
