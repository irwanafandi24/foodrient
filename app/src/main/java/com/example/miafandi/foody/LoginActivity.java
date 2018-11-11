package com.example.miafandi.foody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
    private EditText editTextUsername, editTextPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
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

                editTextUsername = (EditText) mView.findViewById(R.id.username);
                editTextPassword = (EditText) mView.findViewById(R.id.password);
                Button btnMasuk = (Button) mView.findViewById(R.id.btnMasuk);
                TextView lupaSandi = (TextView) mView.findViewById(R.id.lupaKataSandi);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btnMasuk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    userLogin();
                    }
                });

                lupaSandi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                        startActivity(intent);
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

    private void userLogin(){
        String email = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please fill email", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please fill password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Register User....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Username or password maybe wrong", Toast.LENGTH_LONG).show();
                }
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
