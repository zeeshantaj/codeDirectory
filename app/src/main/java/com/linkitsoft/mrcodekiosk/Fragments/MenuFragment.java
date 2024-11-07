package com.linkitsoft.mrcodekiosk.Fragments;


import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Activities.BaseActivity;
import com.linkitsoft.mrcodekiosk.Adapter.CategoryAdapter;
import com.linkitsoft.mrcodekiosk.Adapter.ProductCatAdapter;
import com.linkitsoft.mrcodekiosk.Interfaces.OnCategoryItemClicked;
import com.linkitsoft.mrcodekiosk.Interfaces.OnItemClicked;
import com.linkitsoft.mrcodekiosk.Interfaces.OnPositionListener;
import com.linkitsoft.mrcodekiosk.Models.CategoryModel;
import com.linkitsoft.mrcodekiosk.Models.ProductCatModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends BaseFragment implements OnCategoryItemClicked {
    public MenuFragment() {
    }
    private CategoryAdapter categoryAdapter;
    private ProductCatAdapter productCatAdapter;
    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private List<CategoryModel> productModelList = new ArrayList<>();
    private List<ProductCatModel> productCatModelsList = new ArrayList<>();
    private List<ProductCatModel> endlessList = new ArrayList<>();
    private RecyclerView categoryRecyclerView, productCatRecycler;
    private Button viewHistoryBtn;
    private ImageView leftArrowBtn,rightArrowBtn;
    private LinearLayoutManager categoryLayoutManager;

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    int selectedPos,lastVisibleItem;
    private int previousSelectedPosition = -1;
    private static final int ITEM_COUNT = 20; // Initial number of items
    private ImageView cartBtn;

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
        cartBtn = view.findViewById(R.id.cartIcon);


        setCategory();
//        setCatProduct();
        clickedListener();


        return view;
    }

    private void setCategory() {
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
        categoryAdapter = new CategoryAdapter(getContext(), categoryModelList, categoryRecyclerView,categoryLayoutManager, this::OnCatClicked);
        categoryLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(categoryLayoutManager);
        categoryRecyclerView.setAdapter(categoryAdapter);


        categoryAdapter.setOnItemClick(new OnItemClicked() {
            @Override
            public void onItemClicked(int pos, List<CategoryModel> modelList) {

                Log.d("MyApp","clicked pos "+pos);
                if (pos != previousSelectedPosition) {
                    // Set the new center position as selected
                    categoryModelList.get(pos).setIS_Selected(true);

                    // Update only the previously selected and current selected items
                    if (previousSelectedPosition != -1) {
                        categoryModelList.get(previousSelectedPosition).setIS_Selected(false);
                        categoryAdapter.notifyItemChanged(previousSelectedPosition);
                    }
                    categoryAdapter.notifyItemChanged(pos);

                    // Update the previous selected position
                    previousSelectedPosition = pos;
                }

            }
        });
        categoryRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int firstVisibleItem = categoryLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItem = categoryLayoutManager.findLastVisibleItemPosition();
                int centerPosition = (firstVisibleItem + lastVisibleItem) / 2;

                // Avoid unnecessary refreshes
                if (centerPosition != previousSelectedPosition) {
                    // Set the new center position as selected
                    categoryModelList.get(centerPosition).setIS_Selected(true);

                    // Update only the previously selected and current selected items
                    if (previousSelectedPosition != -1) {
                        categoryModelList.get(previousSelectedPosition).setIS_Selected(false);
                        categoryAdapter.notifyItemChanged(previousSelectedPosition);
                    }
                    categoryAdapter.notifyItemChanged(centerPosition);

                    // Update the previous selected position
                    previousSelectedPosition = centerPosition;
                }

                if (!recyclerView.canScrollHorizontally(1)) {
                    // Append new items to create the circular effect
                    categoryAdapter.appendItems(getInitialItems());
                }
                if (!recyclerView.canScrollHorizontally(-1)) {
                    // Prepend new items to create circular effect to the left
                    categoryAdapter.prependItems(getInitialItems());
                }
            }
        });
    }

    private List<CategoryModel> getInitialItems() {
        List<CategoryModel> initialItems = new ArrayList<>();
        for (int i = 1; i <= ITEM_COUNT; i++) {
            initialItems.add(categoryModelList.get(i));
        }
        return initialItems;
    }

    private void clickedListener(){
        cartBtn.setOnClickListener(view -> {
            navController.navigate(R.id.checkoutFragment);
        });
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
        productModelList.add(new CategoryModel(R.drawable.food_img1,"Massala fish meal",12.33));
        productModelList.add(new CategoryModel(R.drawable.food_img2,"Mix Meal",20.33));
        productModelList.add(new CategoryModel(R.drawable.food_img3,"Assiette fish dinner",21.33));
        productModelList.add(new CategoryModel(R.drawable.food_img,"Assiette mixte",23.00));
        productModelList.add(new CategoryModel(R.drawable.food_img1,"Mega variety meal",13.23));
        productModelList.add(new CategoryModel(R.drawable.menuitema,"burger deal",9.25));
        productModelList.add(new CategoryModel(R.drawable.food_img2,"Chicken dipper meal",21.53));
        productModelList.add(new CategoryModel(R.drawable.food_img3,"Beef burger meal",15.23));
        productModelList.add(new CategoryModel(R.drawable.menuitema,"Assiette fish dinner",9.25));

        productCatModelsList.add(new ProductCatModel("Just Chicken",productModelList));

        productCatRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        productCatAdapter = new ProductCatAdapter(getContext(),productCatModelsList);
        productCatRecycler.setAdapter(productCatAdapter);
    }
}
