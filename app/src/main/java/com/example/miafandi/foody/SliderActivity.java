package com.example.miafandi.foody;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.miafandi.foody.AppConfig.PreferenceIntro;

public class SliderActivity extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private SliderIntromanagerActivity introManager;
    private int[] layouts;
    private  TextView[] dots;
    private LinearLayout dotsLayout;
    Button next,skip;
    private PreferenceIntro preferenceIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceIntro = new PreferenceIntro(SliderActivity.this);

        introManager = new SliderIntromanagerActivity(this);
        if(!introManager.Check()){
            introManager.setFirst(false);
            Intent intent = new Intent(SliderActivity.this, LoginActivity.class);
            preferenceIntro.createIntro();
            startActivity(intent);
            finish();
        }

        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_slider);

        viewPager =(ViewPager) findViewById(R.id.viewPager);
        dotsLayout=(LinearLayout)findViewById(R.id.layoutDots);
        skip = (Button) findViewById(R.id.btnSkip);
        next = (Button) findViewById(R.id.btnNext);

        layouts = new int[]{R.layout.activity_screen_1,R.layout.activity_screen_2,R.layout.activity_screen_3};
        addButtomDots(0);
        changeStatusBarColor();
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SliderActivity.this, LoginActivity.class);
                preferenceIntro.createIntro();
                startActivity(intent);
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current<layouts.length){
                    viewPager.setCurrentItem(current);
                }else{
                    Intent intent = new Intent(SliderActivity.this, LoginActivity.class);
                    preferenceIntro.createIntro();
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    private void addButtomDots(int position){
        dots = new TextView[layouts.length];
        int [] colorActive = getResources().getIntArray(R.array.dot_active);
        int [] colorInactive = getResources().getIntArray(R.array.dot_inactive);
        dotsLayout.removeAllViews();
        for (int  i = 0; i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInactive[position]);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(colorActive[position]);
        }
    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+1;
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addButtomDots(position);
            if(position==layouts.length-1){
                next.setText("PROCEED");
                skip.setVisibility(View.GONE);
            }else{
                next.setText("NEXT");
                skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void changeStatusBarColor(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position],container,false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View) object;
            container.removeView(v);
        }
    }
}
