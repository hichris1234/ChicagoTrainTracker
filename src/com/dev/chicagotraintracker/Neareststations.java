package com.dev.chicagotraintracker;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class Neareststations extends Activity implements LocationListener {
	LocationManager mLocationManager;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neareststations);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);

	

	        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

	        Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	        double longitude = location.getLongitude();
	        double latitude = location.getLatitude();
        	Log.i("MYTAG", String.valueOf(longitude));
        	Log.i("MYTAG", String.valueOf(latitude));
	        if(location != null && location.getTime() > Calendar.getInstance().getTimeInMillis() - 2 * 60 * 1000) {
	            // Do something with the recent location if it is less than two minutes old
	        	Log.i("MYTAG", String.valueOf(location));
	        	Log.i("MYTAG", String.valueOf(longitude));
	        	Log.i("MYTAG", String.valueOf(latitude));
	        }
	        else {
	            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5, 50, this);
	            Log.i("MYTAG", String.valueOf(location));
	        }
	    }

	    public void onLocationChanged(Location location) {
	        if (location != null) {
	        // Do something withthe current location
	        	Log.i("MYTAG", String.valueOf(location));
	        	
	        }
	    }

	    public void onProviderDisabled(String arg0) {}
	    public void onProviderEnabled(String arg0) {}
	    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {}
		
        String[] Stations = getResources().getStringArray(R.array.Stations);
        String[] Longitude = getResources().getStringArray(R.array.Longitude);
        String[] Latitude = getResources().getStringArray(R.array.Latitude);
	    
        Map<String, String> myMap = new HashMap<String, String>();{
        for (int i = 0; i <8; i++) {
        	myMap.put(Stations[i], Latitude[i]);
        }
        }
	    
        Map<String, String> myMap1 = new HashMap<String, String>();{
        for (int h = 0; h <8; h++) {
        	myMap1.put(Stations[h], Longitude[h]);
        }
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
	public void onBackPressed()
	{
	    startActivity(new Intent(Neareststations.this, MainActivity.class));
	    finish();
	}


}
