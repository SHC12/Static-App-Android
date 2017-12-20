package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Paralayang extends AppCompatActivity {
    String[] judulParalayang = {"Puncak Lawang","Bukit Taratak","Bukit Langkisau", "Puncak Polan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paralayang);


        ListView paralayang = (ListView)findViewById(R.id.lvParalayang);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_paralayang, R.id.judulParalayang, judulParalayang);

        paralayang.setAdapter(arrayAdapter);
        paralayang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtList = adapterView.getItemAtPosition(i).toString();

                if(txtList.equals("Puncak Lawang")){
                    Intent in = new Intent(Paralayang.this, DetailParagliding.class);
                    startActivity(in);
                }else if(txtList.equals("Bukit Taratak")){
                    Intent in = new Intent(Paralayang.this, DetailTaratak.class);
                    startActivity(in);
                }else if(txtList.equals("Bukit Langkisau")){
                    Intent in = new Intent(Paralayang.this, DetailLangkisau.class);
                    startActivity(in);
                }else if(txtList.equals("Puncak Polan")){
                    Intent in = new Intent(Paralayang.this, DetailPolan.class);
                    startActivity(in);
                }
            }
        });
    }
}
