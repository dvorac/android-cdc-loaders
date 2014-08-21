package com.solstice.cdc.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * all we know about autorefreshloader...
 * how this expands on asynctaskloader...
 * examples where it may be useful...
 * gotchas specific to autorefreshloader...
 * @param <T>
 */
public class AutoRefreshLoader<T> extends AsyncTaskLoader<T> {
    public AutoRefreshLoader(Context context) {
        super(context);
    }

    @Override
    public T loadInBackground() {
        return null;
    }
}
