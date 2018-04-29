package com.example.miafandi.foody.Model;

/**
 * Created by user on 10/02/2018.
 */

public class User {
    private String no_ktp;
    private String nama;
    private int usia;
    private boolean isMale;
    private String email;
    private int no_tlp;
    private String alamat;

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = 20;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(int no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public User(String no_ktp, String nama, String email, int no_tlp, String alamat) {

        this.no_ktp = no_ktp;
        this.nama = nama;
        this.email = email;
        this.no_tlp = no_tlp;
        this.alamat = alamat;
    }

    public User() {

    }
}
