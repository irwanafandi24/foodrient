package com.example.miafandi.foody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.example.miafandi.foody.AppConfig.PreferenceIntro;
import com.example.miafandi.foody.AppConfig.RequestHandler;
import com.example.miafandi.foody.AppConfig.SessionUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnDaftar;
    private PreferenceIntro preferenceIntro;
    private StringRequest stringRequest;
    private SessionUser sessionUser;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferenceIntro = new PreferenceIntro(LoginActivity.this);
        preferenceIntro.checkProceed();

        progressDialog = new ProgressDialog(LoginActivity.this);

        sessionUser = new SessionUser(LoginActivity.this);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);

        //move to popup login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(LoginActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_dialog_login, null);

                final EditText user = (EditText) mView.findViewById(R.id.username);
                final EditText passwd = (EditText) mView.findViewById(R.id.password);
                Button btnMasuk = (Button) mView.findViewById(R.id.btnMasuk);
                TextView lupaSandi = (TextView) mView.findViewById(R.id.lupaKataSandi);
                TextView cancleBtn = (TextView) mView.findViewById(R.id.cancle);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btnMasuk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!user.getText().toString().isEmpty() && !passwd.getText().toString().isEmpty()){
                            Login(user.getText().toString(),passwd.getText().toString());
                        }else{
                            Toast.makeText(LoginActivity.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                lupaSandi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                        startActivity(intent);
                    }
                });

                cancleBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Login(final String email, final String password) {
        progressDialog.setMessage("Harap Menunggu");
        progressDialog.show();
        if(!email.equals("") && !password.equals("")){
            startActivity(new Intent(this.getBaseContext(), MainActivity.class));
        }
//        stringRequest = new StringRequest(Request.Method.POST,
//                DatabaseConfig.LOGIN_USER,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        progressDialog.dismiss();
//                        Toast.makeText(LoginActivity.this,response,Toast.LENGTH_SHORT).show();
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            if(jsonObject.getInt("success") != 0){
//                                JSONArray jsonArray = jsonObject.getJSONArray("user");
//                                sessionUser.createUserSession(
//                                        jsonArray.getJSONObject(0).getString("ktp"),
//                                        jsonArray.getJSONObject(0).getString("nama"),
//                                        jsonArray.getJSONObject(0).getString("email"),
//                                        jsonArray.getJSONObject(0).getString("no_tlp"),
//                                        jsonArray.getJSONObject(0).getString("alamat")
//                                );
//                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                                finish();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map = new HashMap<>();
//                map.put("email",email);
//                map.put("password",password);
//                return map;
//            }
//        };
//        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
}
