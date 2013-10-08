package com.dev.chicagotraintracker;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Delay extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delay);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 
        
        String URL = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=red";
		Document doc = null;
		
	    TextView t = (TextView) findViewById(R.id.t);
	    TextView t1 = (TextView) findViewById(R.id.t1);
	    TextView t2 = (TextView) findViewById(R.id.t2);
	    TextView t3 = (TextView) findViewById(R.id.t3);
	    TextView t4 = (TextView) findViewById(R.id.t4);
	    TextView t5 = (TextView) findViewById(R.id.t5);
       
        
        
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		try {
		    doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements elem1 = doc.select("Alert"); 
		Iterator<Element> iterator = elem1.iterator();
		while(iterator.hasNext())
		{ Element div = iterator.next();
	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Full = div.select("FullDescription");
	    String shorta = Short.text();
	    String fulla = Full.text();
	    t.setText(String.valueOf (shorta));
	    t1.setText(String.valueOf (fulla));
		}
		
		while(iterator.hasNext())
		{ Element div1 = iterator.next();
	    	
		Elements Short1 = div1.select("ShortDescription");
	    Elements Full1 = div1.select("FullDescription");
	    String shorta1 = Short1.text();
	    String fulla1 = Full1.text();
	    t2.setText(String.valueOf (shorta1));
	    t3.setText(String.valueOf (fulla1));
		}
		
		while(iterator.hasNext())
		{ Element div2 = iterator.next();
	    	
		Elements Short2 = div2.select("ShortDescription");
	    Elements Full2 = div2.select("FullDescription");
	    String shorta2 = Short2.text();
	    String fulla2 = Full2.text();
	    t4.setText(String.valueOf (shorta2));
	    t5.setText(String.valueOf (fulla2));
		}
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delay, menu);
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
    startActivity(new Intent(Delay.this, MainActivity.class));
    finish();
}

}
