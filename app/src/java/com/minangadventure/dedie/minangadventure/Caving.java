package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Caving extends AppCompatActivity {
    String[] judulCaving = {"Ngalau Indah","Ngalau Talago"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caving);


        ListView caving = (ListView)findViewById(R.id.lvCaving);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_caving, R.id.judulCaving, judulCaving);

        caving.setAdapter(arrayAdapter);
        caving.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtList = adapterView.getItemAtPosition(i).toString();

                if(txtList.equals("Ngalau Indah")){
                    Intent in = new Intent(Caving.this, DetailCaving.class);
                    startActivity(in);
                }else if(txtList.equals("Ngalau Talago")) {
                    Intent in = new Intent(Caving.this, DetailTalago.class);
                    startActivity(in);
                }
            }
        });
    }
}
