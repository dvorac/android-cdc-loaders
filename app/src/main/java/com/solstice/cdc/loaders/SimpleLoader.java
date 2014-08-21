package com.solstice.cdc.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by dustinvorac on 8/16/14.
 */
public class SimpleLoader<D> extends AsyncTaskLoader<D> {

    public SimpleLoader(Context context) {
        super(context);
    }

    @Override
    public D loadInBackground() {
        /**
         * Load your data here.
         */
        return null;
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
