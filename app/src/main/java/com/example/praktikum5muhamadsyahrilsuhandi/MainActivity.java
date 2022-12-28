package com.example.praktikum5muhamadsyahrilsuhandi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Binatang> allData= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allData.add(new Binatang("Anjing",R.drawable.anjing,R.raw.anjing));
        allData.add(new Binatang("Bebek",R.drawable.bebek,R.raw.bebek));
        allData.add(new Binatang("Burung",R.drawable.burung,R.raw.burung));
        allData.add(new Binatang("Gajah",R.drawable.gajah,R.raw.gajah));
        allData.add(new Binatang("Harimau",R.drawable.harimau,R.raw.harimau));
        allData.add(new Binatang("Kambing",R.drawable.kambing,R.raw.kambing));
        allData.add(new Binatang("Kucing",R.drawable.kucing,R.raw.kucing));
        allData.add(new Binatang("Kuda",R.drawable.kuda,R.raw.kuda));
        allData.add(new Binatang("Monyet",R.drawable.monyet,R.raw.monyet));
        allData.add(new Binatang("Sapi",R.drawable.sapi,R.raw.sapi));

        ListView listView=(ListView) findViewById(R.id.listView);
        BinatangAdapter adapter=new BinatangAdapter(this,R.layout.item_row_list,allData);
        listView.setAdapter(adapter);
    }
    public void pindahKeGrid(View v) {
        Intent i=new Intent(MainActivity.this, GridViewActivity.class);
        startActivity(i);
        finish();
    }

}