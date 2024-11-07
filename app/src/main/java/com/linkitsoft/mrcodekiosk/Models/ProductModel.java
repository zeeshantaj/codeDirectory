package com.linkitsoft.mrcodekiosk.Models;

public class ProductModel {
    private int quantity,type;
    private String productName;

    public ProductModel(int quantity, int type, String productName) {
        this.quantity = quantity;
        this.type = type;
        this.productName = productName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
