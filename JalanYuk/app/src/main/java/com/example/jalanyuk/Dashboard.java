package com.example.jalanyuk;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

public class Dashboard {
    private final String title;
    private final String info;
    private final String des;
    private int imageResource;

    static final String TITLE_KEY = "Title";
    static final String TITLE_DES = "Des";
    static final String TITLE_INFO = "Info";
    static final String IMAGE_KEY = "Image Resource";

    Dashboard(String title, String info,String des, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.des = des;
    }

    String getDes(){
        return des;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    int getImageResource() {
        return imageResource;
    }

    static Intent starter(Context context, String title, String des,String info, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(TITLE_DES, des);
        detailIntent.putExtra(TITLE_INFO, info);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }

}
