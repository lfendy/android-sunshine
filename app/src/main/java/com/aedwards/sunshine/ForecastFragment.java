package com.aedwards.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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

    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View rootView = inflater.inflate(R.layout.fragment_sunshine, container, false);

        weekAdaptor = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                new ArrayList<String>());

        ListView textViewForecast = (ListView)rootView.findViewById(R.id.listView_forecast);
        textViewForecast.setAdapter(weekAdaptor);

        textViewForecast.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, adapterView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
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
