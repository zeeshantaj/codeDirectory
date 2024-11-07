package com.linkitsoft.mrcodekiosk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.linkitsoft.mrcodekiosk.Models.DealProdModel;
import com.linkitsoft.mrcodekiosk.Models.ProductModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.ArrayList;
import java.util.List;

public class SavedOrderProductAdapter extends RecyclerView.Adapter<SavedOrderProductAdapter.ViewHolder> {
    private Context context;
    private List<DealProdModel> dealProdModel;

    public SavedOrderProductAdapter(Context context, List<DealProdModel> dealProdModel) {
        this.context = context;
        this.dealProdModel = dealProdModel;
    }

    @NonNull
    @Override
    public SavedOrderProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.saved_order_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedOrderProductAdapter.ViewHolder holder, int position) {
        DealProdModel model = dealProdModel.get(position);
        holder.dealName.setText(model.getQuantity()+" x "+model.getDealTitle());
        holder.priceTxt.setText(String.valueOf("€ "+model.getPrice()));

        Glide.with(context)
                .load(model.getImgId())
                .into(holder.productImg);
//
        List<ProductModel> list = new ArrayList<>();
//        List<ProductModel> list1 = new ArrayList<>();
//        List<ProductModel> list2 = new ArrayList<>();
        list = dealProdModel.get(position).getModelList();


        DealProductAdapter adapter = new DealProductAdapter(context,dealProdModel.get(position).getModelList());
        holder.attributeRecycler.setLayoutManager(new LinearLayoutManager(context));
        holder.attributeRecycler.setAdapter(adapter);

//        for (int i = 0; i < list.size(); i++){
//            if (list.get(i).getType() == 1){
//                list1.add(list.get(i));
//            }else if (list.get(i).getType() == 2){
//                list2.add(list.get(i));
//            }
//        }
//        if (!list1.isEmpty()){
//
//        }
//        if (!list2.isEmpty()){
//            DealProductAdapter adapter = new DealProductAdapter(context,list2);
//            holder.attributeRecycler.setLayoutManager(new LinearLayoutManager(context));
//            holder.attributeRecycler.setAdapter(adapter);
//        }


    }

    @Override
    public int getItemCount() {
        return dealProdModel.size();
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
}
