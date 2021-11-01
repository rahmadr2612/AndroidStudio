package com.example.ayamku;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.bumptech.glide.Glide;

public class AyamAdapter extends RecyclerView.Adapter<AyamAdapter.AyamViewHolder> {
    private GradientDrawable mGradientDrawable;
    private ArrayList<Ayam> mAyamsData;
    private Context mContext;


    AyamAdapter(Context context, ArrayList<Ayam> ayamsData) {
        this.mAyamsData = ayamsData;
        this.mContext = context;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.an1);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public AyamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AyamViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(AyamViewHolder holder, int position) {

        //Get the current sport
        Ayam currentAyam = mAyamsData.get(position);

        //Bind the data to the views
        holder.bindTo(currentAyam);

    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mAyamsData.size();
    }


    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class AyamViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;
        private Context mContext;
        private Ayam mCurrentAyam;
        private GradientDrawable mGradientDrawable;


        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        AyamViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mSportsImage = (ImageView)itemView.findViewById(R.id.sportsImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Ayam currentAyam){
            //Populate the textviews with data
            mTitleText.setText(currentAyam.getTitle());
            mInfoText.setText(currentAyam.getInfo());

            //Get the current sport
            mCurrentAyam = currentAyam;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentAyam.
                    getImageResource()).placeholder(mGradientDrawable).into(mSportsImage);
        }

        @Override
        public void onClick(View view) {

        }
    }
}