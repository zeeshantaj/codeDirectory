package com.linkitsoft.mrcodekiosk.Fragments;

import static com.linkitsoft.mrcodekiosk.Activities.MainActivity.navController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.hbb20.CountryCodePicker;
import com.linkitsoft.mrcodekiosk.R;

public class OrderProcessFragment extends BaseFragment {
    public OrderProcessFragment() {
    }
    private CardView takeawayBtn,dineInBtn,signUpBtn,guestBtn;
    private EditText singInPhoneNumberEdt,fullNameEdt,EmailEdt,signUpPhoneNumEdt;
    private Button signInContinueBtn,signUpContinueBtn;
    private ConstraintLayout orderTypeContainer,signInLayoutContainer,signUpLayoutContainer;
    private CountryCodePicker countryCodePicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.order_process_layout, container, false);
        takeawayBtn = view.findViewById(R.id.takeAwayCard);
        dineInBtn = view.findViewById(R.id.dineInCard);
        signUpBtn = view.findViewById(R.id.signupCard);
        guestBtn = view.findViewById(R.id.guestCard);
        fullNameEdt = view.findViewById(R.id.fullNameEdt);
        EmailEdt = view.findViewById(R.id.EmailEdt);
        signUpPhoneNumEdt = view.findViewById(R.id.phoneNumEdt);
        singInPhoneNumberEdt = view.findViewById(R.id.phoneNumberEdt);
        signUpContinueBtn = view.findViewById(R.id.signUpContinueBtn);
        signInContinueBtn = view.findViewById(R.id.phoneNumberContinueBtn);
        orderTypeContainer = view.findViewById(R.id.orderTypeContainer);
        signInLayoutContainer = view.findViewById(R.id.signInLayoutContainer);
        signUpLayoutContainer = view.findViewById(R.id.signUpLayoutContainer);
        countryCodePicker = view.findViewById(R.id.country_code);

        clickedListeners();
        return view;
    }
    private void clickedListeners(){

        dineInBtn.setOnClickListener(view1 -> {
//            navController.navigate(R.id.menuFragment);
            fadeIn(signInLayoutContainer);
            fadeOut(signUpLayoutContainer);
            fadeOut(orderTypeContainer);

        });
        takeawayBtn.setOnClickListener(view1 -> {
            fadeIn(signInLayoutContainer);
            fadeOut(signUpLayoutContainer);
            fadeOut(orderTypeContainer);
//            navController.navigate(R.id.menuFragment);
        });
        guestBtn.setOnClickListener(view -> {
            navController.navigate(R.id.menuFragment);
        });
        signInContinueBtn.setOnClickListener(view -> {
            navController.navigate(R.id.menuFragment);
        });
        signUpContinueBtn.setOnClickListener(view -> {
            navController.navigate(R.id.menuFragment);
        });
        signUpBtn.setOnClickListener(view -> {
            fadeIn(signUpLayoutContainer);
            fadeOut(signInLayoutContainer);
            fadeOut(orderTypeContainer);
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
