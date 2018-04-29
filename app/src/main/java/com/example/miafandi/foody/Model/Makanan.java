package com.example.miafandi.foody.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by user on 14/04/2018.
 */

public class Makanan {
    private String nama;
    private String penyakit;
    private String harga;
    private int bintang;
    private int drawable;

    public Makanan(String nama,String penyakit, int harga, int bintang, int drawable) {
        this.nama = nama;
        this.penyakit = penyakit;
        this.harga =""+ harga;
        //this.harga = "Rp."+harga+" / porsi";
        this.bintang = bintang;
        this.drawable = drawable;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit){
        this.penyakit = penyakit;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getBintang() {
        return bintang;
    }

    public void setBintang(int bintang) {
        this.bintang = bintang;
    }

    public int getDrawable() {
        return drawable;
    }
}
