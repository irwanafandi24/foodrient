package com.example.miafandi.foody.Resep;

/**
 * Created by MIAfandi on 01/02/2018.
 */

public class Item {
    private String namaResep;
    private String kotaResep;
    private String detailResep;
    private int imageResep;

    public Item(String namaResep, String kotaResep, String detailResep, int imageResep) {
        this.namaResep = namaResep;
        this.kotaResep = kotaResep;
        this.detailResep = detailResep;
        this.imageResep = imageResep;
    }

    public String getNamaResep() {
        return namaResep;
    }

    public void setNamaResep(String namaResep) {
        this.namaResep = namaResep;
    }

    public String getKotaResep() {
        return kotaResep;
    }

    public void setKotaResep(String kotaResep) {
        this.kotaResep = kotaResep;
    }

    public String getDetailResep() {
        return detailResep;
    }

    public void setDetailResep(String detailResep) {
        this.detailResep = detailResep;
    }

    public int getImageResep() {
        return imageResep;
    }

    public void setImageResep(int imageResep) {
        this.imageResep = imageResep;
    }
}
