package com.example.miafandi.foody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.miafandi.foody.AppConfig.DatabaseConfig;
import com.example.miafandi.foody.AppConfig.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    TextView verifikasi_masuk, verifikasi_hubungi;
    EditText etNoKtp, etNama, etAlamat, etNoTelp, etEmail, etPassword, etPassword2;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //back botton
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog = new ProgressDialog(RegisterActivity.this);

        etNoKtp = (EditText) findViewById(R.id.etNoKTP);
        etNama = (EditText) findViewById(R.id.etNama);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        etNoTelp = (EditText) findViewById(R.id.etTelepon);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassword2 = (EditText) findViewById(R.id.etRePassword);

        register = (Button) findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register(etNoKtp.getText().toString(),
                        etNama.getText().toString(),
                        etAlamat.getText().toString(),
                        etNoTelp.getText().toString(),
                        etEmail.getText().toString(),
                        etPassword.getText().toString(),
                        etPassword2.getText().toString());

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

    public void Register(final String noktp, final String nama, final String alamat, final String notelp, final String email, final String pass, String ppass2){
        if(noktp.equals("")){
            etNoKtp.setError("No Ktp Wajib Diisi");
        }else if(nama.equals("")){
            etNama.setError("No Ktp Wajib Diisi");
        }else if(notelp.equals("")){
            etNoTelp.setError("Nomor Telphone Wajib Diisi");
        }else if(email.equals("")){
            etEmail.setError("Email Wajib Diisi");
        }else if(pass.equals("")){
            etPassword.setError("Password Harus Benar");
        }else{
            progressDialog.setMessage("Tunggu Proses Pendaftarana");
            progressDialog.show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);

//            StringRequest stringRequest = new StringRequest(Request.Method.POST,
//                    DatabaseConfig.REGISTER_USER, new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    progressDialog.dismiss();
//
//                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(RegisterActivity.this);
//                    View mView = getLayoutInflater().inflate(R.layout.activity_dialog_daftar, null);
//
//                    verifikasi_masuk = (TextView)mView.findViewById(R.id.verifikasi_login);
//                    verifikasi_hubungi = (TextView)mView.findViewById(R.id.verifikasi_hubungi);
//
//                    mBuilder.setView(mView);
//                    final AlertDialog dialog = mBuilder.create();
//                    dialog.show();
//
//                    verifikasi_masuk.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                        }
//                    });
//
//                    verifikasi_hubungi.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Toast.makeText(RegisterActivity.this,"send message to email",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    progressDialog.dismiss();
//                    Toast.makeText(RegisterActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
//                }
//            }){
//                @Override
//                protected Map<String, String> getParams() throws AuthFailureError {
//                    Map<String,String> params = new HashMap<>();
//                    params.put("ktp",noktp);
//                    params.put("password",pass);
//                    params.put("email",email);
//                    params.put("nama",nama);
//                    params.put("alamat",alamat);
//                    params.put("no_tlp",notelp);
//
//                    return params;
//                }
//            };
//            RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
        }

    }
}
