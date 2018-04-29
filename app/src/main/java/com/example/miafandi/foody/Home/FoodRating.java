package com.example.miafandi.foody.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.miafandi.foody.MainActivity;
import com.example.miafandi.foody.R;

public class FoodRating extends AppCompatActivity {

    Button button;
    ImageView imgRating;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_rating);

        //back botton
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.submitRating);
        imgRating = (ImageView) findViewById(R.id.ratingImage);
        ratingBar = (RatingBar) findViewById(R.id.ratingBarRate);

        Intent intent = getIntent();
        imgRating.setImageResource(intent.getIntExtra("gambar",0));
        ratingBar.setRating(intent.getIntExtra("bintang",0));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FoodRating.this, "Terimakasih Telah Memberi Ratting", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FoodRating.this,MainActivity.class);
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
