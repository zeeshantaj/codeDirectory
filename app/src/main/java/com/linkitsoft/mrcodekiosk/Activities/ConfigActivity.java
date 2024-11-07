package com.linkitsoft.mrcodekiosk.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.cardview.widget.CardView;

import com.linkitsoft.mrcodekiosk.R;

public class ConfigActivity extends BaseActivity{

    private CardView kioskPrintBtn,kitchenPrinterBtn,paymentTerminalBtn,taxReceiptBtn;
    private EditText kioskId,email,password;
    private Button backToHomeBtn,saveBtn,syncBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        kioskId = findViewById(R.id.kioskIdEdt);
        email = findViewById(R.id.emailEdt);
        password = findViewById(R.id.passwordEdt);
        backToHomeBtn = findViewById(R.id.backToHomeBtn);
        saveBtn = findViewById(R.id.saveBtn);
        syncBtn = findViewById(R.id.syncBtn);
        kioskPrintBtn = findViewById(R.id.kioskPrinterCard);
        kitchenPrinterBtn = findViewById(R.id.kitchenPrinterCard);
        paymentTerminalBtn = findViewById(R.id.paymentTerminalCard);
        taxReceiptBtn = findViewById(R.id.taxRreceiptPrintCard);

        onClickedListeners();
    }
    private void onClickedListeners(){
        saveBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        syncBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        backToHomeBtn.setOnClickListener(view -> {
            finish();
        });
        kioskPrintBtn.setOnClickListener(view -> {

        });
        kitchenPrinterBtn.setOnClickListener(view -> {

        });
        paymentTerminalBtn.setOnClickListener(view -> {

        });
        taxReceiptBtn.setOnClickListener(view -> {

        });



    }

}
