package com.vikdev.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button euro, pound, dollar, yen, dinar, bitcoin, ruble, ausdollar, candollar;
    EditText mEditText;
    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euro = findViewById(R.id.euro);
        pound = findViewById(R.id.pound);
        dollar = findViewById(R.id.dollar);
        yen = findViewById(R.id.yen);
        dinar = findViewById(R.id.dinar);
        bitcoin = findViewById(R.id.bitcoin);
        ruble = findViewById(R.id.ruble);
        ausdollar = findViewById(R.id.ausdollar);
        candollar = findViewById(R.id.candollar);

        mEditText = findViewById(R.id.editText);
        mTextView = findViewById(R.id.textView);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getCurrency = mEditText.getText().toString();
                if (TextUtils.isEmpty(getCurrency)) {
                    mEditText.setError("Empty User Input");
                } else {
                    double converter, result = 0;
                    converter = Double.parseDouble(getCurrency);
                    switch (v.getId()) {
                        case R.id.euro:
                            result = converter * 0.012;
                            break;
                        case R.id.dollar:
                            result = converter * 0.013;
                            break;
                        case R.id.pound:
                            result = converter * 0.010;
                            break;
                        case R.id.yen:
                            result = converter * 1.45;
                            break;
                        case R.id.dinar:
                            result = converter * 0.0041;
                            break;
                        case R.id.bitcoin:
                            result = converter * 0.0000014;
                            break;
                        case R.id.ruble:
                            result = converter * 0.91;
                            break;
                        case R.id.ausdollar:
                            result = converter * 0.019;
                            break;
                        case R.id.candollar:
                            result = converter * 0.018;
                            break;
                        default:
                            //nothing
                    }

                    mTextView.setText(null);
                    DecimalFormat decimalFormat = new DecimalFormat("#.00");
                    mTextView.setText("" + decimalFormat.format(result));
                }
            }
        };
        euro.setOnClickListener(listener);
        pound.setOnClickListener(listener);
        dollar.setOnClickListener(listener);
        yen.setOnClickListener(listener);
        dinar.setOnClickListener(listener);
        bitcoin.setOnClickListener(listener);
        ruble.setOnClickListener(listener);
        ausdollar.setOnClickListener(listener);
        candollar.setOnClickListener(listener);

    }
}
