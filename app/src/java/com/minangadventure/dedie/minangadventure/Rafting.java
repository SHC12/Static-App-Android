package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Rafting extends AppCompatActivity {
    String[] judulRafting = {"Sungai Batang Tarusan","Batang Antokan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rafting);

        ListView rafting = (ListView)findViewById(R.id.lvRafting);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_rafting, R.id.judulRafting, judulRafting);

        rafting.setAdapter(arrayAdapter);
        rafting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtList = adapterView.getItemAtPosition(i).toString();

                if(txtList.equals("Sungai Batang Tarusan")){
                    Intent in = new Intent(Rafting.this, DetailRafting.class);
                    startActivity(in);
                }else if(txtList.equals("Batang Antokan")){
                    Intent in = new Intent(Rafting.this, DetailAntokan.class);
                    startActivity(in);
                }
            }
        });
    }
}
