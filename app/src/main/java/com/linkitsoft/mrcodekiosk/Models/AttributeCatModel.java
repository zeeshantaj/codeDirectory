package com.linkitsoft.mrcodekiosk.Models;

import java.util.List;

public class AttributeCatModel {

    private String catName;
    private List<AttributesModel> attributesModels;

    public AttributeCatModel(String catName, List<AttributesModel> attributesModels) {
        this.catName = catName;
        this.attributesModels = attributesModels;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<AttributesModel> getAttributesModels() {
        return attributesModels;
    }

    public void setAttributesModels(List<AttributesModel> attributesModels) {
        this.attributesModels = attributesModels;
    }
}
