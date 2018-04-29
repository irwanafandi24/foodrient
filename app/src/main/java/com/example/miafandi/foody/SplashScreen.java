package com.example.miafandi.foody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.miafandi.foody.R;

public class SplashScreen extends AppCompatActivity {
    ProgressBar progressBar;
    LinearLayout upL,buttomL;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //progress bar controller
        progressBar =(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        final Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    //for time in 3 second
                    for (int i =0; i<100;i++){
                        progressBar.setProgress(i);
                        sleep(40);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(), SliderActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        thread.start();

        //animation home
        upL = (LinearLayout) findViewById(R.id.topLayout);
        buttomL = (LinearLayout) findViewById(R.id.buttomLayout);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        upL.setAnimation(uptodown);
        buttomL.setAnimation(downtoup);
    }
}

