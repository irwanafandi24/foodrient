package com.example.miafandi.foody.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.miafandi.foody.Transaksi.FragmentMasakanHari;
import com.example.miafandi.foody.Transaksi.VotingHariFragment;

/**
 * Created by user on 09/02/2018.
 */

public class ViewPagerAdapterTransaksi extends FragmentStatePagerAdapter{
    private int position;

    public ViewPagerAdapterTransaksi(android.support.v4.app.FragmentManager fm, int position) {
        super(fm);
        this.position = position;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentMasakanHari masakanHariIni = new FragmentMasakanHari();
                return masakanHariIni;
            case 1:
                VotingHariFragment votingMasakan = new VotingHariFragment();
                return votingMasakan;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return position;
    }
}
