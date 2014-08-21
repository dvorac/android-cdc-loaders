package com.solstice.cdc.loaders.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.solstice.cdc.loaders.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, new SimpleLoaderFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_simple:
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new SimpleLoaderFragment())
                        .commit();
                break;
            case R.id.action_cached:
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new CachedLoaderFragment())
                        .commit();
                break;
            case R.id.action_autorefresh:
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new AutoRefreshLoaderFragment())
                        .commit();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
