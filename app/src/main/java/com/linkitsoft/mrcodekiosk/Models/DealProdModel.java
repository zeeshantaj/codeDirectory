package com.linkitsoft.mrcodekiosk.Models;

import java.util.ArrayList;
import java.util.List;

public class DealProdModel {
    private int imgId,quantity;
    private String dealTitle;
    private double price;
    private List<ProductModel> modelList;
//    private List<AttributeCatModel> attributeModelList;


    public DealProdModel(int imgId, int quantity, String dealTitle, double price, List<ProductModel> modelList) {
        this.imgId = imgId;
        this.quantity = quantity;
        this.dealTitle = dealTitle;
        this.price = price;
        this.modelList = modelList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    public void setDealTitle(String dealTitle) {
        this.dealTitle = dealTitle;
    }

    public List<ProductModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<ProductModel> modelList) {
        this.modelList = modelList;
    }
}
