package com.example.miafandi.foody.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.miafandi.foody.Resep.InfoBahan;
import com.example.miafandi.foody.Resep.InfoBuah;
import com.example.miafandi.foody.Transaksi.FragmentMasakanHari;
import com.example.miafandi.foody.Transaksi.VotingHariFragment;

/**
 * Created by user on 09/02/2018.
 */

public class ViewPagerAdapterBahan extends FragmentStatePagerAdapter{
    private int position;

    public ViewPagerAdapterBahan(android.support.v4.app.FragmentManager fm, int position) {
        super(fm);
        this.position = position;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                InfoBahan infoBahan = new InfoBahan();
                return infoBahan;
            case 1:
                 InfoBuah infoBuah = new InfoBuah();
                return infoBuah;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return position;
    }
}
