package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kubus extends AppCompatActivity {

    private EditText panjang;
    private EditText lebar;
    private EditText tinggi;
    private Button hasil;
    private TextView tmpHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);

        panjang = (EditText) findViewById(R.id.panjang);
        lebar = (EditText) findViewById(R.id.lebar);
        tinggi = (EditText) findViewById(R.id.tinggi);
        hasil = (Button) findViewById(R.id.hasil);
        tmpHasil = (TextView) findViewById(R.id.tmpHasil3);
    }

    public void Hasil3(View view) {
        double Panjang, Lebar, Tinggi, hasil;
        Panjang =Double.valueOf(panjang.getText().toString().trim());
        Lebar =Double.valueOf(lebar.getText().toString().trim());
        Tinggi =Double.valueOf(tinggi.getText().toString().trim());

        hasil = Panjang * Lebar * Tinggi;
        String Hasil = String.valueOf(hasil);
        tmpHasil.setText(Hasil);
    }
}