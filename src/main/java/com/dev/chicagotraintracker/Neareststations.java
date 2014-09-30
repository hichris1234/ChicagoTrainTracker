package com.dev.chicagotraintracker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class Neareststations extends Activity{
	LocationManager mLocationManager;
	LocationListener locationListener;
	
    ListView lv;
	Map<Double, String> distanceMap = new TreeMap<Double, String>();
    final DatabaseHelper db = new DatabaseHelper(this);
    static int mili = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neareststations);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		lv = (ListView) findViewById(R.id.stationslv);
		
        final ProgressDialog progress;
        progress = ProgressDialog.show(this, "Loading Nearest Stations", "Getting your location", true);
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		// Define a listener that responds to location updates
		locationListener = new LocationListener() {
			public void onLocationChanged(Location location) {
                getLocationInformation(location);
				progress.dismiss();
				mLocationManager.removeUpdates(locationListener);
				Neareststations.this.takeItBack(null);
			}

			public void onStatusChanged(String provider, int status, Bundle extras) {}

			public void onProviderEnabled(String provider) {}

			public void onProviderDisabled(String provider) {}
		};

		Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if(location != null && location.getTime() > Calendar.getInstance().getTimeInMillis() - 2 * 60 * 1000) {
            getLocationInformation(location);
			progress.dismiss();
			this.takeItBack(null);
		}
		else {
			mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 70, locationListener);
			Log.i("MYTAG", String.valueOf(location));
		}
	}   
	
	public void takeItBack(String result) {
		Log.i("Take it back", "worked");
        ArrayList<CustomObject> objects = new ArrayList<CustomObject>();
        int num = 1;
        for(Map.Entry<Double, String> entry : distanceMap.entrySet()){
        	if(num < 11)
        	    objects.add(new CustomObject(entry.getValue(), null, entry.getKey().toString()));
        	num++;
        }
   	    CustomListViewAdapter customAdapter = new CustomListViewAdapter(this, objects);
   	    lv.setAdapter(customAdapter);
   	    customAdapter.notifyDataSetChanged();
    }

    public void getLocationInformation(Location location) {
        String[] id = {"Lat, Lon, StationName"};
        String query = null;
        Cursor station = db.executeQuery(id, query);

        distanceMap.clear();

        for (station.moveToFirst(); !station.isAfterLast(); station.moveToNext()) {
            double distance = 0;
            double lat_end = 0;
            double lon_end = 0;

            try {
                lat_end = Double.parseDouble(station.getString(station.getColumnIndex("Lat")));
                lon_end = Double.parseDouble(station.getString(station.getColumnIndex("Lon")));
            } catch (NumberFormatException e) {
                Log.v("Main", "Convert to Double Failed : ");
            }

            Location locationTo = new Location("point B");
            locationTo.setLatitude(lat_end);
            locationTo.setLongitude(lon_end);

            distance = location.distanceTo(locationTo) * 0.000621371192237334;
            distance = (double)Math.round(distance * 100) / 100;
            distanceMap.put(distance, station.getString(station.getColumnIndex("StationName")));
        }

        Log.i("distanceMap", String.valueOf(distanceMap));
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.neareststations, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
        mLocationManager.removeUpdates(locationListener);
	}
}
