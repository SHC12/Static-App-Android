package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Climbing extends AppCompatActivity {
    String[] judulClimbing = {"Lembah Arau"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climbing);


        ListView climbing = (ListView)findViewById(R.id.lvClimbing);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_climbing, R.id.judulClimbing, judulClimbing);

        climbing.setAdapter(arrayAdapter);
        climbing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtList = adapterView.getItemAtPosition(i).toString();

                if(txtList.equals("Lembah Arau")){
                    Intent in = new Intent(Climbing.this, DetailClimbing.class);
                    startActivity(in);
                }
            }
        });
    }
}
