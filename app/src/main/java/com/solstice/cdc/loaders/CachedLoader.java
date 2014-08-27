package com.solstice.cdc.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class CachedLoader<T> extends AsyncTaskLoader<T> {

    // TODO : CachedLoader base implementation. All you, Fola :)
    private T mResult;


    public CachedLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading(){
        if(mResult !=null) {
            //if we currently have a result available, deliver it
            deliverResult(mResult);
        }
        if(takeContentChanged() || mResult == null){
            //if the data has changed since the last time it load
            //or is not currently available, start load.
            forceLoad();
        }
    }
    @Override
    protected void onStopLoading(){
        //Attempt to cancel the current load task if possible
        cancelLoad();
    }

    @Override
    protected void onReset(){
        super.onReset();

        onStartLoading();
        mResult = null;
    }

    @Override
    public void deliverResult(T data){
        mResult = data;
        if(isStarted()){
            //if the Loader is currently started, we can immediately
            //deliver its results
            super.deliverResult(data);
        }
    }


    @Override
    public T loadInBackground() {
        return null;
    }
}
