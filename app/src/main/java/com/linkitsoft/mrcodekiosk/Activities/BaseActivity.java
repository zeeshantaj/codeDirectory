package com.linkitsoft.mrcodekiosk.Activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.linkitsoft.mrcodekiosk.R;

public class BaseActivity extends AppCompatActivity {
    Boolean isuserpaying = false;
    Boolean threadintrupt = false;
    Boolean oncreate = false;
    Dialog customDialog;
    wait30 w30;
    Button btnContinue,btnClose;
    TextView contentTextView;

    IntentFilter filter;
    boolean previewStatus,restartStatus,themeStatus;
//    GetKioskThemeTask getKioskThemeTask;
//    DownloadVideoTask downloadVideoTask;

    public class wait30 extends Thread {
        public wait30() {
        }

        public void run() {

            super.run();

            while (!threadintrupt) {

                try {
//                    set 3 min:
                    Thread.sleep(180000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final CountDownTimer[] ct = new CountDownTimer[1];
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ct[0] = new CountDownTimer(10000, 1000) {
                                public void onTick(long millisUntilFinished) {

                                    if (!isuserpaying) {
                                        if (millisUntilFinished > 0) {
                                            contentTextView.setText("Please confirm (" + millisUntilFinished / 1000 + ")");
                                        } else {
                                            threadintrupt = true;
                                            try {
                                                customDialog.dismiss();
                                            } catch (Exception ex) {
                                            }
                                            Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                            ct[0].cancel();
                                        }
                                    }
                                }

                                public void onFinish() {

                                    try {
                                        customDialog.dismiss();
                                    } catch (Exception ex) {
                                    }
                                    threadintrupt = true;
                                    ct[0].cancel();
                                    Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }
                            };

                            if (!isuserpaying) {
                                showsweetalerttimeout(ct);
                                ct[0].start();
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        }
    }

    void showsweetalerttimeout(final CountDownTimer[] ct) {
        customDialog = new Dialog(this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.timer_dialog);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnContinue = customDialog.findViewById(R.id.button7);
        btnClose = customDialog.findViewById(R.id.button6);
        contentTextView = customDialog.findViewById(R.id.pass);

        customDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                // Handle dialog dismiss event
                ct[0].cancel();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ct[0].cancel();
                customDialog.dismiss();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threadintrupt = true;
                ct[0].cancel();
                customDialog.dismiss();
                Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        customDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        customDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        customDialog.show();
    }

    //********************************** TIMER **********************************************************


    // *********************************App View**************************************************************
    private View core_view;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            core_view.setSystemUiVisibility(hide_system_bars());
        }
    }

    private int hide_system_bars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

// *********************************App View**************************************************************


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        core_view = getWindow().getDecorView();
        core_view.setSystemUiVisibility(hide_system_bars());
        core_view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0) {
                    core_view.setSystemUiVisibility(hide_system_bars());
                }
            }
        });

        w30 = new wait30();
        w30.start();
        oncreate = true;
    }


    @Override
    protected void onPause() {
        super.onPause();
        threadintrupt = true;
        isuserpaying = true;
//        if (socketEventReceiver != null){
//            unregisterReceiver(socketEventReceiver);
//        }
    }
//
    @Override
    protected void onResume() {
        super.onResume();
//        filter = new IntentFilter(AppConstants.SOCKET_EVENT_ACTION);
//        registerReceiver(socketEventReceiver, filter);
        threadintrupt = false;
        isuserpaying = false;
        if (!oncreate) {
            new wait30().start();
        } else {
            oncreate = false;
        }
    }
//    private BroadcastReceiver socketEventReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String status = intent.getStringExtra("status");
//            if ("connected".equals(status)) {
//                System.out.println("Socket is connected");
//            } else if ("message_received".equals(status)) {
//                System.out.println("Socket message received");
//                previewStatus = LocalDataManager.getInstance().getBoolean("previewStatus");
//                restartStatus = LocalDataManager.getInstance().getBoolean("restartStatus");
//                themeStatus = LocalDataManager.getInstance().getBoolean("themeStatus");
//                if (previewStatus) {
//                    ScreenShotTask screenShotTask = new ScreenShotTask(BaseActivity.this, 7, "videoScreenShot");
//                    screenShotTask.takeScreenShotWithoutVideo();
//                } else if (restartStatus) {
//                    CommonUtils.restartKiosk();
//                }
////                else if (themeStatus){
////                    syncTheme();
////                }
//            }
//        }
//    };
}
