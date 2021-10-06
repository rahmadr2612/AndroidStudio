package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lingkaran extends AppCompatActivity {

    private EditText jari_jari;
    private Button hasil;
    private TextView tmpHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        jari_jari = (EditText) findViewById(R.id.jari_jari);
        hasil = (Button) findViewById(R.id.hasil);
        tmpHasil = (TextView) findViewById(R.id.tmpHasil2);
    }

    public void Hasil2(View view) {
        double Jari_Jari, hasil;
        Jari_Jari =Double.valueOf(jari_jari.getText().toString().trim());
        hasil = 3.14 * Jari_Jari * Jari_Jari;
        String Hasil = String.valueOf(hasil);
        tmpHasil.setText(Hasil);
    }
}