package com.example.foodordersql.modles;

public class MainModle {
    int image;
    String name,price,dsic;

    public MainModle(int image, String name, String price, String dsic) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.dsic = dsic;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDsic() {
        return dsic;
    }

    public void setDsic(String dsic) {
        this.dsic = dsic;
    }
}
