package com.solstice.cdc.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class CachedLoader<T> extends AsyncTaskLoader<T> {

    // TODO : CachedLoader base implementation. All you, Fola :)

    public CachedLoader(Context context) {
        super(context);
    }

    @Override
    public T loadInBackground() {
        return null;
    }
}
