package com.example.miafandi.foody.Bahan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miafandi.foody.Model.Bahan;
import com.example.miafandi.foody.Model.BahanAdapter;
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
        bahanList.add(new Bahan("Wortel",new String[]{"Pencegahan Kanker","Pandangan Kabur"},R.drawable.wortel,"Manfaat wortel sangat beragam, tidak hanya untuk kesehatan tapi juga dapat digunakan untuk berbagai kebutuhan lainnya,  Wortel merupakan sayuran yang sangat berkhasiat"));
        bahanList.add(new Bahan("Kunyit",new String[]{"Penyakit Maagh","Penyakit Kanker Payudara"},R.drawable.kunyit,"manfaat kunyit putih mangandung sejumlah zat yang mampu mengendalikan gejala kanker karena mampu menahan peradangan dan pembengkakan jaringan tubuh."));
        bahanList.add(new Bahan("Bayam",new String[]{"Osteoporosis","Jantung"},R.drawable.bayam,"bayam mengandung folic acid yang mampu melindungi otot jantung dari meningkatnya kadar glukosa yang menyebabkan penyakit diabetes"));
        bahanList.add(new Bahan("Brokoli",new String[]{"Osteoporosis","Jantung"},R.drawable.brokoli,"Brokoli Merupakan salah satu Bahan masakan berjenis sayuran, dengan karaktersitik berwarna hijau, memiliki kandungan gizi yang sangat baik untuk kesehatan tulang, dan janutng"));
        bahanList.add(new Bahan("Bawang Merah",new String[]{"Batuk","Pilek","Flu"},R.drawable.bawangmerah,"Bawang merah selain paling sering digunakan sebagai salah satu rempah - rempah dalam menciptakan makanan yang lezat, naum juga memiliki kandungan gizi yang bagus untuk penderita batuk pilek"));

        reLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setAdapter(new BahanAdapter(this.getContext(),bahanList));

        return rootView;
    }

}
