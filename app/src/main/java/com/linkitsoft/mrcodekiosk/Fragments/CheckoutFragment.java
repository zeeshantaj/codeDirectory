package com.linkitsoft.mrcodekiosk.Fragments;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Adapter.DealsAdapter;
import com.linkitsoft.mrcodekiosk.Models.DealProdModel;
import com.linkitsoft.mrcodekiosk.Models.ProductModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.ArrayList;
import java.util.List;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class CheckoutFragment extends Fragment {

    public CheckoutFragment() {
    }
    private List<ProductModel> productModelList = new ArrayList<>();
    private List<DealProdModel> dealProdModelList = new ArrayList<>();
    private RecyclerView productRecyclerView;
    private ImageView leftArrowBtn;
    private Button paymentBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.checkout_layout, container, false);

        productRecyclerView = view.findViewById(R.id.recyclerView);
        leftArrowBtn = view.findViewById(R.id.leftArrowBtn);
        paymentBtn = view.findViewById(R.id.paymentBtn);
        setDealRecycler();
        clickListener();
        return view;
    }
    private void clickListener(){
        leftArrowBtn.setOnClickListener(view -> {
            navController.popBackStack();
        });
        paymentBtn.setOnClickListener(view -> {
            showDialog();
//
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
        dealProdModelList.add(new DealProdModel(R.drawable.menuitemb,1,"Masssala fish meal",10.4,productModelList));

        productRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DealsAdapter adapter = new DealsAdapter(getContext(),dealProdModelList);
        productRecyclerView.setAdapter(adapter);


    }
    private void showDialog() {
        final Dialog nameDialog = new Dialog(getContext());
        nameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        nameDialog.setContentView(R.layout.name_dialog);
        nameDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        Button enterBtn = nameDialog.findViewById(R.id.button7);
        EditText nameEdt = nameDialog.findViewById(R.id.nameEdt);
        ImageView cancelImg = nameDialog.findViewById(R.id.cancelImg);

        cancelImg.setOnClickListener(view -> {
            nameDialog.dismiss();
        });
        enterBtn.setOnClickListener(view -> {
            nameDialog.dismiss();
            navController.navigate(R.id.paymentProcessFragment);
        });


        nameDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        nameDialog.setCancelable(true);
        nameDialog.show();
    }
}
