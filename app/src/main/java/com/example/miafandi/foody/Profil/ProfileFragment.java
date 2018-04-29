package com.example.miafandi.foody.Profil;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.miafandi.foody.MainActivity;
import com.example.miafandi.foody.MulaiJualMasakActivity;
import com.example.miafandi.foody.R;
import com.example.miafandi.foody.TransaksiActivity;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    private Button btn_detil, btn_upgrade, btn_jualMasakan, btn_jualCatering, btn_reguler;
    private TextView txt_uang, txt_pesan, txt_notifikasi, txt_pelanggan, txt_feedback, txt_promosi, txtakun, txt_menuLain, txt_edit;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        btn_detil = (Button) rootView.findViewById(R.id.btnDetil);
        btn_reguler = (Button) rootView.findViewById(R.id.btnReguler);
        btn_upgrade = (Button) rootView.findViewById(R.id.btnUpgrade);
        btn_jualMasakan = (Button) rootView.findViewById(R.id.btnJualMasakan);
        btn_jualCatering = (Button) rootView.findViewById(R.id.btnJualCatering);

        txt_uang = (TextView) rootView.findViewById(R.id.txtUang);
        txt_pesan = (TextView) rootView.findViewById(R.id.txtPesan);
        txt_notifikasi = (TextView) rootView.findViewById(R.id.txtNotifikasi);
        txt_pelanggan = (TextView) rootView.findViewById(R.id.txtPelanggan);
        txt_feedback = (TextView) rootView.findViewById(R.id.txtFeedback);
        txt_promosi = (TextView) rootView.findViewById(R.id.txtPromosi);
        txtakun = (TextView) rootView.findViewById(R.id.txtAkun);
        txt_menuLain = (TextView) rootView.findViewById(R.id.txtMenuLain);
        txt_edit = (TextView) rootView.findViewById(R.id.txtEditProfile);

        txt_menuLain.setOnClickListener(this);
        txtakun.setOnClickListener(this);
        txt_promosi.setOnClickListener(this);
        txt_feedback.setOnClickListener(this);
        txt_pelanggan.setOnClickListener(this);
        txt_notifikasi.setOnClickListener(this);
        txt_pesan.setOnClickListener(this);
        txt_uang.setOnClickListener(this);
        txt_edit.setOnClickListener(this);

        btn_jualMasakan.setOnClickListener(this);
        btn_detil.setOnClickListener(this);


        if(false){
            btn_reguler.setText("PREMIUM");
            btn_jualCatering.setOnClickListener(this);
            btn_jualCatering.setBackgroundColor(btn_jualMasakan.getSolidColor());
            btn_jualCatering.setTextColor(Color.WHITE);
        }

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();

        if(v==btn_detil){
            i.setClass(this.getContext(),TransaksiActivity.class);
        }else if(v==btn_jualCatering){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==btn_jualMasakan){
            i.setClass(this.getContext(), MulaiJualMasakActivity.class);
        }else if(v==btn_upgrade){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==txt_pesan){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==txt_notifikasi){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==txt_pelanggan){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==txt_feedback){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==txt_promosi){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==txtakun){
            i.setClass(this.getContext(),MenuLainActivity.class);
        }else if(v==txt_edit){
            i.setClass(this.getContext(),EditProfileActivity.class);
        }else{
            i.setClass(this.getContext(),MenuLainActivity.class);
        }
        startActivity(i);
    }
}
