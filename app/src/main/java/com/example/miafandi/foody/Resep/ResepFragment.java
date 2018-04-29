package com.example.miafandi.foody.Resep;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miafandi.foody.R;

import java.util.ArrayList;
import java.util.List;

public class ResepFragment extends Fragment {
    Toolbar toolbarResep;
    SearchView searchView;
    RecyclerView listshowrcy;
    MenuItem menuItem;
    List<Item>produckList = new ArrayList<>();
    int white = Color.parseColor("#ffffff");
    int grey = Color.parseColor("#bfbfbf");

    ResepAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resep, container, false);

        //---Toolbar
        toolbarResep = (Toolbar) rootView.findViewById(R.id.toolbarResep);
        toolbarResep.setTitle("Info Bahan");
        toolbarResep.setTitleTextColor(white);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarResep);
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);
        //adding reseplist
        produckList.add(new Item("Soto Gule Sapi","Surabaya","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid1));
        produckList.add(new Item("Semur Jengkol","Banyuwangi","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid2));
        produckList.add(new Item("Cah Kangkung Krispi","Kertosono","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid3));
        produckList.add(new Item("Sambal Goreng Kulit","Bandung","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid4));
        produckList.add(new Item("Mie Melenial","Bandung","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid5));
        produckList.add(new Item("Ikan Ungkap Manis","Purwakerta","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid6));
        produckList.add(new Item("Soto Gule Sapi","Sumbawa","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid1));
        produckList.add(new Item("Semur Jengkol","Banten","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid2));
        produckList.add(new Item("Cah Kangkung Krispi","Banjar","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid3));
        produckList.add(new Item("Sambal Goreng Kulit","Klaten","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid4));
        produckList.add(new Item("Mie Melenial","Bandung","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid5));
        produckList.add(new Item("Ikan Ungkap Manis","Pulau Mas","Masakan yang sangat nikmat dan lezat khas Jawa Timur, resep sederhana",R.drawable.grid6));


        //--recycleView
//        listshowrcy=(RecyclerView) rootView.findViewById(R.id.recycleResep);
//        listshowrcy.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
//        listshowrcy.setLayoutManager(linearLayoutManager);
//        adapter = new ResepAdapter(produckList,this.getActivity());//this.getActivity diisi kelasnya
//        listshowrcy.setAdapter(adapter);

        return rootView;
    }



//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.searchfile, menu);
//        menuItem = menu.findItem(R.id.search);
//        searchView = (SearchView) menuItem.getActionView();
//        searchView.setIconified(false);
//        searchView.setQueryHint("Search by town");
//        changeSearchViewTextColor(searchView);
//        //menuItem.setVisible(true);
//
//        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                if(!searchView.isIconified()){
//                    searchView.setIconified(true);
//                    searchView.setBackgroundColor(grey);
//                }
//                menuItem.collapseActionView();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                final List<Item> filterModelList = filter(produckList,newText);
//                adapter.setfilter(filterModelList);
//                return false;
//            }
//        });
//
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    private List<Item> filter(List<Item>pl, String query){
//        query=query.toLowerCase();
//        final List<Item> filteredModeList = new ArrayList<>();
//        for (Item model:pl){
//            final String text = model.getKotaResep().toLowerCase();
//            if(text.startsWith(query)){
//                filteredModeList.add(model);
//            }
//        }
//        return  filteredModeList;
//    }
//
//    //Change Teks Color search
//    private void changeSearchViewTextColor(View view){
//        if(view != null){
//            if(view instanceof TextView){
//                ((TextView)view).setTextColor(Color.WHITE);
//                return;
//            }else if (view instanceof  ViewGroup){
//                ViewGroup viewGroup = (ViewGroup) view;
//                for (int i = 0; i < viewGroup.getChildCount();i++){
//                    changeSearchViewTextColor(viewGroup.getChildAt(i));
//                }
//            }
//        }
//    }

}
