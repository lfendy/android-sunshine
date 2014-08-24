package com.aedwards.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by aaron on 24/08/2014.
 */
public class ForecastFragment extends Fragment{

    private ArrayAdapter<String> weekAdaptor;

    public ForecastFragment(){

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragmentforecast, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View rootView = inflater.inflate(R.layout.fragment_sunshine, container, false);

        weekAdaptor = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                new ArrayList<String>());

        ListView textViewForecast = (ListView)rootView.findViewById(R.id.listView_forecast);
        textViewForecast.setAdapter(weekAdaptor);

        new FetchWeatherTask(weekAdaptor).execute("Melbourne");

        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_refresh:
                new FetchWeatherTask(weekAdaptor).execute("Melbourne");
        }

        return super.onOptionsItemSelected(item);
    }
}
