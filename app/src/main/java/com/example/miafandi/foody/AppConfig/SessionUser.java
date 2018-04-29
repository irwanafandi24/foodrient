package com.example.miafandi.foody.AppConfig;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.miafandi.foody.LoginActivity;
import com.example.miafandi.foody.SliderActivity;

import java.util.HashMap;

/**
 * Created by user on 10/02/2018.
 */

public class SessionUser {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";

    public static final String KEY_KTP = "ktp";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_TELP = "no_telp";
    public static final String KEY_ALAMAT = "alamat";

//    tinggal isi sessiondatanya apa aja, buat key dan isinya di commit
    public SessionUser(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createUserSession(String ktp, String nama, String email, String telp, String alamat){
        editor.clear();
        editor.commit();
        // Storing login value as TRUE
        editor.putString(KEY_KTP, ktp);
        editor.putString(KEY_NAMA, nama);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_TELP, telp);
        editor.putString(KEY_ALAMAT, alamat);

        editor.commit();
    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserId(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_KTP, String.valueOf(pref.getInt(KEY_KTP,0)));
        // return user
        return user;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }
}
