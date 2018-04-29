package com.example.miafandi.foody.Profil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.miafandi.foody.MainActivity;
import com.example.miafandi.foody.R;

public class MenuLainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtBantuan, txtInformasi, txtAbout, txtHubungi, txtLogout;
    private ImageButton  btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lain);

        Toolbar tb= (Toolbar) findViewById(R.id.toolbarMenuLain);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtAbout = (TextView) findViewById(R.id.txtAbout);
        txtInformasi = (TextView) findViewById(R.id.txtInformasi);
        txtBantuan = (TextView) findViewById(R.id.txtBantuan);
        txtHubungi = (TextView) findViewById(R.id.txtTelphone);
        txtLogout = (TextView) findViewById(R.id.txtLogout);

        txtHubungi.setOnClickListener(this);
        txtBantuan.setOnClickListener(this);
        txtInformasi.setOnClickListener(this);
        txtAbout.setOnClickListener(this);
        txtLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();

        if (v==txtAbout){
            i.setClass(this.getApplicationContext(), MainActivity.class);
        }else if(v==txtBantuan){
            i.setClass(this.getApplicationContext(), MainActivity.class);
        }else if(v==txtHubungi){
            i.setClass(this.getApplicationContext(), MainActivity.class);
        }else if(v==txtInformasi){
            i.setClass(this.getApplicationContext(), MainActivity.class);
        }else{

        }
        startActivity(i);
        finish();
    }
}
