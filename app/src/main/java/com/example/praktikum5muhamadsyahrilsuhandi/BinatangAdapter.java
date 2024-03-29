package com.example.praktikum5muhamadsyahrilsuhandi;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BinatangAdapter extends ArrayAdapter <Binatang> {

    ArrayList<Binatang> allData;
    MediaPlayer media;


    public BinatangAdapter(Context context, int textViewResourceId, List<Binatang> object) {
        super(context, textViewResourceId, object);
        this.allData=(ArrayList<Binatang>) object;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v=convertView;
        if (v==null){
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.item_row_list, null);
        }

        Binatang binatang = allData.get(position);
        if (binatang!=null){
            TextView textJenis = (TextView)v.findViewById(R.id.item_nama);
            ImageView imgJenis = (ImageView)v.findViewById(R.id.img_item_foto);

            textJenis.setText(binatang.jenis);
            imgJenis.setImageResource(binatang.gambar);

            Button btnsuara = (Button)v.findViewById(R.id.btn_suara);

            final Integer filesuara=binatang.suara;
            btnsuara.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (media!=null&&media.isPlaying()){
                        media.stop();
                        media.release();

                    }
                    media=MediaPlayer.create(getContext(),filesuara);
                    media.setLooping(false);
                    media.start();
                }
            });
        }
        return v;
    }
}
