package com.linkitsoft.mrcodekiosk.Activities;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import com.linkitsoft.mrcodekiosk.R;
import com.mukeshsolanki.OnOtpCompletionListener;
import com.mukeshsolanki.OtpView;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class MainActivity extends BaseActivity{


    public static NavController navController;
    private ImageView mrCodeImg,headerImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrCodeImg = findViewById(R.id.mrCodeImg);
        headerImage = findViewById(R.id.headerImage);

//        BlurView blurView = findViewById(R.id.blurView);
//        float radius = 15f;
//
//        View decorView = getWindow().getDecorView();
//        ViewGroup rootView = decorView.findViewById(android.R.id.content);
//        Drawable windowBackground = decorView.getBackground();
//
//        blurView.setupWith(rootView, new RenderScriptBlur(this)) // or RenderEffectBlur
//                .setFrameClearDrawable(windowBackground) // Optional
//                .setBlurRadius(radius);
//
//        // Create a ShapeDrawable with rounded corners
//        float cornerRadius = 30f;  // Adjust corner radius
//        ShapeDrawable shapeDrawable = new ShapeDrawable();
//        shapeDrawable.setShape(new RoundRectShape(
//                new float[] {cornerRadius, cornerRadius, cornerRadius, cornerRadius,
//                        cornerRadius, cornerRadius, cornerRadius, cornerRadius},
//                null, null));
//        shapeDrawable.getPaint().setColor(Color.TRANSPARENT); // Transparent background
//        blurView.setBackground(shapeDrawable);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        navController.navigate(R.id.homeFragment);

        mrCodeImg.setOnClickListener(v -> {
            enterConfigPin();
        });

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                Log.d("MyApp",navDestination.getLabel().toString());
                String label = navDestination.getLabel().toString();
                if (label.equals("Menu Fragment") || label.equals("modifier Fragment") || label.equals("checkout Fragment")
                        || label.equals("savedOrder Fragment") || label.equals("select cat Fragment")){
//                    animateImage(headerImage);
                    headerImage.setVisibility(View.VISIBLE);
                }else {
                    headerImage.setVisibility(View.GONE);
                }
            }
        });

      animateImage(mrCodeImg);
    }
    private void enterConfigPin() {
        final Dialog ipDialog = new Dialog(this);
        ipDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ipDialog.setContentView(R.layout.config_pin_dialog);
        ipDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button continueBtn = ipDialog.findViewById(R.id.button7);
        OtpView otpView = ipDialog.findViewById(R.id.otp_view);

//        bgImg.setAlpha(0.4f);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ipDialog.dismiss();
                startActivity(new Intent(MainActivity.this,ConfigActivity.class));
//                bgImg.setAlpha(1.0f);
//                if (etIp.getText().toString().trim().length() > 0 && etDestPost.getText().toString().trim().length() > 0) {
//                    LocalDataManager.getInstance().putString("paxTerminalIp", etIp.getText().toString());
//                    LocalDataManager.getInstance().putString("paxTerminalDestPort", etDestPost.getText().toString());
//                    ipDialog.dismiss();
//                } else {
//                    UIHelper.showFlawDialog(ConfigActivity.this, getString(R.string.error), getString(R.string.fields_req), 3);
//                }
            }
        });
        ipDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

            }
        });
        otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {

            }
        });
        ipDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        ipDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        ipDialog.setCancelable(true);
        ipDialog.show();

//        BlurView blurView = ipDialog.findViewById(R.id.blurView);
//        float blurRadius = 5f;
//        float cornerRadius = 10f;
//        View decorView = getWindow().getDecorView();
//        ViewGroup rootView = decorView.findViewById(android.R.id.content);
//        Drawable windowBackground = decorView.getBackground();
//
//        blurView.setupWith(rootView, new RenderScriptBlur(this))
//                .setFrameClearDrawable(windowBackground)
//                .setBlurRadius(blurRadius);
//        ShapeDrawable roundedCornersBackground = new ShapeDrawable(
//                new RoundRectShape(
//                        new float[] {cornerRadius, cornerRadius, cornerRadius, cornerRadius,
//                                cornerRadius, cornerRadius, cornerRadius, cornerRadius},
//                        null, null));
//        roundedCornersBackground.getPaint().setColor(Color.TRANSPARENT);
//
//        blurView.setBackground(roundedCornersBackground);
    }
    private void animateImage(View view){
        view.setVisibility(View.VISIBLE);
        ObjectAnimator bounceAnimator = ObjectAnimator.ofFloat(view, "translationY", -500f, 0f);
        bounceAnimator.setDuration(1000); // Animation duration
        bounceAnimator.setInterpolator(new BounceInterpolator()); // Adds bounce effect
        bounceAnimator.start();
    }
}