package com.example.miafandi.foody.Model;

/**
 * Created by user on 04/05/2018.
 */

public class Bahan {
    private String nama;
    private String[] penyakit = new String[10];
    private int gambar;
    private String deskripsi;

    public Bahan(String nama, String[] penyakit, int gambar, String deskripsi) {
        this.nama = nama;
        this.penyakit = penyakit;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyakit(int i) {
        return penyakit[i];
    }

    public void setPenyakit(String[] penyakit) {
        this.penyakit = penyakit;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
