package com.solstice.cdc.loaders.app;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.solstice.cdc.loaders.CachedLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CachedLoaderFragment extends ListFragment
    implements LoaderManager.LoaderCallbacks<List<UUID>> {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<UUID>> onCreateLoader(int i, Bundle bundle) {
        return new CachedUuidLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<UUID>> listLoader, List<UUID> uuids) {
        getListView().setAdapter(new ArrayAdapter<UUID>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                uuids
        ));
        setListShown(true);
    }

    @Override
    public void onLoaderReset(Loader<List<UUID>> listLoader) {
        // not needed yet
    }

    public static class CachedUuidLoader extends CachedLoader<List<UUID>> {
        public CachedUuidLoader(Context context) {
            super(context);
        }

        @Override
        public List<UUID> loadInBackground() {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<UUID> list = new ArrayList<UUID>();
            list.add(UUID.randomUUID());
            list.add(UUID.randomUUID());
            list.add(UUID.randomUUID());
            return list;
        }
    }
}
