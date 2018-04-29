package com.example.miafandi.foody;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPasswordActivity extends AppCompatActivity {
    Button forget;
    TextView verifikasi_masuk, verifikasi_hubungi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        //back botton
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        forget = (Button) findViewById(R.id.btn_forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ForgetPasswordActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_dialog_forget_password, null);

                verifikasi_masuk = (TextView)mView.findViewById(R.id.verifikasi_login_forget);
                verifikasi_hubungi = (TextView)mView.findViewById(R.id.verifikasi_hubungi_forget);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                verifikasi_masuk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });

                verifikasi_hubungi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ForgetPasswordActivity.this,"send message to email",Toast.LENGTH_SHORT).show();
                    }
                });
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
