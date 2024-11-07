package com.linkitsoft.mrcodekiosk.Fragments;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.linkitsoft.mrcodekiosk.Activities.MainActivity;
import com.linkitsoft.mrcodekiosk.R;

public class PaymentProcess extends Fragment {

    public PaymentProcess() {
    }

    private ImageView tapCard;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.payment_process_layout, container, false);
        tapCard = view.findViewById(R.id.imageView5);
        tapCard.setOnClickListener(view1 -> {
            startActivity(new Intent(getContext(), MainActivity.class));
        });

        return view;
    }
}
