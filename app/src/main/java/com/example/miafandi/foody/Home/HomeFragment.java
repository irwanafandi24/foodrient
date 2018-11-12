package com.example.miafandi.foody.Home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miafandi.foody.Adapter.MakananAdapter;
import com.example.miafandi.foody.Home._sliders.FragmentSlider;
import com.example.miafandi.foody.Home._sliders.SliderIndicator;
import com.example.miafandi.foody.Home._sliders.SliderPagerAdapter;
import com.example.miafandi.foody.Home._sliders.SliderView;
import com.example.miafandi.foody.LoginActivity;
import com.example.miafandi.foody.Model.Makanan;
import com.example.miafandi.foody.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    AppBarLayout Appbar;
    CollapsingToolbarLayout CoolToolbar;
    ImageView img;
    Toolbar toolbar;
    Boolean ExpandedActionBar = true;

    //grid
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager reLayoutManager;
    private List<Makanan> makananList;

    //Tab
    private static final int ACTIVITY_NUM = 0;
    private Context mContext = getActivity(); //gimana nih

    //sliderImage
    private SliderPagerAdapter mAdapterSlider;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    private TextView txtFilter;
    private ImageView imgFilter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.MyToolbar);
        Appbar = (AppBarLayout) rootView.findViewById(R.id.MyAppbar);
        CoolToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.MyCollapseToolbar);
        img = (ImageView) rootView.findViewById(R.id.imageHeader);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleFilter);

        txtFilter = (TextView) rootView.findViewById(R.id.txtFilter);
        imgFilter = (ImageView) rootView.findViewById(R.id.imgFilter);

        makananList = new ArrayList();
        makananList.add(new Makanan("SALAD SAYUR SEGAR",15000,4,R.drawable.salad).setPenyakit2("Jantung").setPenyakit2("Darah rendah").setPenyakit2("Liver"));
        makananList.add(new Makanan("KACANG HIJAU ALMON ",14000,3,R.drawable.bubur).setPenyakit2("Kolesterol").setPenyakit2("Darah Tinggi").setPenyakit2("Liver"));
        makananList.add(new Makanan("TAHU TEMPE NABATI",12000,3,R.drawable.grid1).setPenyakit2("Kolesterol").setPenyakit2("Minyak Nabati"));
        makananList.add(new Makanan("SALAD SAYUR SEGAR",15000,4,R.drawable.salad).setPenyakit2("Jantung").setPenyakit2("Darah rendah").setPenyakit2("Liver"));
        makananList.add(new Makanan("KACANG HIJAU ALMON ",14000,3,R.drawable.bubur).setPenyakit2("Kolesterol").setPenyakit2("Darah Tinggi").setPenyakit2("Liver"));
        makananList.add(new Makanan("TAHU TEMPE NABATI",12000,3,R.drawable.grid1).setPenyakit2("Kolesterol").setPenyakit2("Minyak Nabati"));

        reLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setAdapter(new MakananAdapter(this.getContext(),makananList,""));

        final String mycolor = "#ffffff";

        Appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) > 180){
                    ExpandedActionBar = false;
                    CoolToolbar.setTitle("Nutrifood");
                    //CoolToolbar.setContentScrimColor(Color.parseColor("#ffffff"));
                }else{
                    ExpandedActionBar = true;
                    CoolToolbar.setTitle(" ");
                }
            }
        });

        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(rootView.getContext());
                final View mView = getLayoutInflater().inflate(R.layout.activity_dialog_filter, null);

                Button reset, filter;
                TextView cancel;
                final EditText etHarga;
                final Spinner etPenyakit;

                reset = (Button) mView.findViewById(R.id.btnReset);
                filter = (Button) mView.findViewById(R.id.btnFilter);
                cancel = (TextView) mView.findViewById(R.id.cancleFilter);

                etHarga = (EditText) mView.findViewById(R.id.hargaFilter);
                etPenyakit = (Spinner) mView.findViewById(R.id.jenisPenyakit);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                        R.array.penyakit, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                etPenyakit.setAdapter(adapter);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etHarga.setText("");
                        etPenyakit.setSelection(0,true);
                    }
                });

                filter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mView.getContext(),"Filtered",Toast.LENGTH_SHORT).show();
                        reLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(reLayoutManager);
                        recyclerView.setAdapter(new MakananAdapter(
                                getContext(),
                                filterPenyakit(etPenyakit.getItemAtPosition(etPenyakit.getSelectedItemPosition()).toString(),makananList),"")
                                );
                        dialog.dismiss();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });
        return rootView;
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://sehatjajanan.files.wordpress.com/2014/11/resep-masakan-sehat-5.jpg","SALAD BUAH BU IYEM","10000"));
        fragments.add(FragmentSlider.newInstance("http://3.bp.blogspot.com/-MvTzW-vJalc/VPqcC_mV23I/AAAAAAAACug/JJZ2qSAOPMM/s1600/Resep%2BMasakan%2BSehat%2BSalad%2BSayur.jpg","Salad Sayur Segar","15000"));
        fragments.add(FragmentSlider.newInstance("https://cdn1-a.production.liputan6.static6.com/medias/949669/big/021372800_1438999989-4573116519_9979df02cb_b.jpg","Sawi Segar","10000"));
        fragments.add(FragmentSlider.newInstance("https://cdns.klimg.com/vemale.com/headline/650x325/2014/02/resep-sehat-lumpia-sayur-segar-tanpa-goreng.jpg","Lumpia Organik","12000"));
//        fragments.add(FragmentSlider.newInstance(R.drawable.borderbackground));

        mAdapterSlider = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapterSlider);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

    public List<Makanan> filterPenyakit(String penyakit, List<Makanan> makananList){
        List<Makanan> makanans = new ArrayList();
        for (int i = 0; i < makananList.size(); i++) {
            boolean include = false;
            for (int j = 0; j < makananList.get(i).getPenyakitSize(); j++) {
                if(makananList.get(i).getPenyakit(j).equals(penyakit)){
                    include = true;
                    break;
                }
            }
            if(include == true){
                makanans.add(makananList.get(i));
            }
        }
        return makanans;
    }
}
