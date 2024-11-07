package com.linkitsoft.mrcodekiosk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Models.AttributeCatModel;
import com.linkitsoft.mrcodekiosk.Models.AttributesModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.List;

public class AttributesCatAdapter extends RecyclerView.Adapter<AttributesCatAdapter.ViewHolder> {
    private Context context;
    private List<AttributeCatModel> attributeCatModelList;

    public AttributesCatAdapter(Context context, List<AttributeCatModel> attributeCatModelList) {
        this.context = context;
        this.attributeCatModelList = attributeCatModelList;
    }

    @NonNull
    @Override
    public AttributesCatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.attributes_cat_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttributesCatAdapter.ViewHolder holder, int position) {
        AttributeCatModel model = attributeCatModelList.get(position);
        holder.catName.setText(model.getCatName());

        holder.attributeRecycler.setLayoutManager(new GridLayoutManager(context,5));
        AttributeProductAdapter adapter = new AttributeProductAdapter(context,model.getAttributesModels());
        holder.attributeRecycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return attributeCatModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView catName;
        private RecyclerView attributeRecycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.textView29);
            attributeRecycler = itemView.findViewById(R.id.recyclerView6);

        }
    }
}
