package com.linkitsoft.mrcodekiosk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Models.ProductCatModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.List;

public class ProductCatAdapter extends RecyclerView.Adapter<ProductCatAdapter.ViewHolder> {
    private Context context;
    private List<ProductCatModel> productCatModels;

    public ProductCatAdapter(Context context, List<ProductCatModel> productCatModels) {
        this.context = context;
        this.productCatModels = productCatModels;
    }

    @NonNull
    @Override
    public ProductCatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_cat_rec_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCatAdapter.ViewHolder holder, int position) {
        ProductCatModel model = productCatModels.get(position);
        holder.categoryName.setText(model.getCatName());

        holder.productRecycler.setLayoutManager(new GridLayoutManager(context,5));
        ProductAdapter productAdapter = new ProductAdapter(context,model.getModels());
        holder.productRecycler.setAdapter(productAdapter);

    }

    @Override
    public int getItemCount() {
        return productCatModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryName;
        private RecyclerView productRecycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            productRecycler = itemView.findViewById(R.id.productRecyclerView);

        }
    }
}
