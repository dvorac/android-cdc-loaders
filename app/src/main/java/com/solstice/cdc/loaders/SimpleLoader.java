package com.solstice.cdc.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class SimpleLoader<T> extends AsyncTaskLoader<T> {

    public SimpleLoader(Context context) {
        super(context);
    }

    @Override
    public T loadInBackground() {
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
