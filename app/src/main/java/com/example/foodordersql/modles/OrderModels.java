package com.example.foodordersql.modles;

public class OrderModels {
    int orderimage;
    String priceorder,ordernum,solditemname;

    public OrderModels()
    {

    }

    public OrderModels(int orderimage, String priceorder, String ordernum, String solditemname) {
        this.orderimage = orderimage;
        this.priceorder = priceorder;
        this.ordernum = ordernum;
        this.solditemname = solditemname;
    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getPriceorder() {
        return priceorder;
    }

    public void setPriceorder(String priceorder) {
        this.priceorder = priceorder;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getSolditemname() {
        return solditemname;
    }

    public void setSolditemname(String solditemname) {
        this.solditemname = solditemname;
    }
}
