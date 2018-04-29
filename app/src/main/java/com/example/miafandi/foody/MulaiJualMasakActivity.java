package com.example.miafandi.foody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MulaiJualMasakActivity extends AppCompatActivity {

    private Button btnMUlaiJualan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai_jual_masak);

        btnMUlaiJualan = (Button) findViewById(R.id.btnJualan);
        btnMUlaiJualan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),InputMasakanActivity.class));
            }
        });

        btnMUlaiJualan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),InputMasakanActivity.class));
            }
        });
    }
}
