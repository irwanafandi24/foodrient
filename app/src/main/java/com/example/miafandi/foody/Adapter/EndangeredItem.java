package com.example.miafandi.foody.Adapter;

public class EndangeredItem {
    private String nameFood;
    private int imgThumbnail;
    private String price;

    public String getName() {
        return nameFood;
    }

    public void setName(String name) {
        this.nameFood = name;
    }

    public int getThumbnail() {
        return imgThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.imgThumbnail = thumbnail;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }


}
