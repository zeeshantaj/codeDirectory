package com.linkitsoft.mrcodekiosk.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.linkitsoft.mrcodekiosk.Activities.ConfigActivity;
import com.linkitsoft.mrcodekiosk.Activities.MainActivity;
import com.linkitsoft.mrcodekiosk.Models.DealProdModel;
import com.linkitsoft.mrcodekiosk.Models.ProductModel;
import com.linkitsoft.mrcodekiosk.R;
import com.mukeshsolanki.OnOtpCompletionListener;
import com.mukeshsolanki.OtpView;

import java.util.ArrayList;
import java.util.List;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {
    private Context context;
    private List<DealProdModel> dealProdModelList;
    private int quantity = 1;

    public DealsAdapter(Context context, List<DealProdModel> dealProdModelList) {
        this.context = context;
        this.dealProdModelList = dealProdModelList;
    }

    @NonNull
    @Override
    public DealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.deal_recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsAdapter.ViewHolder holder, int position) {
        DealProdModel dealProdModel = dealProdModelList.get(position);

        holder.dealName.setText(dealProdModel.getQuantity()+" x "+dealProdModel.getDealTitle());
        holder.priceTxt.setText(String.valueOf("€ "+dealProdModel.getPrice()));

        Glide.with(context)
                .load(dealProdModel.getImgId())
                .into(holder.productImg);

        List<ProductModel> list = new ArrayList<>();
        List<ProductModel> list1 = new ArrayList<>();
        List<ProductModel> list2 = new ArrayList<>();
        list = dealProdModelList.get(position).getModelList();

        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getType() == 1){
               list1.add(list.get(i));
            }else if (list.get(i).getType() == 2){
                list2.add(list.get(i));
            }
        }
        if (!list1.isEmpty()){
            DealProductAdapter adapter = new DealProductAdapter(context,list1);
            holder.productRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            holder.productRecyclerView.setAdapter(adapter);
        }
        if (!list2.isEmpty()){
            DealProductAdapter adapter = new DealProductAdapter(context,list2);
            holder.attributeRecycler.setLayoutManager(new LinearLayoutManager(context));
            holder.attributeRecycler.setAdapter(adapter);
        }

        holder.plusBtn.setOnClickListener(view -> {
            quantity++;
            holder.quantityTxt.setText(String.valueOf(quantity));
        });
        holder.minusBtn.setOnClickListener(view -> {
            if (quantity <= 1){
                return;
            }
            quantity--;
            holder.quantityTxt.setText(String.valueOf(quantity));
        });

        holder.deleteIcon.setOnClickListener(view -> {
//            dealProdModelList.remove(position);
            notifyItemRemoved(position);

            showDialog();

        });

    }

    @Override
    public int getItemCount() {
        return dealProdModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImg;
        private TextView dealName,priceTxt;
        private RecyclerView productRecyclerView,attributeRecycler;
        private TextView quantityTxt;
        private ImageView plusBtn,minusBtn,deleteIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImg = itemView.findViewById(R.id.productImg);
            dealName = itemView.findViewById(R.id.titleTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            attributeRecycler = itemView.findViewById(R.id.attributeRecycler);
            productRecyclerView = itemView.findViewById(R.id.productRecyclerView);
            quantityTxt = itemView.findViewById(R.id.quantityTxt);
            plusBtn = itemView.findViewById(R.id.addBtn);
            minusBtn = itemView.findViewById(R.id.minusBtn);
            deleteIcon = itemView.findViewById(R.id.binIcon);

        }
    }

    private void showDialog() {
        final Dialog removeDialog = new Dialog(context);
        removeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        removeDialog.setContentView(R.layout.remove_item_dialog);
        removeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button noBtn = removeDialog.findViewById(R.id.button6);
        Button yesBtn = removeDialog.findViewById(R.id.button7);

        // Configure the BlurView
        BlurView blurView = removeDialog.findViewById(R.id.blurView);
        float blurRadius = 15f; // Adjust blur radius as needed

        ViewGroup rootView = (ViewGroup) removeDialog.getWindow().getDecorView().getRootView();
        Drawable windowBackground = removeDialog.getWindow().getDecorView().getBackground();

        blurView.setupWith(rootView, new RenderScriptBlur(context)) // or RenderEffectBlur for API 31+
                .setFrameClearDrawable(windowBackground)
                .setBlurRadius(blurRadius);

        // Set button listeners
        yesBtn.setOnClickListener(view -> removeDialog.dismiss());
        noBtn.setOnClickListener(view -> removeDialog.dismiss());

        removeDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        removeDialog.setCancelable(true);
        removeDialog.show();
    }
}
