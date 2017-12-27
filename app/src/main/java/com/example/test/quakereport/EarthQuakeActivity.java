package com.example.test.quakereport;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.os.AsyncTask;
import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {


    private static final String LOG_TAG = EarthQuakeActivity.class.getName();
    /** URL to query the USGS dataset for earthquake information */
    private static final String USGS_REQUEST_URL =

            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);

        earthquakeTask task = new earthquakeTask();
        task.execute(USGS_REQUEST_URL);

    }

     private void updateUi(ArrayList<container> earthquake) {
         ArrayList<container> earthquakes=QueryUtils.extractEarthquakes(USGS_REQUEST_URL);

         // Find a reference to the {@link ListView} in the layout
         ListView earthquakeListView = (ListView) findViewById(R.id.list);

         // Create a new {@link ArrayAdapter} of earthquakes
         customadapter adapter = new customadapter(this, earthquakes);

         // Set the adapter on the {@link ListView}
         // so the list can be populated in the user interface
         earthquakeListView.setAdapter(adapter);
     }

    private class earthquakeTask  extends AsyncTask<String , Void, ArrayList<container>>{

        protected ArrayList<container> doInBackground(String... urls) {
            ArrayList<container> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;
        }

        protected void onPostExecute(ArrayList<container> result) {
            updateUi(result);
        }

    }


}
