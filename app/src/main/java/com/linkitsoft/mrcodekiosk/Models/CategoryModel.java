package com.linkitsoft.mrcodekiosk.Models;

public class CategoryModel {
    private int imageId;
    private String catName;
    private double price;

    public CategoryModel(int imageId, String catName, double price) {
        this.imageId = imageId;
        this.catName = catName;
        this.price = price;
    }

    public CategoryModel(int imageId, String catName) {
        this.imageId = imageId;
        this.catName = catName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
