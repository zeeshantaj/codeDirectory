package com.linkitsoft.mrcodekiosk.Fragments;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.linkitsoft.mrcodekiosk.R;
import com.mukeshsolanki.OnOtpCompletionListener;
import com.mukeshsolanki.OtpView;

public class StartOrderFragment extends Fragment {

    public StartOrderFragment() {
    }

    private ImageView bgImg;
    private Button startOrderBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.start_order, container, false);

        startOrderBtn = view.findViewById(R.id.startOrderBtn);
        bgImg = view.findViewById(R.id.bgImg);

        bgImg.setAlpha(1.0f);



        startOrderBtn.setOnClickListener(view1 -> {
            navController.navigate(R.id.orderProcessFragment);
        });

        return view;
    }

}
