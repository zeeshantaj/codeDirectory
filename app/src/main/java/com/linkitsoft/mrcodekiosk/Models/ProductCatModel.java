package com.linkitsoft.mrcodekiosk.Models;

import java.util.List;

public class ProductCatModel {
    private String catName;
    private List<CategoryModel> models;

    public ProductCatModel(String catName, List<CategoryModel> models) {
        this.catName = catName;
        this.models = models;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<CategoryModel> getModels() {
        return models;
    }

    public void setModels(List<CategoryModel> models) {
        this.models = models;
    }
}
