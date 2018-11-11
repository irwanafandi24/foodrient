package com.example.miafandi.foody.Home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.miafandi.foody.R;

public class detailFoodItem extends AppCompatActivity {
    TextView pesanHarga, pesanTotalHarga, pesanKirim, pesanTotal, add, count, minus;
    Toolbar toolbar;
    int white = Color.parseColor("#ffffff");
    int jumlah = 1;
    int hargaAsli;
    int kirim;
    Button button;

    TextView detailFoodNama;
    ImageView imageDetailFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food_item);

        //back botton
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pesanHarga = (TextView) findViewById(R.id.pesanHarga);
        pesanTotal = (TextView) findViewById(R.id.pesanTotal);
        pesanTotalHarga = (TextView) findViewById(R.id.pesanTotalHarga);
        pesanKirim = (TextView) findViewById(R.id.pesanKirim);

        detailFoodNama = (TextView) findViewById(R.id.detailFoodNama);
        imageDetailFood = (ImageView) findViewById(R.id.imageDetailFood);

        final Intent i = getIntent();
        final String nama = i.getStringExtra("nama");

        final int gambar = i.getIntExtra("gambar",0);
        final String gambar1 = i.getStringExtra("gambar");

        final int bintang = i.getIntExtra("bintang",0);
        detailFoodNama.setText(nama);

        if(gambar ==0 ){
            Log.e("masuk",gambar1);
            Glide.with(this)
                    .load(gambar1)
                    .placeholder(R.drawable.iklan)
                    .into(imageDetailFood);
        }else{
            imageDetailFood.setImageResource(gambar);
        }


        add = (TextView) findViewById(R.id.increment);
        count = (TextView) findViewById(R.id.count);
        minus = (TextView) findViewById(R.id.decrement);
        button = (Button) findViewById(R.id.btnPesan);
        pesanHarga.setText(i.getStringExtra("harga"));

        hargaAsli = Integer.parseInt(pesanHarga.getText().toString());
        kirim = Integer.parseInt(pesanKirim.getText().toString());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah++;
                count.setText(String.valueOf(jumlah));

                pesanTotalHarga.setText(String.valueOf(jumlah*hargaAsli));
                pesanTotal.setText(String.valueOf(((jumlah*hargaAsli))+kirim));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jumlah>0) {
                    jumlah--;
                    count.setText(String.valueOf(jumlah));
                }
                pesanTotalHarga.setText(String.valueOf(jumlah*hargaAsli));
                pesanTotal.setText(String.valueOf(((jumlah*hargaAsli))+kirim));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailFoodItem.this,FoodRating.class);
                intent.putExtra("nama",nama);
                intent.putExtra("gambar",gambar);
                intent.putExtra("bintang",bintang);

                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
