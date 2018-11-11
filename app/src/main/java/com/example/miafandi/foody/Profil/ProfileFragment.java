package com.example.miafandi.foody.Profil;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miafandi.foody.LoginActivity;
import com.example.miafandi.foody.MainActivity;
import com.example.miafandi.foody.MulaiJualMasakActivity;
import com.example.miafandi.foody.PanduanActivity;
import com.example.miafandi.foody.R;
import com.example.miafandi.foody.RegisterActivity;
import com.example.miafandi.foody.RekeningActivity;
import com.example.miafandi.foody.TransaksiActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    private Button btn_detil, btn_upgrade, btn_jualMasakan, btn_jualCatering, btn_activation, btnBayar;
    private TextView txt_uang, txt_pesan, txt_notifikasi, txt_pelanggan, txt_feedback, txt_promosi, txtakun, txt_menuLain, txt_edit, txtTotalVoucher, txt_username_profile;
    boolean aktif = false;
    private FirebaseAuth firebaseAuth;

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
        txtTotalVoucher = (TextView) rootView.findViewById(R.id.txtVoucher);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        btnBayar = (Button) rootView.findViewById(R.id.btnBayar);

        if(!aktif) {
            txtTotalVoucher.setVisibility(View.GONE);

        }else{
            txtTotalVoucher.setVisibility(View.VISIBLE);
            btnBayar.setVisibility(View.VISIBLE);
        }

        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(),RekeningActivity.class));
            }
        });

        btn_detil = (Button) rootView.findViewById(R.id.btnDetil);
        btn_activation = (Button) rootView.findViewById(R.id.btnReguler);
        btn_upgrade = (Button) rootView.findViewById(R.id.btnUpgrade);
        btn_jualMasakan = (Button) rootView.findViewById(R.id.btnJualMasakan);

        txt_uang = (TextView) rootView.findViewById(R.id.txtUang);
        txt_pesan = (TextView) rootView.findViewById(R.id.txtPesan);
        txt_notifikasi = (TextView) rootView.findViewById(R.id.txtNotifikasi);
        txt_pelanggan = (TextView) rootView.findViewById(R.id.txtPelanggan);
        txt_feedback = (TextView) rootView.findViewById(R.id.txtFeedback);
        txt_promosi = (TextView) rootView.findViewById(R.id.txtPromosi);
        txtakun = (TextView) rootView.findViewById(R.id.txtAkun);
        txt_menuLain = (TextView) rootView.findViewById(R.id.txtMenuLain);
        txt_edit = (TextView) rootView.findViewById(R.id.txtEditProfile);
        txt_username_profile = (TextView) rootView.findViewById(R.id.txtUsername);

        txt_username_profile.setText(user.getEmail());
        txt_menuLain.setVisibility(View.VISIBLE);
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
        btn_upgrade.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();

        if(v==btn_detil){
            i.setClass(this.getContext(),TransaksiActivity.class);
            startActivity(i);
        }else if(v==btn_jualMasakan){
            i.setClass(this.getContext(), MulaiJualMasakActivity.class);
            startActivity(i);
        }else if(v==btn_upgrade){
            popUpActivation();
        }else if(v==txt_edit){
            i.setClass(this.getContext(),EditProfileActivity.class);
            startActivity(i);
        }else if(txt_menuLain==v){
            i.setClass(this.getContext(),MenuLainActivity.class);
            startActivity(i);
        }else if(txtakun==v){
            i.setClass(this.getContext(),MenuLainActivity.class);
            startActivity(i);
        }
    }

    public void popUpActivation(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this.getContext());
        View mView = getLayoutInflater().inflate(R.layout.activity_dialog_activation, null);

        final Button btnAktif = (Button) mView.findViewById(R.id.btnAktif);
        final Button btnCancelAktif = (Button) mView.findViewById(R.id.btnCancelAktif);
        final Button btnKode = (Button) mView.findViewById(R.id.btnValidasiKode);
            TextView txtPanduan = (TextView) mView.findViewById(R.id.txt_paduan);

        final EditText etKode = (EditText) mView.findViewById(R.id.etKode);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnAktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Selamat Permintaan anda telah terproses, silahkan menunggu informasi selanjutnya melalui Email/No.telp",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        btnCancelAktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        txtPanduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),PanduanActivity.class));
            }
        });
        btnKode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!"".equals(etKode.getText().toString())){
                    btn_activation.setVisibility(View.GONE);
                    btnBayar.setVisibility(View.VISIBLE);
                    btn_upgrade.setVisibility(View.GONE);
                    txtTotalVoucher.setVisibility(View.VISIBLE);
                    btn_jualMasakan.setVisibility(View.VISIBLE);

                    aktif = true;
                    Toast.makeText(getActivity().getApplicationContext(),"Selamat Lapak Anda Telah Aktif, Selamat Berjualan",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Kode Aktivasi Salah, silakan lakukan pendaftaran terlebih dahulu",Toast.LENGTH_LONG).show();
                }
                dialog.dismiss();
            }
        });

    }
}
