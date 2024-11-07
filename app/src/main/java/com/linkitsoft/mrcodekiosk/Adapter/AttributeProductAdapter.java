package com.linkitsoft.mrcodekiosk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.linkitsoft.mrcodekiosk.Models.AttributesModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.List;

public class AttributeProductAdapter extends RecyclerView.Adapter<AttributeProductAdapter.ViewHolder>  {
    private Context context;
    private List<AttributesModel> attributesModelList;

    public AttributeProductAdapter(Context context, List<AttributesModel> attributesModelList) {
        this.context = context;
        this.attributesModelList = attributesModelList;
    }

    @NonNull
    @Override
    public AttributeProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_attributes_products,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttributeProductAdapter.ViewHolder holder, int position) {
        AttributesModel model = attributesModelList.get(position);

        holder.productName.setText(model.getName());
        holder.price.setText(String.valueOf("€ "+model.getPrice()));
        Glide.with(context)
                .load(model.getImageId())
                .into(holder.productImg);

        if (model.getType() == 1){
            holder.clRadioBtn.setVisibility(View.VISIBLE);
        }
        else if (model.getType() == 2){
            holder.clCheckBox.setVisibility(View.VISIBLE);
        }
        holder.attributeRadiobutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                holder.attributeRadiobutton.setChecked(b);
            }
        });

    }

    @Override
    public int getItemCount() {
        return attributesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productName,price;
        private ImageView productImg;
        private ConstraintLayout clRadioBtn,clCheckBox,clQty;
        RadioButton attributeRadiobutton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.textView15);
            price = itemView.findViewById(R.id.textView16);
            productImg = itemView.findViewById(R.id.attributeImg);

            clRadioBtn = itemView.findViewById(R.id.clRadioBtn);
            clCheckBox = itemView.findViewById(R.id.clCheckBox);
            clQty = itemView.findViewById(R.id.clQty);

            attributeRadiobutton = itemView.findViewById(R.id.isMinRadio);
        }
    }
}
