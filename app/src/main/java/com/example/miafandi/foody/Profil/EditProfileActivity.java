package com.example.miafandi.foody.Profil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miafandi.foody.MainActivity;
import com.example.miafandi.foody.R;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSimpan;
    private EditText txtNama, txtLokasi, txttanggal,etJenisKelamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(this);

        txtLokasi = (EditText) findViewById(R.id.etLokasi);
        txtNama = (EditText) findViewById(R.id.etNamaEdit);
        txttanggal = (EditText) findViewById(R.id.etTglLahir);
        etJenisKelamin = (EditText) findViewById(R.id.etJenisKelamin);

        Toolbar tb= (Toolbar) findViewById(R.id.toolbarMenuEdit);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        editProfile(txtNama.getText().toString(),txttanggal.getText().toString(),
                txtLokasi.getText().toString(), etJenisKelamin.getText().toString());
    }

    public void editProfile(String nama, String lokasi, String TglLahir, String JenisKelamin){
        Toast.makeText(this,"Edit Profile Berhasil Dilakukan",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}
