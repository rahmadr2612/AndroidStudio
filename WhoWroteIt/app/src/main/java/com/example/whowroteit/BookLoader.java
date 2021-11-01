package com.example.whowroteit;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {

    // Variable that stores the search string.
    private String mQueryString;

    // Constructor providing a reference to the search term.
    public BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    /**
     * This method is invoked by the LoaderManager whenever the loader is started
     */
    @Override
    protected void onStartLoading() {
        forceLoad(); // Starts the loadInBackground method
    }

    /**
     * Connects to the network and makes the Books API request on a background thread.
     *
     * @return Returns the raw JSON response from the API call.
     */
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
}
