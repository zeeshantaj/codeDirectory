package com.linkitsoft.mrcodekiosk.Fragments;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Adapter.AttributesCatAdapter;
import com.linkitsoft.mrcodekiosk.Adapter.DealsAdapter;
import com.linkitsoft.mrcodekiosk.Models.AttributeCatModel;
import com.linkitsoft.mrcodekiosk.Models.AttributesModel;
import com.linkitsoft.mrcodekiosk.Models.DealProdModel;
import com.linkitsoft.mrcodekiosk.Models.ProductModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.ArrayList;
import java.util.List;

public class ModifierFragment extends BaseFragment {
    public ModifierFragment() {
    }

    private RecyclerView dealRecycler,attributeCatAdapter;
    private List<AttributeCatModel> attibuteCatModelsList = new ArrayList<>();
    private List<DealProdModel> dealProdModelList = new ArrayList<>();
    private List<ProductModel> productModelList = new ArrayList<>();
    private List<AttributesModel> beverageList = new ArrayList<>();
    private List<AttributesModel> sauceList = new ArrayList<>();
    private List<AttributesModel> toppinList = new ArrayList<>();
    private List<AttributesModel> sideList = new ArrayList<>();
    private Button addToCartBtn,checkOutBtn;
    private ImageView leftArrowBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modifiers, container, false);

        dealRecycler = view.findViewById(R.id.dealRecycler);
        attributeCatAdapter = view.findViewById(R.id.attributeCatAdapter);
        addToCartBtn = view.findViewById(R.id.addToCartBtn);
        checkOutBtn = view.findViewById(R.id.checkOutBtn);
        leftArrowBtn = view.findViewById(R.id.leftArrowBtn);


        setDealRecycler();
        setAttributeCatAdapter();
        clickListener();
        return view;
    }
    private void clickListener(){
        addToCartBtn.setOnClickListener(view -> {
            navController.popBackStack();
//            navController.navigate(R.id.checkoutFragment);
        });
        checkOutBtn.setOnClickListener(view -> {
            navController.navigate(R.id.checkoutFragment);
//            navController.popBackStack();
        });
        leftArrowBtn.setOnClickListener(view -> {
            navController.popBackStack();
        });
    }
    private void setDealRecycler(){
        productModelList.clear();
        dealProdModelList.clear();

        productModelList.add(new ProductModel(2,1,"Chicken Burger"));
        productModelList.add(new ProductModel(1,1,"Fries"));
        productModelList.add(new ProductModel(1,1,"Sauce et boison"));
        productModelList.add(new ProductModel(1,1,"33clAU Choix"));

        productModelList.add(new ProductModel(1,2,"Red Sauce"));
        productModelList.add(new ProductModel(1,2,"Fries"));

        dealProdModelList.add(new DealProdModel(R.drawable.menuitemb,1,"Masssala fish meal",10.4,productModelList));

        dealRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DealsAdapter adapter = new DealsAdapter(getContext(),dealProdModelList);
        dealRecycler.setAdapter(adapter);


    }
    private void setAttributeCatAdapter(){
        beverageList.clear();
        sauceList.clear();
        toppinList.clear();
        sideList.clear();
        attibuteCatModelsList.clear();
        beverageList.add(new AttributesModel(R.drawable.pepsi_icon,3.00,1,"Pepsi"));
        beverageList.add(new AttributesModel(R.drawable.fanta_icon,5.00,1,"Fanta"));
        beverageList.add(new AttributesModel(R.drawable.up7_icon,3.00,1,"7up"));

        sauceList.add(new AttributesModel(R.drawable.sauce_img,0.20,2,"Red Sauce"));
        sauceList.add(new AttributesModel(R.drawable.sauce_img,0.60,2,"Mayo"));

        toppinList.add(new AttributesModel(R.drawable.cheese,3.00,2,"Fita"));
        toppinList.add(new AttributesModel(R.drawable.cheese,3.00,2,"cheddar"));
        toppinList.add(new AttributesModel(R.drawable.cheese,3.00,2,"Mozzarella"));

        sideList.add(new AttributesModel(R.drawable.pepsi_icon,3.00,2,"Fries"));
        sideList.add(new AttributesModel(R.drawable.pepsi_icon,3.00,2,"masala fries"));

     attibuteCatModelsList.add(new AttributeCatModel("Beverages", beverageList));
     attibuteCatModelsList.add(new AttributeCatModel("Sauce",sauceList));
     attibuteCatModelsList.add(new AttributeCatModel("Topping",toppinList));
     attibuteCatModelsList.add(new AttributeCatModel("Sides",sideList));

        AttributesCatAdapter adapter = new AttributesCatAdapter(getContext(),attibuteCatModelsList);
        attributeCatAdapter.setLayoutManager(new LinearLayoutManager(getContext()));
        attributeCatAdapter.setAdapter(adapter);

    }
}
