package com.example.jalanyuk;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Dashboard> mDashboarsData;
    private DashboardAdapter mAdapter;

    private TextView ttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Initialize the ArrayList that will contain the data
        mDashboarsData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new DashboardAdapter(this, mDashboarsData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

        //Helper class for creating swipe to dismiss and drag and drop functionality
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {


            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(mDashboarsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }


            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Remove the item from the dataset
                mDashboarsData.remove(viewHolder.getAdapterPosition());

                //Notify the adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);

        //Pembayaran
        ttotal = findViewById(R.id.total);

        //terima data
        Intent terima = getIntent();
        String Total = terima.getStringExtra("total");
        ttotal.setText(Total);

        findViewById(R.id.total).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent g = new Intent(MainActivity.this, Pembayaran.class);
                g.putExtra("bayar",Total);
                startActivity(g);
            }
        });

    }
    private void initializeData() {
        //Get the resources from the XML file
        String[] sportsList = getResources().getStringArray(R.array.titles);
        String[] sportsInfo = getResources().getStringArray(R.array.harga);
        String[] sportsDes = getResources().getStringArray(R.array.des);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.images);
        //Clear the existing data (to avoid duplication)
        mDashboarsData.clear();


        //Create the ArrayList of Sports objects with the titles, images
        // and information about each sport
        for(int i=0; i<sportsList.length; i++){
            mDashboarsData.add(new Dashboard(sportsList[i], sportsInfo[i], sportsDes[i],
                    sportsImageResources.getResourceId(i,0)));
        }

        //Recycle the typed array
        sportsImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

    public void resetSports(View view) {
        initializeData();
    }




    //menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.o
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_keluar) {
            Preferences.clearLoggedInUser(getBaseContext());
            Intent i = new Intent(MainActivity.this,Login.class);
            startActivity(i);
            return true;
        }else if(id == R.id.action_akun){
            Intent i = new Intent(MainActivity.this,Akun.class);
            startActivity(i);
            return true;
        }else if(id == R.id.callCenter){
            return true;
        }else if(id == R.id.smsCenter){
            return true;
        }else if(id == R.id.lokasi){
            displayMap();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayMap() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        // Using the coordinates for Google headquarters.
        String data = getString(R.string.google_mtv_coord_zoom12);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

