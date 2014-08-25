package com.solstice.cdc.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Handler;

/**
 * all we know about autorefreshloader...
 * how this expands on asynctaskloader...
 * examples where it may be useful...
 * gotchas specific to autorefreshloader...
 * @param <T>
 */
public class AutoRefreshLoader<T> extends AsyncTaskLoader<T> {

    private T mData;
    private long mInterval;
    private Handler mHandler;

    private final Runnable mTimeoutRunnable = new Runnable() {
        @Override
        public void run() {
            onContentChanged();
        }
    };

    public AutoRefreshLoader(Context context, long interval) {
        super(context);
        mInterval = interval;
        mHandler = new Handler();
    }

    @Override
    protected void onStartLoading() {
        if (mData != null) {
            // deliver result immediately, if available.
            deliverResult(mData);
        }

        if (takeContentChanged() || mData == null) {
            // if data has changed, or isn't available, reload.
            forceLoad();
        }
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        mHandler.removeCallbacks(mTimeoutRunnable);
        mHandler.postDelayed(mTimeoutRunnable, mInterval);
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();

        onStopLoading();
        mData = null;

        mHandler.removeCallbacks(mTimeoutRunnable);
    }

    @Override
    public void onCanceled(T data) {
        super.onCanceled(data);
        onContentChanged();
    }

    @Override
    public void deliverResult(T data) {
        mData = data;

        if (isStarted()) {
            // loader is already running, deliver result.
            super.deliverResult(data);
        }
    }

    @Override
    public T loadInBackground() {
        return null;
    }
}
