package com.linkitsoft.mrcodekiosk.Interfaces;

import com.linkitsoft.mrcodekiosk.Models.CategoryModel;

import java.util.List;

public interface OnItemClicked {
    void onItemClicked(int pos, List<CategoryModel> modelList);
}
