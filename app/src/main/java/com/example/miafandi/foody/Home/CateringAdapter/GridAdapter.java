package com.example.miafandi.foody.Home.CateringAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miafandi.foody.Home.detailFoodItem;
import com.example.miafandi.foody.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;
    Context context;

    public GridAdapter(Context context) {
        super();
        this.context = context;

        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem jualan = new EndangeredItem();
        jualan.setName("Ayam Saus Padang");
        jualan.setThumbnail(R.drawable.cat1);
        jualan.setPrice("1000");
        mItems.add(jualan);

        jualan = new EndangeredItem();
        jualan.setName("Nasi Merah Tuna");
        jualan.setThumbnail(R.drawable.cat2);
        jualan.setPrice("10000");
        mItems.add(jualan);

        jualan = new EndangeredItem();
        jualan.setName("Nasi Pecel Ayam");
        jualan.setThumbnail(R.drawable.cat3);
        jualan.setPrice("8000");
        mItems.add(jualan);

        jualan = new EndangeredItem();
        jualan.setName("Lodeh Tahu Pedas");
        jualan.setThumbnail(R.drawable.cat4);
        jualan.setPrice("10000");
        mItems.add(jualan);

        jualan = new EndangeredItem();
        jualan.setName("Ayam Saus Padang");
        jualan.setThumbnail(R.drawable.cat1);
        jualan.setPrice("15000");
        mItems.add(jualan);

        jualan = new EndangeredItem();
        jualan.setName("Nasi Merah Tuna");
        jualan.setThumbnail(R.drawable.cat2);
        jualan.setPrice("10000");
        mItems.add(jualan);

        jualan = new EndangeredItem();
        jualan.setName("Nasi Pecel Ayam");
        jualan.setThumbnail(R.drawable.cat3);
        jualan.setPrice("8000");
        mItems.add(jualan);

        jualan = new EndangeredItem();
        jualan.setName("Lodeh Tahu Pedas");
        jualan.setThumbnail(R.drawable.cat4);
        jualan.setPrice("10000");
        mItems.add(jualan);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view_home, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.namaMakanan.setText(nature.getName());
        viewHolder.bayar.setText(nature.getPrice());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ImageView imgThumbnail;
        public TextView namaMakanan;
        public TextView bayar;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            namaMakanan = (TextView)itemView.findViewById(R.id.foodName);
            bayar = (TextView)itemView.findViewById(R.id.foodPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            EndangeredItem contentTemp = mItems.get(position);
            Intent intent = new Intent(context, detailFoodItem.class);
            context.startActivity(intent);
        }
    }
}

