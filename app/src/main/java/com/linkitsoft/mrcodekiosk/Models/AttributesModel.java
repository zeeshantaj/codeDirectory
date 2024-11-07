package com.linkitsoft.mrcodekiosk.Models;

public class AttributesModel {
    private int imageId,type;
    private double price;
    private String name;

    public AttributesModel(int imageId, double price, int type, String name) {
        this.imageId = imageId;
        this.price = price;
        this.type = type;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
