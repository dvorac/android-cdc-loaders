package com.solstice.cdc.loaders.app;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.solstice.cdc.loaders.AutoRefreshLoader;
import com.solstice.cdc.loaders.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AutoRefreshLoaderFragment extends ListFragment
    implements LoaderManager.LoaderCallbacks<List<UUID>> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_plus:
                // TODO : add
                break;
            case R.id.action_refresh:
                // TODO : refresh
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public Loader<List<UUID>> onCreateLoader(int i, Bundle bundle) {
        return new AutoRefreshUuidLoader(getActivity());
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

    public static class AutoRefreshUuidLoader extends AutoRefreshLoader<List<UUID>> {

        public AutoRefreshUuidLoader(Context context) {
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
