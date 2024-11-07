package com.linkitsoft.mrcodekiosk.Adapter;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.linkitsoft.mrcodekiosk.Models.CategoryModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<CategoryModel> categoryModelList;

    public ProductAdapter(Context context, List<CategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_recycler_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        CategoryModel model = categoryModelList.get(position);
        holder.catName.setText(model.getCatName());
        holder.price.setText(String.valueOf("€ "+model.getPrice()));


        Glide.with(context)
                .load(model.getImageId())
                .into(holder.catImg);

        holder.itemCardView.setOnClickListener(view -> {
            navController.navigate(R.id.modifierFragment);
        });
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView catName,price;
        private CircleImageView catImg;
        private CardView itemCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCardView = itemView.findViewById(R.id.cardView);
            catName = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.productPrice);
            catImg = itemView.findViewById(R.id.imageButton3);
        }
    }
}
