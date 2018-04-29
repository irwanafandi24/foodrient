package com.example.miafandi.foody;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.miafandi.foody.Adapter.ViewPagerAdapterTransaksi;

public class TransaksiActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapterTransaksi pagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        Toolbar tb= (Toolbar) findViewById(R.id.toolbarMenuTransaksi);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabTransaksi);
        tabLayout.addTab(tabLayout.newTab().setText("Masakan Hari Ini"),0,true);
        tabLayout.addTab(tabLayout.newTab().setText("Voting Masakan"),1,false);

        viewPager = (ViewPager) findViewById(R.id.pagerTransaksi);
        pagerAdapter= new ViewPagerAdapterTransaksi(this.getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
