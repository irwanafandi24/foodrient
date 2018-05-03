package com.example.miafandi.foody.Model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.miafandi.foody.Home.detailFoodItem;
import com.example.miafandi.foody.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by user on 04/05/2018.
 */

public class BahanAdapter extends RecyclerView.Adapter<BahanAdapter.MyViewHolder>{
    private Context context;
    private List<Bahan> list;

    public BahanAdapter(Context context, List<Bahan> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bahan,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtPenyakit;
        private int image;

        public MyViewHolder(View itemView) {
            super(itemView);


        }
    }
}