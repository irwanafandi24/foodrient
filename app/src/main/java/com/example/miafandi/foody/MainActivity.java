package com.example.miafandi.foody;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.example.miafandi.foody.Utils.BottomNavigationViewHelper;
import com.example.miafandi.foody.Home.HomeFragment;
import com.example.miafandi.foody.Bahan.ResepFragment;
import com.example.miafandi.foody.Map.MapFragment;
import com.example.miafandi.foody.Profil.ProfileFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = "HomeActivity";
    private FirebaseAuth firebaseAuth;
    RadioButton rb1,rb2,rb3;
    Button btnSurvey;
    int checkedRadioButton = 0;

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb1:
                    checkedRadioButton = 1;
                    break;
                case R.id.rb2:
                    checkedRadioButton = 2;
                    break;
                case R.id.rb3:
                    checkedRadioButton = 3;
                    break;
            }
        }
    };
    private String getOption(){
        if(checkedRadioButton == 0){
            return "Tidak ada option yang dipilih";
        }else if(checkedRadioButton == 1){
            return "Option 1 terpilih";
        }else if(checkedRadioButton == 2){
            return "Option 2 terpilih";
        }else if(checkedRadioButton == 3){
            return "Option 3 terpilih";
        }else
            return "Option salah";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        Toast.makeText(MainActivity.this,"Selamat Datang "+user.getEmail(),Toast.LENGTH_LONG).show();
        //dialog
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_dialog_survey, null);

        //radioButton
        rb1 = (RadioButton) mView.findViewById(R.id.rb1);
        rb2 = (RadioButton) mView.findViewById(R.id.rb2);
        rb3 = (RadioButton) mView.findViewById(R.id.rb3);
        btnSurvey = (Button) mView.findViewById(R.id.btnVoting);
        RadioGroup radioGroup = (RadioGroup) mView.findViewById(R.id.radioGroup);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
//        dialog.show();

        radioGroup.setOnCheckedChangeListener(checkedChangeListener);
        btnSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Voting anda: "+getOption(),Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });



        //setup fragment

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());

        //setup bottom nav view
        setupBottomNavigationView();
    }

    //BottomNavigationView setUp ==> Utils/BottomNavigationViewHelper
    private void setupBottomNavigationView(){
        Log.d(TAG,"setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.btmNavHome:
                fragment = new HomeFragment();
                break;
            case R.id.btmNavMap:
                fragment = new MapFragment();
                break;
            case R.id.btmNavResep:
                fragment = new ResepFragment();
                break;
            case R.id.btmNavProfile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
