package com.example.miafandi.foody.Home._sliders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.miafandi.foody.Home.detailFoodItem;
import com.example.miafandi.foody.Model.Makanan;
import com.example.miafandi.foody.R;

import org.w3c.dom.Text;

/**
 * Created by bagicode on 12/04/17.
 */

public class FragmentSlider extends Fragment {

    private static final String ARG_PARAM1 = "params";
    private static final String ARG_PARAM2 = "nama";
    private static final String ARG_PARAM3 = "harga";

    private String imageUrls;

    public FragmentSlider() {
    }

    public static FragmentSlider newInstance(String params, String nama, String harga) {
        FragmentSlider fragment = new FragmentSlider();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, params);
        args.putString(ARG_PARAM2,nama);
        args.putString(ARG_PARAM3,harga);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        imageUrls = getArguments().getString(ARG_PARAM1);
        View view = inflater.inflate(R.layout.fragment_slider_item, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.imageHeader);
        Button btnPesan = (Button) view.findViewById(R.id.btn_pesan);

        TextView textView = (TextView) view.findViewById(R.id.text4);
        TextView textView2 = (TextView) view.findViewById(R.id.text5);

        textView.setText(getArguments().getString(ARG_PARAM2));
        textView2.setText("Cuma Rp."+getArguments().getString(ARG_PARAM3));

        Glide.with(getActivity())
                .load(imageUrls)
                .placeholder(R.drawable.iklan)
                .into(img);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), detailFoodItem.class);
                intent.putExtra("nama",getArguments().getString(ARG_PARAM2));
                intent.putExtra("gambar",imageUrls);
                intent.putExtra("bintang",4);
                intent.putExtra("harga",getArguments().getString(ARG_PARAM3));

                getContext().startActivity(intent);
            }
        });

        return view;
    }
}