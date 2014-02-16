package com.dev.chicagotraintracker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class StationList extends Activity {

	 String selectedValue;
	 String value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_station_list);
		
		final Spinner Spinner1 = (Spinner) findViewById(R.id.spinner1);
		final Spinner Spinner2 = (Spinner) findViewById(R.id.spinner2);
		final String Red_Line = this.getString(R.string.Red_Line);
		final String Blue_Line = this.getString(R.string.Blue_Line);
		final String Green_Line = this.getString(R.string.Green_Line);
		final String Orange_Line = this.getString(R.string.Orange_Line);
		final String Brown_Line = this.getString(R.string.Brown_Line);
		final String Pink_Line = this.getString(R.string.Pink_Line);
		final String Purple_Line = this.getString(R.string.Purple_Line);
		final String Yellow_Line = this.getString(R.string.Yellow_Line);
		TextView tv0 = (TextView) findViewById(R.id.tv0);
	    final TextView tv11 = (TextView) findViewById(R.id.tv11); 
	    final TextView tv12 = (TextView) findViewById(R.id.tv12);  
	    
	    tv0.setText(String.valueOf (Red_Line));
		
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			
	        public void onItemSelected(AdapterView<?> arg0, View arg1,
	                int arg2, long arg3) {
	        	Spinner2.setAdapter(null);
	        	
	        	List<String> RedLin = Arrays.asList(getResources().getStringArray(R.array.Red_Line));
	        	List<String> BlueLin = Arrays.asList(getResources().getStringArray(R.array.Blue_Line));
	        	List<String> GreenLin = Arrays.asList(getResources().getStringArray(R.array.Green_Line));
	        	List<String> OrangeLin = Arrays.asList(getResources().getStringArray(R.array.Orange_Line));
	        	List<String> BrownLin = Arrays.asList(getResources().getStringArray(R.array.Brown_Line));
	        	List<String> PinkLin = Arrays.asList(getResources().getStringArray(R.array.Pink_Line));
	        	List<String> PurpleLin = Arrays.asList(getResources().getStringArray(R.array.Purple_Line));
	        	List<String> YellowLin = Arrays.asList(getResources().getStringArray(R.array.Yellow_Line));
	    	  
	                selectedValue = arg0.getItemAtPosition(arg2).toString();
	                tv11.setText(String.valueOf (selectedValue));
	                if(selectedValue.equals(Red_Line))
	                {
	                    ArrayAdapter<String> firstAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,RedLin);
	                    Spinner2.setAdapter(firstAdapter);
	                }

	                else if(selectedValue.equals(Blue_Line))
	               {
	                	ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,BlueLin);
	                  Spinner2.setAdapter(SecondAdapter);
		        }
	                else if(selectedValue.equals(Green_Line))
		               {
		                  ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,GreenLin);
		                  Spinner2.setAdapter(SecondAdapter);
			        }
	                else if(selectedValue.equals(Orange_Line))
		               {
		                  ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,OrangeLin);
		                  Spinner2.setAdapter(SecondAdapter);
			        }
	                else if(selectedValue.equals(Brown_Line))
		               {
		                  ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,BrownLin);
		                  Spinner2.setAdapter(SecondAdapter);
			        }
	                else if(selectedValue.equals(Pink_Line))
		               {
		                  ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,PinkLin);
		                  Spinner2.setAdapter(SecondAdapter);
			        }
	                else if(selectedValue.equals(Purple_Line))
		               {
		                  ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,PurpleLin);
		                  Spinner2.setAdapter(SecondAdapter);
			        }
	                else if(selectedValue.equals(Yellow_Line))
		               {
		                  ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,YellowLin);
		                  Spinner2.setAdapter(SecondAdapter);
			        }
		    }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		Spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
		       
	        public void onItemSelected(AdapterView<?> arg0, View arg1,
	                int arg2, long arg3) {
	        	
	        	String[] Red_Li = getResources().getStringArray(R.array.Red_Line);
                String[] Red_ID = getResources().getStringArray(R.array.Red_ID);
	        	String[] Blue_Li = getResources().getStringArray(R.array.Blue_Line);
                String[] Blue_ID = getResources().getStringArray(R.array.Blue_ID);
	        	String[] Green_Li = getResources().getStringArray(R.array.Green_Line);
                String[] Green_ID = getResources().getStringArray(R.array.Green_ID);
	        	String[] Orange_Li = getResources().getStringArray(R.array.Orange_Line);
                String[] Orange_ID = getResources().getStringArray(R.array.Orange_ID);
	        	String[] Brown_Li = getResources().getStringArray(R.array.Brown_Line);
                String[] Brown_ID = getResources().getStringArray(R.array.Brown_ID);
	        	String[] Pink_Li = getResources().getStringArray(R.array.Pink_Line);
                String[] Pink_ID = getResources().getStringArray(R.array.Pink_ID);
	        	String[] Purple_Li = getResources().getStringArray(R.array.Purple_Line);
                String[] Purple_ID = getResources().getStringArray(R.array.Purple_ID);
                String[] Yellow_Li = getResources().getStringArray(R.array.Yellow_Line);
                String[] Yellow_ID = getResources().getStringArray(R.array.Yellow_ID);

	                String selectedValue1 = arg0.getItemAtPosition(arg2).toString();
	                
	                if(selectedValue.equals(Red_Line))
		               {
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Red_Li.length; i++) {
		                    myMap.put(Red_Li[i], Red_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));

			        }
	                else if(selectedValue.equals(Blue_Line))
		               {
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Blue_Li.length; i++) {
		                    myMap.put(Blue_Li[i], Blue_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));

			        }
	                else if(selectedValue.equals(Green_Line))
		               {
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Green_Li.length; i++) {
		                    myMap.put(Green_Li[i], Green_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));

			        }
	                else if(selectedValue.equals(Orange_Line))
		               {
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Orange_Li.length; i++) {
		                    myMap.put(Orange_Li[i], Orange_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));
			        }
	                else if(selectedValue.equals(Brown_Line))
		               {
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Brown_Li.length; i++) {
		                    myMap.put(Brown_Li[i], Brown_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));
			        }
	                else if(selectedValue.equals(Pink_Line))
		               {
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Pink_Li.length; i++) {
		                    myMap.put(Pink_Li[i], Pink_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));

			        }
	                else if(selectedValue.equals(Purple_Line))
		               {
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Purple_Li.length; i++) {
		                    myMap.put(Purple_Li[i], Purple_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));

			        }
	                else if(selectedValue.equals(Yellow_Line))
		               {
	                	
		                Map<String, String> myMap = new HashMap<String, String>();
		                for (int i = 0; i < Yellow_Li.length; i++) {
		                    myMap.put(Yellow_Li[i], Yellow_ID[i]);
		               }

		                value = myMap.get(selectedValue1);
		                tv12.setText(String.valueOf (value));

			        }        
		    }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_station_list, menu);
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
	
    public void sendTest(View a) {
        Intent Intent9 = new Intent(StationList.this, TestStation.class);
        Intent9.putExtra("value", value);
        startActivityForResult(Intent9, 0); 
    }

	}
	

