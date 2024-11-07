package com.linkitsoft.mrcodekiosk.Models;

import java.util.List;

public class SavedOrderModel {
    private String dateTime;
    private List<DealProdModel> modelList;

    public SavedOrderModel(String dateTime, List<DealProdModel> modelList) {
        this.dateTime = dateTime;
        this.modelList = modelList;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<DealProdModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<DealProdModel> modelList) {
        this.modelList = modelList;
    }

    public class ViewHolder {
    }
}
