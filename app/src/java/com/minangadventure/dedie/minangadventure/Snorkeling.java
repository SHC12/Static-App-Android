package com.minangadventure.dedie.minangadventure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Snorkeling extends AppCompatActivity {
    String[] judulSnorkeling = {"Puncak Lawang","Bukit Taratak","Bukit Langkisau", "Puncak Polan","Bukit Lambe"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snorkeling);
        ListView snorkeling = (ListView)findViewById(R.id.lvSnorkeling);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_snorkeling, R.id.judulSnorkeling, judulSnorkeling);

        snorkeling.setAdapter(arrayAdapter);
    }
}
