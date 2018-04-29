package com.example.miafandi.foody.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miafandi.foody.Home.CateringAdapter.GridAdapter;
import com.example.miafandi.foody.R;

public class CateringFragment extends Fragment {

    //grid
    ViewPager viewPager;
    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    public CateringFragment() {
        // Required empty public constructor
    }

    public static CateringFragment newInstance() {
        CateringFragment fragment = new CateringFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_catering, container, false);

        //Grid View
        mRecycleView = (RecyclerView) rootView.findViewById(R.id.recycleCatering);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter(this.getContext());
        mRecycleView.setAdapter(mAdapter);

        return rootView;
    }
}
