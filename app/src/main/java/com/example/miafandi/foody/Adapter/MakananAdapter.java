package com.example.miafandi.foody.Adapter;

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
import com.example.miafandi.foody.Model.Makanan;
import com.example.miafandi.foody.R;

import java.util.List;

/**
 * Created by user on 14/04/2018.
 */

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MyViewHolder>{

    private Context context;
    private List<Makanan> list;

    public MakananAdapter(Context context, List<Makanan> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MakananAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_isimakanan,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MakananAdapter.MyViewHolder holder, int position) {
        Makanan makan = list.get(position);
        holder.txtNamaMakanan.setText(makan.getNama());
        holder.txtPenyakit.setText(makan.getPenyakit());
        holder.txtHargaMakanan.setText(makan.getHarga());
        holder.ratingBar.setRating(makan.getBintang());
        holder.makananitem.setImageResource(makan.getDrawable());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNamaMakanan, txtHargaMakanan,txtPenyakit;
        RatingBar ratingBar;
        ImageView makananitem;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtHargaMakanan = (TextView) itemView.findViewById(R.id.hargaMakanan);
            txtPenyakit = (TextView)itemView.findViewById(R.id.penyakit);
            txtNamaMakanan = (TextView) itemView.findViewById(R.id.namaMakananItem);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratng_makanan);
            makananitem = (ImageView) itemView.findViewById(R.id.imageMakanananItem);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Makanan contentTemp = list.get(position);
            Intent intent = new Intent(context, detailFoodItem.class);
            intent.putExtra("nama",txtNamaMakanan.getText().toString());
            intent.putExtra("gambar",contentTemp.getDrawable());
            intent.putExtra("bintang",contentTemp.getBintang());

            context.startActivity(intent);
        }
    }
}
