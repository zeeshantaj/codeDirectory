package com.linkitsoft.mrcodekiosk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Models.ProductModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.List;

public class DealProductAdapter extends RecyclerView.Adapter<DealProductAdapter.ViewHolder> {
    private Context context;
    private List<ProductModel> productModelList;

    public DealProductAdapter(Context context, List<ProductModel> productModelList) {
        this.context = context;
        this.productModelList = productModelList;
    }

    @NonNull
    @Override
    public DealProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.deal_product_rec_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealProductAdapter.ViewHolder holder, int position) {
        ProductModel model = productModelList.get(position);
        holder.name.setText(model.getQuantity() +" x "+ model.getProductName());
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
