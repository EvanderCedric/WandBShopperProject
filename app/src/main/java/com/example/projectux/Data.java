package com.example.projectux;

public class Data {
    float rating;
    String name, price, sold;
    int imgSource;

    public Data(String name, String price, float rating, String sold, int imgSource){
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.sold = sold;
        this.imgSource = imgSource;
    }
    public String getName(){
        return this.name;
    }
    public String getPrice(){
        return this.price;
    }
    public String getSold(){
        return this.sold;
    }
    public float getRating(){
        return this.rating;
    }
    public int getImgSource(){
        return this.imgSource;
    }


}
