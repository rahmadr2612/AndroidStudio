package com.example.jalanyuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView sportsTitle = (TextView)findViewById(R.id.titleDetail);
        TextView sportsDes = (TextView)findViewById(R.id.titleDes);
        TextView sportsInfo = (TextView)findViewById(R.id.subTitleDetail);
        ImageView sportsImage = (ImageView)findViewById(R.id.sportsImageDetail);

        //Totalan
        btn = findViewById(R.id.btn1);

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Dashboard.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        sportsTitle.setText(getIntent().getStringExtra(Dashboard.TITLE_KEY));
        sportsInfo.setText(getIntent().getStringExtra(Dashboard.TITLE_INFO));
        sportsDes.setText(getIntent().getStringExtra(Dashboard.TITLE_DES));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Dashboard.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(sportsImage);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Total2 = Integer.parseInt(getIntent().getStringExtra(Dashboard.TITLE_DES));
                Integer Total1 =+ Total2;
                String Total = String.valueOf(Total1);

                //kirim data
                Intent kirim = new Intent(DetailActivity.this, MainActivity.class);
                kirim.putExtra("total",Total);
                startActivity(kirim);
            }
        });

    }

}