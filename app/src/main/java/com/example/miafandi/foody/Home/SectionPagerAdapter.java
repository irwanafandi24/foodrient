package com.example.miafandi.foody.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MIAfandi on 20/01/2018.
 */

/**
 * Class for adding fragmant tab.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter{
    private static final String TAG = "SectionPagerAdapter";
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment (Fragment fragment){
        mFragmentList.add(fragment);
    }
}
