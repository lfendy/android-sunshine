package com.aedwards.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunshine);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sunshine, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sunshine, container, false);

            ArrayList<String> weekLayout = new ArrayList<String>();
            for(int i = 0; i < 20; i++) {
                weekLayout.add("Today - Sunny 1millionºC");
                weekLayout.add("Tomorrow - Not Sunny 5K");
                weekLayout.add("Some other day 1");
                weekLayout.add("Some other day 2");
                weekLayout.add("Some other day 3");
                weekLayout.add("Some other day 4");
                weekLayout.add("Some other day 5");
                weekLayout.add("Some other day 6");
                weekLayout.add("Some other day 7");
                weekLayout.add("Some other day 8");
                weekLayout.add("Some other day 9");
                weekLayout.add("Some other day 10");
            }

            ArrayAdapter<String> weekAdaptor = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weekLayout);

            ListView textViewForecast = (ListView)rootView.findViewById(R.id.listView_forecast);
            textViewForecast.setAdapter(weekAdaptor);

            return rootView;
        }
    }
}
