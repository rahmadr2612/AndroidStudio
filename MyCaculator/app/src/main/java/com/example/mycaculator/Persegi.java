package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Persegi extends AppCompatActivity {

    private EditText sisi;
    private Button hasil;
    private TextView tmtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        sisi = (EditText) findViewById(R.id.sisi);
        hasil = (Button) findViewById(R.id.hasil);
        tmtHasil = (TextView) findViewById(R.id.tmpHasil);
    }

    public void Hasil(View view) {
        double Sisi , hasil;
        Sisi =Double.valueOf(sisi.getText().toString().trim());
        hasil = Sisi * Sisi;
        String Hasil = String.valueOf(hasil);
        tmtHasil.setText(Hasil);
    }
}