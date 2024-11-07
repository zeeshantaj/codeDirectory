package com.linkitsoft.mrcodekiosk.Fragments;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Activities.MainActivity;
import com.linkitsoft.mrcodekiosk.Adapter.DealsAdapter;
import com.linkitsoft.mrcodekiosk.Adapter.SavedOrderAdapter;
import com.linkitsoft.mrcodekiosk.Models.DealProdModel;
import com.linkitsoft.mrcodekiosk.Models.ProductModel;
import com.linkitsoft.mrcodekiosk.Models.SavedOrderModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.ArrayList;
import java.util.List;

public class SaveOrderFragment extends Fragment {
    public SaveOrderFragment() {
    }

    private List<SavedOrderModel> savedOrderModels = new ArrayList<>();
    private List<DealProdModel> dealProdModelList = new ArrayList<>();
    private List<ProductModel> productModelList = new ArrayList<>();
    private RecyclerView orderRecycler;
    private ImageView leftArrowBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_orders, container, false);
        orderRecycler = view.findViewById(R.id.orderRecycler);
        leftArrowBtn = view.findViewById(R.id.leftArrowBtn);
        setSavedRecycler();

        clickListener();
        return view;
    }
    private void clickListener(){

        leftArrowBtn.setOnClickListener(view -> {
            navController.popBackStack();
        });
    }
    private void setSavedRecycler(){
        productModelList.add(new ProductModel(2,1,"Chicken Burger"));
        productModelList.add(new ProductModel(1,1,"Fries"));
        productModelList.add(new ProductModel(1,1,"Sauce et boison"));
        productModelList.add(new ProductModel(1,1,"33clAU Choix"));

        dealProdModelList.add(new DealProdModel(R.drawable.menuitemb,1,"Masssala fish meal",10.4,productModelList));
        dealProdModelList.add(new DealProdModel(R.drawable.menuitemb,2,"Masssala fish meal",20.4,productModelList));
        dealProdModelList.add(new DealProdModel(R.drawable.menuitemb,4,"Masssala fish meal",40.4,productModelList));

        savedOrderModels.add(new SavedOrderModel("26 March 2020, 12:42 AM",dealProdModelList));
        savedOrderModels.add(new SavedOrderModel("26 March 2020, 12:42 AM",dealProdModelList));
        savedOrderModels.add(new SavedOrderModel("26 March 2020, 12:42 AM",dealProdModelList));


        orderRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        SavedOrderAdapter adapter = new SavedOrderAdapter(getContext(),savedOrderModels);
        orderRecycler.setAdapter(adapter);
    }
}
