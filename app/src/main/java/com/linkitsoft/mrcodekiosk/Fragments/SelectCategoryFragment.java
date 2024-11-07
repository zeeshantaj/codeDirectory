package com.linkitsoft.mrcodekiosk.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Adapter.CategoryAdapter;
import com.linkitsoft.mrcodekiosk.Interfaces.OnCategoryItemClicked;
import com.linkitsoft.mrcodekiosk.Models.CategoryModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.ArrayList;
import java.util.List;

public class SelectCategoryFragment extends Fragment {

    public SelectCategoryFragment() {
    }
    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private LinearLayoutManager categoryLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_catergory, container, false);
        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        categoryModelList.clear();
        categoryModelList.add(new CategoryModel(R.drawable.menuitemb, "Just Chicken1",false,1));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemc, "Family Platter2",false,2));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemd, "Meal Combo3",false,3));
        categoryModelList.add(new CategoryModel(R.drawable.menuiteme, "Burger Deal4",false,4));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemf, "Fish5",false,5));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemb, "Burger Deal6",false,6));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemc, "Family Platter7",false,7));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemd, "Meal Combo8",false,8));
        categoryModelList.add(new CategoryModel(R.drawable.menuiteme, "Burger Deal9",false,9));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemf, "Fish10",false,10));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemd, "Just Chicken11",false,11));
        categoryAdapter = new CategoryAdapter(getContext(), categoryModelList, categoryRecyclerView, categoryLayoutManager, new OnCategoryItemClicked() {
            @Override
            public void OnCatClicked(int id) {

            }
        },false);

//        categoryLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),6));
        categoryRecyclerView.setAdapter(categoryAdapter);


        return view;
    }

}
