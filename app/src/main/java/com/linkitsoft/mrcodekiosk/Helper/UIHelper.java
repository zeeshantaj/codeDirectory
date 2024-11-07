package com.linkitsoft.mrcodekiosk.Helper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.linkitsoft.mrcodekiosk.R;

import es.dmoral.toasty.Toasty;

public class UIHelper {
//    public static Dialog processDialog;
//    public static void showShortErrorToasty(Context context, String message, boolean showIcon) {
//        Toasty.error(context, message, Toast.LENGTH_SHORT, showIcon).show();
//    }
//
//    public static void showShortSuccessToasty(Context context, String message, boolean showIcon) {
//        Toasty.success(context, message, Toast.LENGTH_SHORT, showIcon).show();
//    }
//
//
//    public static void showProcessDialog(Context context,String title, String content){
//        TextView contentTextView, titleTextView;
//        processDialog = new Dialog(context);
//        processDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        processDialog.setContentView(R.layout.processing_dialog);
//        processDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        contentTextView = processDialog.findViewById(R.id.pass);
//        titleTextView = processDialog.findViewById(R.id.textView32);
//
//
//        titleTextView.setText("" + title);
//        if (content.trim().length() > 0){
//            contentTextView.setText("" + content);
//        }else {
//            contentTextView.setVisibility(View.GONE);
//        }
//
//
//        View core_view = processDialog.getWindow().getDecorView();
//        core_view.setSystemUiVisibility(CommonUtils.hide_system_bars(core_view));
//        processDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        processDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        processDialog.setCancelable(true);
//
//
//        processDialog.show();
//    }
//    public static void showSuccessDialog(Context context, String title, String content) {
//
//        processDialog = new Dialog(context);
//        processDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        processDialog.setContentView(R.layout.success_dialog);
//        processDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        Button btnContinue = processDialog.findViewById(R.id.button7);
//        TextView contentTextView = processDialog.findViewById(R.id.pass);
//        TextView titleTextView = processDialog.findViewById(R.id.textView32);
//
////        setText:
//        titleTextView.setText("" + title);
//        contentTextView.setText("" + content);
//
////        showImageType:
//
//
//        btnContinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (processDialog != null && processDialog.isShowing()){
//                    processDialog.dismiss();
//                }
//            }
//        });
//
//
//        View core_view = processDialog.getWindow().getDecorView();
//        core_view.setSystemUiVisibility(CommonUtils.hide_system_bars(core_view));
//        processDialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.MATCH_PARENT);
//        processDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        processDialog.setCancelable(false);
//
//        processDialog.show();
//
//    }
//    public static void showErrorDialog(Context context, String title, String content, OnDialogDismiss onDialogDismiss) {
//
//        processDialog = new Dialog(context);
//        processDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        processDialog.setContentView(R.layout.error_dialog);
//        processDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        Button btnContinue = processDialog.findViewById(R.id.button7);
//        TextView contentTextView = processDialog.findViewById(R.id.pass);
//        TextView titleTextView = processDialog.findViewById(R.id.textView32);
//
////        setText:
//        titleTextView.setText("" + title);
//        contentTextView.setText("" + content);
//
////        showImageType:
//
//
//        btnContinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (processDialog != null && processDialog.isShowing()){
//                    processDialog.dismiss();
//                    onDialogDismiss.onDismiss();
//                }
//            }
//        });
//
//
//        processDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        processDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        processDialog.setCancelable(false);
//        processDialog.show();
//
//    }
//    public static void showErrorDialog(Context context, String title, String content) {
//
//        processDialog = new Dialog(context);
//        processDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        processDialog.setContentView(R.layout.error_dialog);
//        processDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        Button btnContinue = processDialog.findViewById(R.id.button7);
//        TextView contentTextView = processDialog.findViewById(R.id.pass);
//        TextView titleTextView = processDialog.findViewById(R.id.textView32);
//
////        setText:
//        titleTextView.setText("" + title);
//        contentTextView.setText("" + content);
//
////        showImageType:
//
//
//        btnContinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    processDialog.dismiss();
//
//            }
//        });
//
//
//        processDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        processDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        processDialog.setCancelable(false);
//        processDialog.show();
//
//    }
//
//
//    public static void showWarningDialog(Context context, String title, String content) {
//
//        processDialog = new Dialog(context);
//        processDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        processDialog.setContentView(R.layout.warning_dialog);
//        processDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        Button btnContinue = processDialog.findViewById(R.id.button7);
//        TextView contentTextView = processDialog.findViewById(R.id.pass);
//        TextView titleTextView = processDialog.findViewById(R.id.textView32);
//
////        setText:
//        titleTextView.setText("" + title);
//        contentTextView.setText("" + content);
//
////        showImageType:
//
//
//        btnContinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (processDialog != null && processDialog.isShowing()){
//                    processDialog.dismiss();
//                }
//            }
//        });
//
//
//        processDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        processDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        processDialog.setCancelable(false);
//        processDialog.show();
//
//    }
//
//    public static void dismissProcessDialog(){
//        if (processDialog != null && processDialog.isShowing()){
//            processDialog.dismiss();
//        }
//    }
//    public static Bitmap blur(Context context, Bitmap image) {
//
//        float BITMAP_SCALE = 0.4f;
//        float BLUR_RADIUS = 7.5f;
//        int width = Math.round(image.getWidth() * BITMAP_SCALE);
//        int height = Math.round(image.getHeight() * BITMAP_SCALE);
//
//        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
//        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);
//
//        RenderScript rs = RenderScript.create(context);
//        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
//        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
//        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);
//        blurScript.setRadius(BLUR_RADIUS);
//        blurScript.setInput(tmpIn);
//        blurScript.forEach(tmpOut);
//        tmpOut.copyTo(outputBitmap);
//        return outputBitmap;
//    }


}
