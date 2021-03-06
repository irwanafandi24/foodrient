package com.example.miafandi.foody.Bahan;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miafandi.foody.Adapter.ViewPagerAdapterBahan;
import com.example.miafandi.foody.R;

import java.util.ArrayList;
import java.util.List;

public class ResepFragment extends Fragment {

    List<Item>produckList = new ArrayList<>();
    int white = Color.parseColor("#ffffff");
    int grey = Color.parseColor("#bfbfbf");

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapterBahan pagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resep, container, false);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabInfoBahan);
        tabLayout.addTab(tabLayout.newTab().setText("Bahan Masakan"),0,true);
        tabLayout.addTab(tabLayout.newTab().setText("Buah Buahan"),1,false);

        viewPager = (ViewPager) rootView.findViewById(R.id.pagerInfoBahan);
        pagerAdapter= new ViewPagerAdapterBahan(this.getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                tabLayout.setTabTextColors();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setHasOptionsMenu(true);

        isiList();
        //--recycleView
//        listshowrcy=(RecyclerView) rootView.findViewById(R.id.recycleResep);
//        listshowrcy.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
//        listshowrcy.setLayoutManager(linearLayoutManager);
//        adapter = new ResepAdapter(produckList,this.getActivity());//this.getActivity diisi kelasnya
//        listshowrcy.setAdapter(adapter);

        return rootView;
    }

    public void isiList(){
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
