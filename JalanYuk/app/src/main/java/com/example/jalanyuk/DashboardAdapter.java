package com.example.jalanyuk;

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

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboarViewHolder> {
    private GradientDrawable mGradientDrawable;
    private ArrayList<Dashboard> mDashboarsData;
    private Context mContext;


    DashboardAdapter(Context context, ArrayList<Dashboard> ayamsData) {
        this.mDashboarsData = ayamsData;
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
    public DashboarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DashboarViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(DashboarViewHolder holder, int position) {

        //Get the current sport
        Dashboard currentDashboar = mDashboarsData.get(position);

        //Bind the data to the views
        holder.bindTo(currentDashboar);

    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mDashboarsData.size();
    }


    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class DashboarViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;
        private Context mContext;
        private Dashboard mCurrentDashboard;
        private GradientDrawable mGradientDrawable;


        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        DashboarViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mSportsImage = (ImageView)itemView.findViewById(R.id.Image);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Dashboard currentDashboard){
            //Populate the textviews with data
            mTitleText.setText(currentDashboard.getTitle());
            mInfoText.setText(currentDashboard.getInfo());

            //Get the current sport
            mCurrentDashboard = currentDashboard;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentDashboard.
                    getImageResource()).placeholder(mGradientDrawable).into(mSportsImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Dashboard.starter(mContext, mCurrentDashboard.getTitle(), mCurrentDashboard.getInfo(), mCurrentDashboard.getDes(),
                    mCurrentDashboard.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }

    }
}
