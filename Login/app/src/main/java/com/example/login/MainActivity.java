package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView namalengkap = findViewById(R.id.tv_namaLengkap);
        TextView nama = findViewById(R.id.tv_namaMain);
        namalengkap.setText(Preferences.getLoggedInNama(getBaseContext()));
        nama.setText(Preferences.getLoggedInUser(getBaseContext()));
        findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getBaseContext());startActivity(new
                        Intent(getBaseContext(),Login.class));
                finish();
            }
        });
    }
}