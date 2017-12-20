package com.minangadventure.dedie.minangadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Cycling extends AppCompatActivity {
    String[] judulCycling = {"Batu Busuk","Patar Bike Park"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycling);


        ListView cycling = (ListView)findViewById(R.id.lvCycling);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.itemlist_cycling, R.id.judulCycling, judulCycling);

        cycling.setAdapter(arrayAdapter);
        cycling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtList = adapterView.getItemAtPosition(i).toString();

                if (txtList.equals("Batu Busuk")) {
                    Intent in = new Intent(Cycling.this, DetailCycling.class);
                    startActivity(in);
                } else if (txtList.equals("Patar Bike Park")) {
                    Intent in = new Intent(Cycling.this, DetailPatar.class);
                    startActivity(in);

                }
            }


});
}
}
