package com.linkitsoft.mrcodekiosk.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import androidx.fragment.app.Fragment;

import com.linkitsoft.mrcodekiosk.Activities.MainActivity;
import com.linkitsoft.mrcodekiosk.R;

public class BaseFragment extends Fragment {
    Boolean isuserpaying = false;
    Boolean threadintrupt = false;
    Boolean oncreate = false;
    Dialog customDialog;
    wait30 w30;
    Button btnContinue,btnClose;
    TextView contentTextView;

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
                if (getActivity() != null) {
                    getActivity().runOnUiThread(new Runnable() {
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
                                                Intent intent = new Intent(getContext(), MainActivity.class);
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
                                        Intent intent = new Intent(getContext(), MainActivity.class);
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
    }

    void showsweetalerttimeout(final CountDownTimer[] ct) {
        customDialog = new Dialog(getContext());
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
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        customDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        customDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        customDialog.show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        w30 = new wait30();
        w30.start();
        oncreate = true;
    }


    @Override
    public void onPause() {
        super.onPause();
        threadintrupt = true;
        isuserpaying = true;
    }


    @Override
    public void onResume() {
        super.onResume();
        threadintrupt = false;
        isuserpaying = false;
        if (!oncreate) {
            new wait30().start();
        } else {
            oncreate = false;
        }
    }
}
