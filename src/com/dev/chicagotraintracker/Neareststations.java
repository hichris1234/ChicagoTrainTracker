package com.dev.chicagotraintracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class Neareststations extends Activity{
	LocationManager mLocationManager;
	
    double longitude;
    double latitude;
	
	String distancea;
    ListView lv;
    static ArrayList<Double> distancetos = new ArrayList<Double>();
    
    String station;
    String second;
    String distance;   
    String station1;
    String distance1;
    String station2;
    String distance2;
    String station3;
    String distance3;
    String station4;
    String distance4;
    String station5;
    String distance5;
    String station6;
    String distance6;
    String station7;
    String distance7;
    String station8;
    String distance8;
    String station9;
    String distance9;
    
	
	@SuppressLint("NewApi")
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neareststations);
		// Show the Up button in the action bar.
		lv = (ListView) findViewById(R.id.stationslv);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
        final ProgressDialog progress;
        progress = ProgressDialog.show(this, "Loading Nearest Stations", "Getting your location", true);
	        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

	        // Define a listener that responds to location updates
	        LocationListener locationListener = new LocationListener() {
	            public void onLocationChanged(Location location) {
		        	longitude = location.getLongitude();
			        latitude = location.getLatitude();
			        	
				        longitude = location.getLongitude();
				        latitude = location.getLatitude();
			        	Log.i("MYTAG", String.valueOf(longitude));
			        	Log.i("MYTAG", String.valueOf(latitude));

		    	        
		    	        List<String> Long = Arrays.asList(getResources().getStringArray(R.array.Longitude));
		    	        List<String> Lat = Arrays.asList(getResources().getStringArray(R.array.Latitude));
		    	        
		    	        Log.i("Long1", String.valueOf(Long.get(0)));
		    	       
		    	        Iterator<String> iterator = Lat.iterator();
		    	        Iterator<String> iterator1 = Long.iterator();

		    	        ArrayList<Double> longitudeArray = new ArrayList<Double>();
		    	        distancetos.clear();
		    	        while(iterator.hasNext()){
		    	        for (int i=0; i<144;i++){
		    	        
		    	        double distance = 0;  

		    	        double lat_end = 0;
		    	        double lon_end = 0;
		    	        

		    	        try {
		    	            lat_end = Double.parseDouble(iterator.next());
		    	            lon_end = Double.parseDouble(iterator1.next());
		    	            longitudeArray.add((lon_end));
		    	        } catch (NumberFormatException e) {
		    	            Log.v("Main", "Convert to Double Failed : ");
		    	        }

		    	        Location locationA = new Location("point A");  
		    	        locationA.setLatitude(latitude);  
		    	        locationA.setLongitude(longitude);  

		    	        Location locationB = new Location("point B");  
		    	        locationB.setLatitude(lat_end);  
		    	        locationB.setLongitude(lon_end);  

		    	        distance = locationA.distanceTo(locationB) * 0.000621371192237334;
		    	        String dista = Double.toString(distance);
		    	        distancetos.add(Double.parseDouble(dista));
		    		    }
		    	        }
		    	            Collections.sort(distancetos);
		    	            
		    	            distancea = distancetos.get(0).toString();
		    	            
		    	            String Longa = longitudeArray.get(0).toString();
		    	            String Long1 = longitudeArray.get(1).toString();
		
		    	        String[] Stations1 = getResources().getStringArray(R.array.Stations);
		    	        String[] Longitude1 = getResources().getStringArray(R.array.Longitude);
		    	        String[] Latitude = getResources().getStringArray(R.array.Latitude);
		    	        
		    	    

		    	        Map<String, String> myMap = new TreeMap<String, String>();{
		    	        for (int i = 0; i <144; i++) {
		    	        	myMap.put(Latitude[i], Stations1[i]);
		    	        }
		    	        }
		    		    
		    	        int h = 0;
		    	        Map<Double, String> myMap1 = new TreeMap<Double, String>();{
		    	        for (Double distance : distancetos){
		    	            h = h + 1;
		    	            if (h != 144)
		    	        	myMap1.put(distance, Stations1[h]);
		    	        }
		    	        }
		    	        
		    	        String value = String.valueOf(myMap1.keySet().toArray()[0]); 
		    	        station = String.valueOf(myMap1.values().toArray()[0]);
		    	        second = null;
		    	        distance = value; 
		    	        station1 = String.valueOf(myMap1.values().toArray()[1]);
		    	        distance1 = String.valueOf(myMap1.keySet().toArray()[1]);
		    	        station2 = String.valueOf(myMap1.values().toArray()[2]);
		    	        distance2 = String.valueOf(myMap1.keySet().toArray()[2]);
		    	        station3 = String.valueOf(myMap1.values().toArray()[3]);
		    	        distance3 = String.valueOf(myMap1.keySet().toArray()[3]);
		    	        station4 = String.valueOf(myMap1.values().toArray()[4]);
		    	        distance4 = String.valueOf(myMap1.keySet().toArray()[4]);
		    	        station5 = String.valueOf(myMap1.values().toArray()[5]);
		    	        distance5 = String.valueOf(myMap1.keySet().toArray()[5]);
		    	        station6 = String.valueOf(myMap1.values().toArray()[6]);
		    	        distance6 = String.valueOf(myMap1.keySet().toArray()[6]);
		    	        station7 = String.valueOf(myMap1.values().toArray()[7]);
		    	        distance7 = String.valueOf(myMap1.keySet().toArray()[7]);
		    	        station8 = String.valueOf(myMap1.values().toArray()[8]);
		    	        distance8 = String.valueOf(myMap1.keySet().toArray()[8]);
		    	        station9 = String.valueOf(myMap1.values().toArray()[9]);
		    	        distance9 = String.valueOf(myMap1.keySet().toArray()[9]);
		    	        
			            Log.i("Longa", String.valueOf(Longa));
			            Log.i("Longa", String.valueOf(myMap1));
			            Log.i("value", String.valueOf(value));
			            progress.dismiss();
			        Neareststations.this.takeItBack(null);
	            }

	            public void onStatusChanged(String provider, int status, Bundle extras) {}

	            public void onProviderEnabled(String provider) {}

	            public void onProviderDisabled(String provider) {}
	          };

	        Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	        if(location != null && location.getTime() > Calendar.getInstance().getTimeInMillis() - 2 * 60 * 1000) {
	        	longitude = location.getLongitude();
		        latitude = location.getLatitude();
		        	
			        longitude = location.getLongitude();
			        latitude = location.getLatitude();
		        	Log.i("MYTAG", String.valueOf(longitude));
		        	Log.i("MYTAG", String.valueOf(latitude));
	    	        
	    	        List<String> Long = Arrays.asList(getResources().getStringArray(R.array.Longitude));
	    	        List<String> Lat = Arrays.asList(getResources().getStringArray(R.array.Latitude));
	    	        
	    	        Log.i("Long1", String.valueOf(Long.get(0)));
	    	       
	    	        Iterator<String> iterator = Lat.iterator();
	    	        Iterator<String> iterator1 = Long.iterator();
	    	        ArrayList<Double> longitudeArray = new ArrayList<Double>();
	    	        distancetos.clear();
	    	        
	    	        while(iterator.hasNext()){
	    	        for (int i=0; i<144;i++){
	    	        
	    	        double distance = 0;  
	    	        double lat_end = 0;
	    	        double lon_end = 0;

	    	        try {
	    	            lat_end = Double.parseDouble(iterator.next());
	    	            lon_end = Double.parseDouble(iterator1.next());
	    	            longitudeArray.add((lon_end));
	    	        } catch (NumberFormatException e) {
	    	            Log.v("Main", "Convert to Double Failed : ");
	    	        }

	    	        Location locationA = new Location("point A");  
	    	        locationA.setLatitude(latitude);  
	    	        locationA.setLongitude(longitude);  

	    	        Location locationB = new Location("point B");  
	    	        locationB.setLatitude(lat_end);  
	    	        locationB.setLongitude(lon_end);  

	    	        distance = locationA.distanceTo(locationB) * 0.000621371192237334;
	    	        String dista = Double.toString(distance);
	    	        distancetos.add(Double.parseDouble(dista));
	    		    }
	    	        }
	    	            Collections.sort(distancetos);
	    	            distancea = distancetos.get(0).toString();
	    	            
	    	            String Longa = longitudeArray.get(0).toString();
	
	    	        String[] Stations1 = getResources().getStringArray(R.array.Stations);
	    	        String[] Longitude1 = getResources().getStringArray(R.array.Longitude);
	    	        String[] Latitude = getResources().getStringArray(R.array.Latitude);

	    	        Map<String, String> myMap = new TreeMap<String, String>();{
	    	        for (int i = 0; i <144; i++) {
	    	        	myMap.put(Latitude[i], Stations1[i]);
	    	        }
	    	        }
	    		    
	    	        int h = 0;
	    	        Map<Double, String> myMap1 = new TreeMap<Double, String>();{
	    	        for (Double distance : distancetos){
	    	            h = h + 1;
	    	            if (h != 144)
	    	        	myMap1.put(distance, Stations1[h]);
	    	        }
	    	        }
	    	        
	    	        String value = String.valueOf(myMap1.keySet().toArray()[0]); 
	    	        station = String.valueOf(myMap1.values().toArray()[0]);
	    	        distance = value;
	    	        station1 = String.valueOf(myMap1.values().toArray()[1]);
	    	        distance1 = String.valueOf(myMap1.keySet().toArray()[1]);
	    	        station2 = String.valueOf(myMap1.values().toArray()[2]);
	    	        distance2 = String.valueOf(myMap1.keySet().toArray()[2]);
	    	        station3 = String.valueOf(myMap1.values().toArray()[3]);
	    	        distance3 = String.valueOf(myMap1.keySet().toArray()[3]);
	    	        station4 = String.valueOf(myMap1.values().toArray()[4]);
	    	        distance4 = String.valueOf(myMap1.keySet().toArray()[4]);
	    	        station5 = String.valueOf(myMap1.values().toArray()[5]);
	    	        distance5 = String.valueOf(myMap1.keySet().toArray()[5]);
	    	        station6 = String.valueOf(myMap1.values().toArray()[6]);
	    	        distance6 = String.valueOf(myMap1.keySet().toArray()[6]);
	    	        station7 = String.valueOf(myMap1.values().toArray()[7]);
	    	        distance7 = String.valueOf(myMap1.keySet().toArray()[7]);
	    	        station8 = String.valueOf(myMap1.values().toArray()[8]);
	    	        distance8 = String.valueOf(myMap1.keySet().toArray()[8]);
	    	        station9 = String.valueOf(myMap1.values().toArray()[9]);
	    	        distance9 = String.valueOf(myMap1.keySet().toArray()[9]);
	    	        
		            Log.i("Longa", String.valueOf(Longa));
		            Log.i("Longa", String.valueOf(myMap1));
		            Log.i("value", String.valueOf(value));
		            progress.dismiss();
		            this.takeItBack(null);
	        }
	        else {
	            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5, 50, locationListener);
	            Log.i("MYTAG", String.valueOf(location));
	        }
        }   
	
	public void takeItBack(String result) {
		Log.i("Take it back", "worked");
        ArrayList<CustomObject> objects = new ArrayList<CustomObject>();
   	    objects.add(new CustomObject(station, second, distance));
   	    objects.add(new CustomObject(station1, second, distance1));
   	    objects.add(new CustomObject(station2, second, distance2));
   	    objects.add(new CustomObject(station3, second, distance3));
   	    objects.add(new CustomObject(station4, second, distance4));
   	    objects.add(new CustomObject(station5, second, distance5));
   	    objects.add(new CustomObject(station6, second, distance6));
   	    objects.add(new CustomObject(station7, second, distance7));
   	    objects.add(new CustomObject(station8, second, distance8));
   	    objects.add(new CustomObject(station9, second, distance9));
   	    CustomListViewAdapter customAdapter = new CustomListViewAdapter(this, objects);
   	    lv.setAdapter(customAdapter);
   	    customAdapter.notifyDataSetChanged();
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
}
