package com.example.miafandi.foody.Resep;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miafandi.foody.R;

public class DetailResepActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView txtbahan, txtJudul, txtLankgah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);

        imageView = (ImageView) findViewById(R.id.imageDetail);
        txtbahan = (TextView) findViewById(R.id.txtBahanan);
        txtJudul = (TextView) findViewById(R.id.txtJudulResep);

        Intent i = getIntent();
        txtJudul.setText(i.getStringExtra("Judul"));
        txtbahan.setText(i.getStringExtra("detailResep"));
//        imageView.setImageResource(Integer.parseInt(i.getStringExtra("image")));
        imageView.setImageResource(i.getIntExtra("image",R.drawable.grid6));
    }
}
