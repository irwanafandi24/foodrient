package com.example.miafandi.foody.Resep;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miafandi.foody.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MIAfandi on 02/02/2018.
 */

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.Holderview>{
    private List<Item>productlist;
    private Context context;

    public ResepAdapter(List<Item> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }

    @Override
    public Holderview onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.customitem,parent,false);
        return new Holderview(layout);
    }

    @Override
    public void onBindViewHolder(final Holderview holder, final int position) {
        holder.v_namaResep.setText(productlist.get(position).getNamaResep());
        holder.v_hargaResep.setText(productlist.get(position).getKotaResep());
        holder.v_detailResep.setText(productlist.get(position).getDetailResep());
        holder.v_imageResep.setImageResource(productlist.get(position).getImageResep());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"click on"+productlist.get(position).getNamaResep(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent();
                i.putExtra("Judul",productlist.get(position).getNamaResep());
                i.putExtra("detailResep",productlist.get(position).getDetailResep());
                i.putExtra("image",productlist.get(position).getImageResep());
                i.setClass(context,DetailResepActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public void setfilter(List<Item> listItem){
        productlist = new ArrayList<>();
        productlist.addAll(listItem);
        notifyDataSetChanged();
    }

    public class Holderview extends RecyclerView.ViewHolder{
        TextView v_namaResep;
        TextView v_hargaResep;
        TextView v_detailResep;
        ImageView v_imageResep;

        Holderview(View itemview){
            super(itemview);
//            itemview.setOnClickListener(this);
            v_namaResep=(TextView) itemview.findViewById(R.id.namaResepItem);
            v_hargaResep=(TextView) itemview.findViewById(R.id.harga);
            v_detailResep=(TextView) itemview.findViewById(R.id.harga);
            v_imageResep=(ImageView) itemview.findViewById(R.id.imageResepItem);
        }

    }
}
