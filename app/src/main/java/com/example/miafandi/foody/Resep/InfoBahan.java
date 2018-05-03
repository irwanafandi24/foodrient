package com.example.miafandi.foody.Resep;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miafandi.foody.Adapter.MakananAdapter;
import com.example.miafandi.foody.Model.Bahan;
import com.example.miafandi.foody.Model.BahanAdapter;
import com.example.miafandi.foody.Model.Makanan;
import com.example.miafandi.foody.R;

import java.util.ArrayList;
import java.util.List;


public class InfoBahan extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager reLayoutManager;
    private List<Bahan> bahanList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info_bahan, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleBahan);

        bahanList = new ArrayList();
        bahanList.add(new Bahan("Brokoli",new String[]{"Osteoporosis","Jantung"},R.drawable.brokoli,"Brokoli Merupakan salah satu Bahan masakan berjenis sayuran, dengan karaktersitik berwarna hijau, memiliki kandungan gizi yang sangat baik untuk kesehatan tulang, dan janutng"));
        bahanList.add(new Bahan("Bawang Merah",new String[]{"Batuk","Pilek","Flu"},R.drawable.bawangmerah,"Bawang merah selain paling sering digunakan sebagai salah satu rempah - rempah dalam menciptakan makanan yang lezat, naum juga memiliki kandungan gizi yang bagus untuk penderita batuk pilek"));
        bahanList.add(new Bahan("Brokoli",new String[]{"Osteoporosis","Jantung"},R.drawable.brokoli,"Brokoli Merupakan salah satu Bahan masakan berjenis sayuran, dengan karaktersitik berwarna hijau, memiliki kandungan gizi yang sangat baik untuk kesehatan tulang, dan janutng"));

        reLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setAdapter(new BahanAdapter(this.getContext(),bahanList));

        return rootView;
    }

}
