package com.linkitsoft.mrcodekiosk.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.linkitsoft.mrcodekiosk.Interfaces.OnCategoryItemClicked;
import com.linkitsoft.mrcodekiosk.Interfaces.OnPositionListener;
import com.linkitsoft.mrcodekiosk.Models.CategoryModel;
import com.linkitsoft.mrcodekiosk.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> implements OnPositionListener {

    private Context context;
    private List<CategoryModel> categoryModelList;
    private int selectedPosition = 0;
    private RecyclerView recyclerView;
    public CategoryAdapter(Context context, List<CategoryModel> categoryModelList,RecyclerView recyclerView) {
        this.context = context;
        this.categoryModelList = categoryModelList;
        this.recyclerView = recyclerView;
    }

    public void incrementPosition() {
        if (selectedPosition < categoryModelList.size() - 1) {
            selectedPosition++;
            notifyItemChanged(selectedPosition - 1);
            notifyItemChanged(selectedPosition);
        }
    }

    public void decrementPosition() {
        if (selectedPosition > 0) {
            selectedPosition--;
            notifyItemChanged(selectedPosition + 1);
            notifyItemChanged(selectedPosition);
        }
    }
    private void scrollToPosition(RecyclerView recyclerView, int position) {
        recyclerView.post(() -> {
            recyclerView.smoothScrollToPosition(position);
            Log.d("MyApp","pos "+position);
        });
    }
    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_recycler_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {
        CategoryModel model = categoryModelList.get(position);

//        Glide.with(context).load(categoryModelList.get(position).getImage()).placeholder(R.drawable.menuitema)
//                .diskCacheStrategy( DiskCacheStrategy.ALL ).into(holder.image);


        if (position == selectedPosition) {
//            onCategoryItemClicked.OnCatClicked(2);
            scrollToPosition(recyclerView,position);
            holder.itemCardView.setBackgroundResource(R.drawable.category_item_selected);
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(holder.itemView, "scaleX", 1.0f, 1.2f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(holder.itemView, "scaleY", 1.0f, 1.2f);

            scaleX.setInterpolator(new BounceInterpolator());
            scaleY.setInterpolator(new BounceInterpolator());

            scaleX.setDuration(500);
            scaleY.setDuration(500);

            scaleX.start();
            scaleY.start();
        } else {
            holder.itemCardView.setBackgroundResource(R.drawable.category_card_default);
            holder.itemView.setScaleX(1.0f);  // Normal size
            holder.itemView.setScaleY(1.0f);
        }


        holder.itemCardView.setOnClickListener(v -> {
//            animateJump(holder.itemView);
            int oldPosition = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(oldPosition);
            notifyItemChanged(selectedPosition);

//            onCategoryItemClicked.OnCatClicked(2);
        });

        holder.catName.setText(model.getCatName());
        Glide.with(context)
                .load(model.getImageId())
                .into(holder.catImg);



    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }


    @Override
    public void onPositionIncrement() {
        selectedPosition++;
    }

    @Override
    public void onPositionDecrement() {
        selectedPosition--;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView catName;
        private CircleImageView catImg;
        private CardView itemCardView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            itemCardView = itemView.findViewById(R.id.cardView);
            catName = itemView.findViewById(R.id.catTitle);
            catImg = itemView.findViewById(R.id.imageButton3);
        }
    }
}
