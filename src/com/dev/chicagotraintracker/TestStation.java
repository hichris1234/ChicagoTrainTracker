package com.dev.chicagotraintracker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.R.string;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class TestStation extends Activity {
	String URL = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=201412abc85d49b2b83f907f9e329eaa&mapid=40380";
	private Elements elem;
    @SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
            setContentView(R.layout.test_station);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); 
    
           
            
    Document doc = null;
    
    TextView tv = (TextView) findViewById(R.id.tv);
    TextView tv1 = (TextView) findViewById(R.id.tv1);
    TextView tv2 = (TextView) findViewById(R.id.tv2);
    TextView tv3 = (TextView) findViewById(R.id.tv3);
    TextView tv4 = (TextView) findViewById(R.id.tv4);
    TextView tv5 = (TextView) findViewById(R.id.tv5);
    TextView tv6 = (TextView) findViewById(R.id.tv6);
    TextView tv7 = (TextView) findViewById(R.id.tv7);
    TextView tv8 = (TextView) findViewById(R.id.tv8);
    TextView tv9 = (TextView) findViewById(R.id.tv9);
    		 
	try {
	    doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Elements elem = doc.select("eta"); 
	Iterator<Element> iterator = elem.iterator();
	while(iterator.hasNext())
	{ Element div = iterator.next();
    	
    Elements arrT = div.select("arrT");
    Elements prdt = div.select("prdt");
    Elements staNm = div.select("staNm");
    String StaNm = staNm.text();
    tv1.setText(String.valueOf (StaNm));
      

	while(iterator.hasNext())
	{ Element div1 = iterator.next();
    	
    Elements arrT1 = div1.select("arrT");
    Elements prdt1 = div1.select("prdt");
    Elements staNm1 = div1.select("staNm");
    String StaNm1 = staNm1.text();
    tv2.setText(String.valueOf (StaNm1));
    
    while(iterator.hasNext())
	{ Element div2 = iterator.next();
    	
    Elements arrT2 = div2.select("arrT");
    Elements prdt2 = div2.select("prdt");
    Elements staNm2 = div2.select("staNm");
    String StaNm2 = staNm2.text();
    tv4.setText(String.valueOf (StaNm2));
    

    try {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date1 = sdf.parse(arrT.text());
		Date date2 = sdf.parse(prdt.text());
		Date date3 = sdf.parse(arrT1.text());
		Date date4 = sdf.parse(prdt1.text());
		Date date5 = sdf.parse(arrT2.text());
		Date date6 = sdf.parse(prdt2.text());
		
		long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
		long dateDiff1 = (date3.getTime() - date4.getTime())>0 ? (date3.getTime() - date4.getTime()) :(date4.getTime() - date3.getTime());
		long dateDiff2 = (date5.getTime() - date6.getTime())>0 ? (date5.getTime() - date6.getTime()) :(date6.getTime() - date5.getTime());
	    SimpleDateFormat sdf1 = new SimpleDateFormat("mm:00");
	    String dateDif = sdf1.format(dateDiff);
	    String dateDif1 = sdf1.format(dateDiff1);
	    String dateDif2 = sdf1.format(dateDiff2);
	    tv.setText(String.valueOf (dateDif));
	    tv3.setText(String.valueOf (dateDif1));
	    tv5.setText(String.valueOf (dateDif2));

	    
	    }
		
    catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
		
		
	 }
    
	}
	}
	}
    }
	

    
	
    

    

	
	
	
	
    
    	

    
    
















	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_station, menu);
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
    startActivity(new Intent(TestStation.this, StationList.class));
    finish();
}
}
