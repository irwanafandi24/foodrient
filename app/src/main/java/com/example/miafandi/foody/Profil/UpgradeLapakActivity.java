package com.example.miafandi.foody.Profil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.miafandi.foody.MainActivity;
import com.example.miafandi.foody.R;

public class UpgradeLapakActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnKonfirmasi;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_lapak);

        btnBack = (ImageButton) findViewById(R.id.btnBackUpgrade);
        btnKonfirmasi = (Button) findViewById(R.id.btnKonfirmasi);

        btnKonfirmasi.setOnClickListener(this);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        if (v==btnBack){
            i.setClass(this, MainActivity.class);
        }else{

        }
        startActivity(i);
        finish();
    }
}
