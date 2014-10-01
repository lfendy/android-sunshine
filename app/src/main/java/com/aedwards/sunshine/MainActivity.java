package com.aedwards.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(this.getClass().getSimpleName(), "onCREATE madafaka");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunshine);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }

    }

    @Override
    protected void onDestroy() {
        Log.d(this.getClass().getSimpleName(), "onDESTROY madafaka");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.d(this.getClass().getSimpleName(), "onSTOP madafaka");
        super.onStop();
    }

    @Override
    protected void onStart() {
        Log.d(this.getClass().getSimpleName(), "onSTART madafaka");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d(this.getClass().getSimpleName(), "onPAUSE madafaka");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(this.getClass().getSimpleName(), "onRESUME madafaka");
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sunshine, menu);
        return true;
    }

    private String getLocation(){
        return PreferenceManager
                .getDefaultSharedPreferences(this)
                .getString(getString(R.string.pref_key_location), getString(R.string.pref_default_location));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            case R.id.action_view_location:
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                Uri geoLocation = Uri.parse(String.format("geo:0,0?q=%s",getLocation()));
                mapIntent.setData(geoLocation);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
