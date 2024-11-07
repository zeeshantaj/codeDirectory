package com.linkitsoft.mrcodekiosk.Fragments;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.linkitsoft.mrcodekiosk.Activities.MainActivity;
import com.linkitsoft.mrcodekiosk.R;

public class PaymentProcess extends BaseFragment {

    public PaymentProcess() {
    }

    private ImageView tapCard;
    private Button saveOrderForLatterBtn;
    private ConstraintLayout paymentSuccessLayout,tapCartLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.payment_process_layout, container, false);
        tapCard = view.findViewById(R.id.imageView5);
        saveOrderForLatterBtn = view.findViewById(R.id.saveOrderForLatterBtn);
        tapCartLayout = view.findViewById(R.id.tapCardLayout);
        paymentSuccessLayout = view.findViewById(R.id.paymentSuccessLayout);
        tapCard.setOnClickListener(view1 -> {
//            startActivity(new Intent(getContext(), MainActivity.class));
            fadeIn(paymentSuccessLayout);
            fadeOut(tapCartLayout);
//
        });

        clickedListener();
        return view;
    }
    private void clickedListener(){
        saveOrderForLatterBtn.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), MainActivity.class));
        });
    }
    private void fadeIn(View view) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0f);
        view.animate()
                .alpha(1f)
                .setDuration(300)
                .setListener(null);
    }

    private void fadeOut(View view) {
        view.animate()
                .alpha(0f)
                .setDuration(300)
                .withEndAction(() -> view.setVisibility(View.GONE));
    }
}
