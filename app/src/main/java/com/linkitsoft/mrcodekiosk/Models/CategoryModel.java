package com.linkitsoft.mrcodekiosk.Models;

public class CategoryModel {
    private int itemId;
    private int imageId;
    private String catName;
    private double price;
    private boolean IS_Selected;

    public CategoryModel(int imageId, String catName, double price, boolean IS_Selected) {
        this.imageId = imageId;
        this.catName = catName;
        this.price = price;
        this.IS_Selected = IS_Selected;
    }

    public CategoryModel(int imageId, String catName, boolean IS_Selected,int itemId) {
        this.imageId = imageId;
        this.catName = catName;
        this.IS_Selected = IS_Selected;
        this.itemId = itemId;
    }
    public CategoryModel(int imageId, String catName, double price) {
        this.imageId = imageId;
        this.catName = catName;
        this.price = price;
    }

    public CategoryModel(int imageId, String catName) {
        this.imageId = imageId;
        this.catName = catName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIS_Selected() {
        return IS_Selected;
    }

    public void setIS_Selected(boolean IS_Selected) {
        this.IS_Selected = IS_Selected;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
