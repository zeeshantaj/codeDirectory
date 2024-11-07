package com.linkitsoft.mrcodekiosk.Fragments;


import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Adapter.CategoryAdapter;
import com.linkitsoft.mrcodekiosk.Adapter.ProductCatAdapter;
import com.linkitsoft.mrcodekiosk.Interfaces.OnCategoryItemClicked;
import com.linkitsoft.mrcodekiosk.Interfaces.OnPositionListener;
import com.linkitsoft.mrcodekiosk.Models.CategoryModel;
import com.linkitsoft.mrcodekiosk.Models.ProductCatModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment implements OnCategoryItemClicked {
    public MenuFragment() {
    }
    private CategoryAdapter categoryAdapter;
    private ProductCatAdapter productCatAdapter;
    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private List<CategoryModel> productModelList = new ArrayList<>();
    private List<ProductCatModel> productCatModelsList = new ArrayList<>();
    private RecyclerView categoryRecyclerView, productCatRecycler;
    private Button viewHistoryBtn;
    private ImageView leftArrowBtn,rightArrowBtn;
    private LinearLayoutManager categoryLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_browsing, container, false);

        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        productCatRecycler = view.findViewById(R.id.productRecyclerView);
        viewHistoryBtn = view.findViewById(R.id.viewOrderHistoryBtn);
        leftArrowBtn = view.findViewById(R.id.leftArrowBtn);
        rightArrowBtn = view.findViewById(R.id.rightArrowBtn);


        setCategory();
//        setCatProduct();
        clickedListener();

        return view;
    }

    private void setCategory(){
        categoryModelList.clear();
        categoryModelList.add(new CategoryModel(R.drawable.menuitemb,"Just Chicken"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemc,"Family Platter"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemd,"Meal Combo"));
        categoryModelList.add(new CategoryModel(R.drawable.menuiteme,"Burger Deal"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemf,"Fish"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemb,"Burger Deal"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemc,"Family Platter"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemd,"Meal Combo"));
        categoryModelList.add(new CategoryModel(R.drawable.menuiteme,"Burger Deal"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemf,"Fish"));
        categoryModelList.add(new CategoryModel(R.drawable.menuitemd,"Just Chicken"));

        categoryAdapter = new CategoryAdapter(getContext(),categoryModelList,categoryRecyclerView);
        categoryLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(categoryLayoutManager);
        categoryRecyclerView.setAdapter(categoryAdapter);

    }
    private void clickedListener(){
        viewHistoryBtn.setOnClickListener(view -> {
            navController.navigate(R.id.savedOrderFragment);
        });
        rightArrowBtn.setOnClickListener(view -> {
          categoryAdapter.incrementPosition();
        });
        leftArrowBtn.setOnClickListener(view -> {
            categoryAdapter.decrementPosition();
        });
    }

    private void setCatProduct(){
        productModelList.clear();
        productCatModelsList.clear();

        productModelList.add(new CategoryModel(R.drawable.food_img,"Mega variety meal",9.33));
//        productModelList.add(new CategoryModel(R.drawable.food_img1,"Massala fish meal",12.33));
//        productModelList.add(new CategoryModel(R.drawable.food_img2,"Mix Meal",20.33));
//        productModelList.add(new CategoryModel(R.drawable.food_img3,"Assiette fish dinner",21.33));
//        productModelList.add(new CategoryModel(R.drawable.food_img,"Assiette mixte",23.00));
//        productModelList.add(new CategoryModel(R.drawable.food_img1,"Mega variety meal",13.23));
//        productModelList.add(new CategoryModel(R.drawable.menuitema,"burger deal",9.25));
//        productModelList.add(new CategoryModel(R.drawable.food_img2,"Chicken dipper meal",21.53));
//        productModelList.add(new CategoryModel(R.drawable.food_img3,"Beef burger meal",15.23));
//        productModelList.add(new CategoryModel(R.drawable.menuitema,"Assiette fish dinner",9.25));

        productCatModelsList.add(new ProductCatModel("Just Chicken",productModelList));
//        productCatModelsList.add(new ProductCatModel("Family Platter",productModelList));
//        productCatModelsList.add(new ProductCatModel("Meal Combo",productModelList));
//        productCatModelsList.add(new ProductCatModel("Fish",productModelList));
//        productCatModelsList.add(new ProductCatModel("Burger Deal",productModelList));

        productCatRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        productCatAdapter = new ProductCatAdapter(getContext(),productCatModelsList);
        productCatRecycler.setAdapter(productCatAdapter);

    }

    @Override
    public void OnCatClicked(int id) {
        productModelList.clear();
        productCatModelsList.clear();

        productModelList.add(new CategoryModel(R.drawable.food_img,"Mega variety meal",9.33));

        productCatModelsList.add(new ProductCatModel("Just Chicken",productModelList));

        productCatRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        productCatAdapter = new ProductCatAdapter(getContext(),productCatModelsList);
        productCatRecycler.setAdapter(productCatAdapter);
    }
}
