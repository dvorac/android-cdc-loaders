package com.solstice.cdc.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class AutoRefreshLoader<T> extends AsyncTaskLoader<T> {
    public AutoRefreshLoader(Context context) {
        super(context);
    }

    @Override
    public T loadInBackground() {
        return null;
    }
}
