package com.example.nilaiku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edTgs,edUts,edUas,edHuruf,edAkhir,edPredikat,edPTgs,edPUts,edPUas;
    private float nTgs,nUts,nUas,nPTgs,nPUts,nPUas,nAkhir;
    private String predikat,huruf;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTgs = (EditText) findViewById(R.id.editTgs);
        edUts = (EditText) findViewById(R.id.editUts);
        edUas = (EditText) findViewById(R.id.editUas);
        edPTgs = (EditText) findViewById(R.id.editPTgs);
        edPUts = (EditText) findViewById(R.id.editPUts);
        edPUas = (EditText) findViewById(R.id.editPUas);
        edAkhir = (EditText) findViewById(R.id.editAkhir);
        edHuruf = (EditText) findViewById(R.id.editHuruf);
        edPredikat = (EditText) findViewById(R.id.editPredikat);

        edTgs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(edTgs.getText().toString().isEmpty()){
                    nTgs = 0;
                }else {
                    nTgs = Float.parseFloat(edTgs.getText().toString());
                }
                nPTgs = 0.3f * nTgs;
            }
        });
        edUts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(edUts.getText().toString().isEmpty()){
                    nUts = 0;
                }else {
                    nUts = Float.parseFloat(edUts.getText().toString());
                }
                nPUts = 0.3f * nUts;
            }
        });
        edUas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(edUas.getText().toString().isEmpty()){
                    nUas = 0;
                }else {
                    nUas = Float.parseFloat(edUas.getText().toString());
                }
                nPUas = 0.4f * nUas;
            }
        });
    }

    public void hitung(View view) {
        hitungAkhir();
        edAkhir.setText(Float.toString(nAkhir));
        edHuruf.setText(getHuruf(nAkhir));
        edPredikat.setText(getPredikat(huruf));
        edPTgs.setText(Float.toString(nPTgs));
        edPUts.setText(Float.toString(nPUts));
        edPUas.setText(Float.toString(nPUas));
    }

    private void hitungAkhir() {
        nAkhir = nPTgs + nPUts + nPUas;
    }

    private String getPredikat(String nHuruf) {
        switch (nHuruf){
            case "A" :
                predikat = "Apik";
                break;
            case "AB" :
                predikat = "Apik Baik";
                break;
            case "B" :
                predikat = "Baik";
                break;
            case "BC" :
                predikat = "Cukup Baik";
                break;
            case "C" :
                predikat = "Cukup";
                break;
            case "D" :
                predikat = "Dablek";
                break;
            default:
                predikat = "Elek";
                break;
        }return predikat;
    }

    private String getHuruf(Float nilai) {
        if(nilai >= 85){
            huruf = "A";
        }else if(nilai >= 80){
            huruf = "AB";
        }else if(nilai >= 70){
            huruf = "B";
        }else if(nilai >= 65){
            huruf = "BC";
        }else if(nilai >= 60){
            huruf = "C";
        }else if(nilai >= 50){
            huruf = "D";
        }else {
            huruf = "E";
        }return huruf;
    }
}