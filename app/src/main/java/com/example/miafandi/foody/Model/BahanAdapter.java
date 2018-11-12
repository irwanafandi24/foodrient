package com.example.miafandi.foody.Model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.miafandi.foody.ForgetPasswordActivity;
import com.example.miafandi.foody.Home.detailFoodItem;
import com.example.miafandi.foody.LoginActivity;
import com.example.miafandi.foody.R;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by user on 04/05/2018.
 */

public class BahanAdapter extends RecyclerView.Adapter<BahanAdapter.MyViewHolder>{
    private Context context;
    private List<Bahan> list;
    private ViewGroup parent;

    public BahanAdapter(Context context, List<Bahan> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = parent;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bahan,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Bahan bahan = list.get(position);
        try {
            holder.txtPenyakit.setText(bahan.getPenyakit(0)+"+"+bahan.getPenyakit(1));
        }catch (ArrayIndexOutOfBoundsException a){

        }
        holder.txtNama.setText(bahan.getNama());
        holder.image.setImageResource(bahan.getGambar());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtNama, txtPenyakit;
        private CircleImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNama = (TextView) itemView.findViewById(R.id.txtNamaBahan);
            txtPenyakit = (TextView) itemView.findViewById(R.id.txtPenyakitBahan);
            image = (CircleImageView) itemView.findViewById(R.id.imageBahan);
        }

        @Override
        public void onClick(View v) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
            View mView = LayoutInflater.from(context).inflate(R.layout.activity_dialog_infobahan, null);

//            Button btnMasuk = (Button) mView.findViewById(R.id.btnMasuk);
//            TextView lupaSandi = (TextView) mView.findViewById(R.id.lupaKataSandi);
//            TextView cancleBtn = (TextView) mView.findViewById(R.id.cancle);

            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();

        }
    }
}