package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segitiga extends AppCompatActivity {

    private EditText alas;
    private EditText tinggi;
    private Button hasil;
    private TextView tmpHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        alas = (EditText) findViewById(R.id.alas);
        tinggi = (EditText) findViewById(R.id.tinggi);
        hasil = (Button) findViewById(R.id.hasil);
        tmpHasil = (TextView) findViewById(R.id.tmpHasil1);
    }

    public void Hasil1(View view) {
        double Alas, Tinggi, hasil;
        Alas =Double.valueOf(alas.getText().toString().trim());
        Tinggi =Double.valueOf(tinggi.getText().toString().trim());
        hasil = Alas * Tinggi * 0.5;
        String Hasil = String.valueOf(hasil);
        tmpHasil.setText(Hasil);
    }
}