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

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class Neareststations extends Activity implements LocationListener {
	LocationManager mLocationManager;
	
    double longitude;
    double latitude;
	
	String distancea;
	String distance1;
    static Map<String, String> myMap1 = new HashMap<String, String>();
    
    static ArrayList<Double> distancetos = new ArrayList<Double>();
	
	@SuppressLint("NewApi")
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neareststations);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
        List<String> Lat1 = Arrays.asList(getResources().getStringArray(R.array.Latitude));
        Log.i("Lat1", String.valueOf(Lat1.get(0)));
        
        String[] Stations = getResources().getStringArray(R.array.Stations);
        String[] Longitude = getResources().getStringArray(R.array.Longitude);
        
        for (int h = 0; h <144; h++) {
        	myMap1.put(Stations[h], Longitude[h]);

        }

	

	        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

	        Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            longitude = location.getLongitude();
	        latitude = location.getLatitude();
	        if(location != null && location.getTime() > Calendar.getInstance().getTimeInMillis() - 2 * 60 * 1000) {
	    	    {

	        }
	        }
	        else {
	            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5, 50, this);
	            Log.i("MYTAG", String.valueOf(location));
	        }
	        
	    	longitude = location.getLongitude();
	        latitude = location.getLatitude();
	        if (location != null) {
	        	
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
    	        
    	        while(iterator.hasNext()){
    	        for (int i=0; i<144;i++){
    	        
    	        double distance = 0;  

    	        double lat_end = 0;
    	        double lon_end = 0;
    	        

    	        try {
    	            lat_end = Double.parseDouble(iterator.next());
    	            lon_end = Double.parseDouble(iterator1.next());
    	            longitudeArray.add((lon_end));
    	            Log.i("Lon_end", String.valueOf(lon_end));

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
    	        Log.i("distancebefore", String.valueOf(distance));
    	        
    	        String dista = Double.toString(distance);


    	        distancetos.add(Double.parseDouble(dista));
    		    }
    	        }
    	        
    	            
    	            Collections.sort(distancetos);
    	            
    	            distancea = distancetos.get(0).toString();
    	            distance1 = distancetos.get(1).toString();
    	            
    	            String Longa = longitudeArray.get(0).toString();
    	            String Long1 = longitudeArray.get(1).toString();

    	            
    	            Log.i("distanceafter", String.valueOf(distancea));
    	            Log.i("distance1after", String.valueOf(distance1));
    	            
    			
    	        String[] Stations1 = getResources().getStringArray(R.array.Stations);
    	        String[] Longitude1 = getResources().getStringArray(R.array.Longitude);
    	        String[] Latitude = getResources().getStringArray(R.array.Latitude);
    	        
    	    

    	        Map<String, String> myMap = new HashMap<String, String>();{
    	        for (int i = 0; i <144; i++) {
    	        	myMap.put(Latitude[i], Stations1[i]);
    	        }
    	        }
    		    
    	        Map<String, String> myMap1 = new HashMap<String, String>();{
    	        for (int h = 0; h <144; h++) {
    	        	myMap1.put(Longitude1[h], Stations1[h]);

    	        }
    	        }
    	        
    	        String value = myMap1.get(Longa);
    	        
    	        GenericCachedSorter sort = new GenericCachedSorter();
    	        sort.SortingHere();
    	        
	            Log.i("Longa", String.valueOf(Longa));
	            Log.i("Longa", String.valueOf(myMap1));
	            Log.i("value", String.valueOf(value));
        	Log.i("MYTAG", String.valueOf(location));
        	Log.i("MYTAG", String.valueOf(longitude));
        	Log.i("MYTAG", String.valueOf(latitude));
        }
        }
	
	    public void onLocationChanged(Location location) {
	    }
	        	

	    public void onProviderDisabled(String arg0) {}
	    public void onProviderEnabled(String arg0) {}
	    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {}
	    
	    

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

	public static class GenericCachedSorter {
		public void SortingHere() {
	        sort(distancetos, new ToComparable<Double, Double>() {
	            @Override
	            public Double toComparable(Double distance) {
	                // return the longitude associated with this distance
	                return (Double.parseDouble(myMap1.get(distance)));
	            }
	        });

	        for (Double distance : distancetos)
	            System.out.println(distancetos);
	    }
	
	  public interface ToComparable<T, C extends Comparable<? super C>> {
        C toComparable(T t);
      }

	    public static <T, C extends Comparable<? super C>> void sort(List<T> list, ToComparable<T, C> function) {
	       class Pair implements Comparable<Pair> {
	          final T original;
	          final C comparable;

	          Pair(T original, C comparable) {
	             this.original = original;
	             this.comparable = comparable;
	          }

	          @Override
	          public int compareTo(Pair other) {
	                return
	                  comparable == null && other.comparable == null ? 0 :
	                  comparable == null ? -1 :
	                  other.comparable == null ? 1 :
	                  comparable.compareTo(other.comparable);
	          }
	       }

	       List<Pair> pairs = new ArrayList<Pair>(list.size());
	       for (T original : list)
	          pairs.add(new Pair(original, function.toComparable(original)));

	       Collections.sort(pairs);

	       ListIterator<T> iter = list.listIterator();
	       for (Pair pair : pairs) {
	          iter.next();
	          iter.set(pair.original);
	       }
	    }
	}
}
