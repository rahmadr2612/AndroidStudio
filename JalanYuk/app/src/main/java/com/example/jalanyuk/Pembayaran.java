package com.example.jalanyuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Pembayaran extends AppCompatActivity {

    private TextView Total, Kembalian;
    private EditText Bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        Total = (TextView) findViewById(R.id.harga);
        Kembalian = (TextView)findViewById(R.id.kembalian);
        Bayar = (EditText) findViewById(R.id.bayar);

        Intent terimaa = getIntent();
        String total = terimaa.getStringExtra("bayar");
        Total.setText(total);

        findViewById(R.id.cekout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer harga = Integer.parseInt(total);
                Integer bbayar = Integer.valueOf(Bayar.getText().toString());
                Integer kkembalian = bbayar - harga;
                Kembalian.setText(String.valueOf(kkembalian));
            }
        });

    }
}