package com.aedwards.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by aaron on 24/08/2014.
 */
public class ForecastFragment extends Fragment{

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
