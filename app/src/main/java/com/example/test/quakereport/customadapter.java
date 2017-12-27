package com.example.test.quakereport;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class customadapter extends ArrayAdapter<container> {

private static final String LOG_TAG=customadapter.class.getSimpleName();



    public customadapter(Context context,ArrayList<container> earthquakes){
        super(context,0,earthquakes);
        }
/**
 * Handles playback of all the sound files
 */
@Override
public View getView(int position,View convertView,ViewGroup parent){
        View listItemView=convertView;
        if(listItemView==null) listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.activity_earth_quake, parent, false);

        container currentAndroidFlavor=getItem(position);


        //name of locationcatiom

        TextView miwokTextView=(TextView)listItemView.findViewById(R.id.locationname);
        String array[]=currentAndroidFlavor.getlocation().split(",");


        miwokTextView.setText(array[0]);
        miwokTextView.setText(array[1]);


        //textview for intensity

            TextView defaultTextView=(TextView)listItemView.findViewById(R.id.intensity);

    // Format the magnitude to show 1 decimal place
    String formattedMagnitude = formatMagnitude(currentAndroidFlavor.getMintensity());
    // Display the magnitude of the current earthquake in that TextView
    defaultTextView.setText(formattedMagnitude);


    Date dateObject = new Date(currentAndroidFlavor.gettime());

    //text view for date
    // Find the TextView with view ID date
             TextView dateView = (TextView) listItemView.findViewById(R.id.date);
    // Format the date string (i.e. "Mar 3, 1984")
         String formattedDate = formatDate(dateObject);
    // Display the date of the current earthquake in that TextView
         dateView.setText(formattedDate);

    // Find the TextView with view ID time
            TextView timeView = (TextView) listItemView.findViewById(R.id.time);
    // Format the time string (i.e. "4:30PM")
            String formattedTime = formatTime(dateObject);
    // Display the time of the current earthquake in that TextView
           timeView.setText(formattedTime);


    return listItemView;


        }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
        }
