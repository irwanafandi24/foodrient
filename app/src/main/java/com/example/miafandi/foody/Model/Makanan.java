package com.example.miafandi.foody.Model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14/04/2018.
 */

public class Makanan {
    private String nama;
    private List<String> penyakit;
    private String harga;
    private int bintang;
    private int drawable;

    public Makanan(String nama, int harga, int bintang, int drawable) {
        this.nama = nama;
        this.penyakit = new ArrayList<>();
        this.harga =""+ harga;
        this.bintang = bintang;
        this.drawable = drawable;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyakit(int i) {
        return penyakit.get(i);
    }

    public int getPenyakitSize() {
        return penyakit.size();
    }

    public void setPenyakit(String penyakit){
        this.penyakit.add(penyakit);
    }

    public Makanan setPenyakit2(String penyakit){
        this.penyakit.add(penyakit);
        return this;
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
