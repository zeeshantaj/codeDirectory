package com.linkitsoft.mrcodekiosk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.linkitsoft.mrcodekiosk.Models.SavedOrderModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.List;

public class SavedOrderAdapter extends RecyclerView.Adapter<SavedOrderAdapter.ViewHolder> {
    private Context context;
    private List<SavedOrderModel> savedOrderModelList;

    public SavedOrderAdapter(Context context, List<SavedOrderModel> savedOrderModelList) {
        this.context = context;
        this.savedOrderModelList = savedOrderModelList;
    }

    @NonNull
    @Override
    public SavedOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.saved_order_recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedOrderAdapter.ViewHolder holder, int position) {
        SavedOrderModel model = savedOrderModelList.get(position);
        holder.dateTime.setText(model.getDateTime());

        SavedOrderProductAdapter adapter = new SavedOrderProductAdapter(context,savedOrderModelList.get(position).getModelList());
        holder.productRecycler.setLayoutManager(new LinearLayoutManager(context));
        holder.productRecycler.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return savedOrderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView dateTime;
        private RecyclerView productRecycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateTime = itemView.findViewById(R.id.textView9);
            productRecycler = itemView.findViewById(R.id.productRecycler);
        }
    }
}
