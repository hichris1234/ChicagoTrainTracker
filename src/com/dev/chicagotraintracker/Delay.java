package com.dev.chicagotraintracker;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

import com.dev.chicagotraintracker.TestStation.loadtrains;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Delay extends Activity implements AsyncTaskCallback{
	
	private PullToRefreshAttacher mPullToRefreshAttacher;
	String URL;
	String URL1;
	String URL2;
	String URL3;
	String URL4;
	String URL5;
	String URL6;
	String URL7;
	String URL8;
	Document doc;
	Document doc1;
	Document doc2;
	Document doc3;
	Document doc4;
	Document doc5;
	Document doc6;
	Document doc7;
	Document doc8;
    ArrayList<Elements> Alerts = new ArrayList<Elements>();
	ArrayList<Elements> Names = new ArrayList<Elements>();
	ListView lv;
	
	String Al;
	String Al1;
	String Al2;
	String Al3;
	String Al4;
	String Al5;
	String Al6;
	String Al7;
	String Al8;
	String Al9;
	String Al10;
	String Al11;
	String Al12;
	String Al13;
	String Al14;
	String Al15;
	
	String Na;
	String Na1;
	String Na2;
	String Na3;
	String Na4;
	String Na5;
	String Na6;
	String Na7;
	String Na8;
	String Na9;
	String Na10;
	String Na11;
	String Na12;
	String Na13;
	String Na14;
	String Na15;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delay);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	            lv = (ListView) findViewById(R.id.lv);
	            new loaddelays().execute();
	    }
	
    @Override
    public void takeItBack(String result) {
        ArrayList<CustomObject> objects = new ArrayList<CustomObject>();
       if(Na!=null && !Na.isEmpty()){
   	    objects.add(new CustomObject(Na, Al));
           }
       if(Na1!=null && !Na1.isEmpty()){
   	    objects.add(new CustomObject(Na1, Al1));
       }
       if(Na2!=null && !Na2.isEmpty()){
      	    objects.add(new CustomObject(Na2, Al2));
          }
       if(Na3!=null && !Na3.isEmpty()){
     	    objects.add(new CustomObject(Na3, Al3));
         }
       if(Na4!=null && !Na4.isEmpty()){
     	    objects.add(new CustomObject(Na4, Al4));
         }
       if(Na5!=null && !Na5.isEmpty()){
     	    objects.add(new CustomObject(Na5, Al5));
         }
       if(Na6!=null && !Na6.isEmpty()){
     	    objects.add(new CustomObject(Na6, Al6));
         }
       if(Na7!=null && !Na7.isEmpty()){
     	    objects.add(new CustomObject(Na7, Al7));
         }
       if(Na8!=null && !Na8.isEmpty()){
     	    objects.add(new CustomObject(Na8, Al8));
         }
       if(Na9!=null && !Na9.isEmpty()){
     	    objects.add(new CustomObject(Na9, Al9));
         }
       if(Na10!=null && !Na10.isEmpty()){
     	    objects.add(new CustomObject(Na10, Al10));
         }
       if(Na11!=null && !Na11.isEmpty()){
    	    objects.add(new CustomObject(Na11, Al11));
        }
       if(Na12!=null && !Na12.isEmpty()){
    	    objects.add(new CustomObject(Na12, Al12));
        }
       if(Na13!=null && !Na13.isEmpty()){
    	    objects.add(new CustomObject(Na13, Al13));
        }
       if(Na14!=null && !Na14.isEmpty()){
    	    objects.add(new CustomObject(Na14, Al14));
        }
       if(Na15!=null && !Na15.isEmpty()){
    	    objects.add(new CustomObject(Na15, Al15));
        }
   	    CustomListViewAdapter customAdapter = new CustomListViewAdapter(this, objects);
   	    lv.setAdapter(customAdapter);
   	    customAdapter.notifyDataSetChanged();
    }
	
	
	    
	    class loaddelays extends AsyncTask<Void, Void, String> {
	    	ProgressDialog pdLoading = new ProgressDialog(Delay.this);

	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            pdLoading.setMessage("Loading...");
	            pdLoading.show();
	            
	            Calendar c = Calendar.getInstance();
	            System.out.println("Current time => " + c.getTime());

	            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	            c.add(Calendar.DATE, 2);
	            String formattedDate = df.format(c.getTime());
	            Log.i("date", formattedDate);
	            
	            URL = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=red&accessibility=false&bystartdate="+formattedDate;
	            URL1 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=blue&accessibility=false&bystartdate="+formattedDate;
	            URL2 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=brn&accessibility=false&bystartdate="+formattedDate;
	            URL3 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=y&accessibility=false&bystartdate="+formattedDate;
	            URL4 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=p&accessibility=false&bystartdate="+formattedDate;
	            URL5 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=org&accessibility=false&bystartdate="+formattedDate;
	            URL6 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=pexp&accessibility=false&bystartdate="+formattedDate;
	            URL7 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=g&accessibility=false&bystartdate="+formattedDate;
	            URL8 = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=pink&accessibility=false&bystartdate="+formattedDate;

	        }

	        @Override
	        protected String doInBackground(Void... params) {
        

		doc = null;
		doc1 = null;
		doc2 = null;
		doc3 = null;
		doc4 = null;
		doc5 = null;
		doc6 = null;
		doc7 = null;
		doc8 = null;
		
		try {
		    doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc1 = Jsoup.connect(URL1).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc2 = Jsoup.connect(URL2).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc3 = Jsoup.connect(URL3).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc4 = Jsoup.connect(URL4).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc5 = Jsoup.connect(URL5).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc6 = Jsoup.connect(URL6).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc7 = Jsoup.connect(URL7).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		    doc8 = Jsoup.connect(URL8).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
		}
		
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pdLoading.dismiss();
            
		Elements elem1 = doc.select("Alert"); 
		Elements elem2 = doc1.select("Alert"); 
		Elements elem3 = doc2.select("Alert"); 
		Elements elem4 = doc3.select("Alert"); 
		Elements elem5 = doc4.select("Alert"); 
		Elements elem6 = doc5.select("Alert"); 
		Elements elem7 = doc6.select("Alert"); 
		Elements elem8 = doc7.select("Alert"); 
		Elements elem9 = doc8.select("Alert"); 
		
		Iterator<Element> iterator = elem1.iterator();
		Iterator<Element> iterator1 = elem2.iterator();
		Iterator<Element> iterator2 = elem3.iterator();
		Iterator<Element> iterator3 = elem4.iterator();
		Iterator<Element> iterator4 = elem5.iterator();
		Iterator<Element> iterator5 = elem6.iterator();
		Iterator<Element> iterator6 = elem7.iterator();
		Iterator<Element> iterator7 = elem8.iterator();
		Iterator<Element> iterator8 = elem9.iterator();

		while(iterator.hasNext())
		{ Element div = iterator.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}

		while(iterator1.hasNext())
		{ Element div = iterator1.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		while(iterator2.hasNext())
		{ Element div = iterator2.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		while(iterator3.hasNext())
		{ Element div = iterator3.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		while(iterator4.hasNext())
		{ Element div = iterator4.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		while(iterator5.hasNext())
		{ Element div = iterator5.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		while(iterator6.hasNext())
		{ Element div = iterator6.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		while(iterator7.hasNext())
		{ Element div = iterator7.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		while(iterator8.hasNext())
		{ Element div = iterator8.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
		}
		
		Log.i("Name", String.valueOf(Names));
		Log.i("Alert", String.valueOf(Alerts));
		
		   if(Alerts.size() > 0 && Alerts.get(0) != null){
		        Al = Alerts.get(0).text();
		    }
		   
		   if(Alerts.size() > 1 && Alerts.get(1) != null){
		        Al1 = Alerts.get(1).text();
		    }
		   
		   if(Alerts.size() > 2 && Alerts.get(2) != null){
		        Al2 = Alerts.get(2).text();
		    }
		   
		   if(Alerts.size() > 3 && Alerts.get(3) != null){
		        Al3 = Alerts.get(3).text();
		    }
		   
		   if(Alerts.size() > 4 && Alerts.get(4) != null){
		        Al4 = Alerts.get(4).text();
		    }
		   
		   if(Alerts.size() > 5 && Alerts.get(5) != null){
		        Al5 = Alerts.get(5).text();
		    }
		   
		   if(Alerts.size() > 6 && Alerts.get(6) != null){
		        Al6 = Alerts.get(6).text();
		    }
		   
		   if(Alerts.size() > 7 && Alerts.get(7) != null){
		        Al7 = Alerts.get(7).text();
		    }
		   
		   if(Alerts.size() > 8 && Alerts.get(8) != null){
		        Al8 = Alerts.get(8).text();
		    }
		   
		   if(Alerts.size() > 9 && Alerts.get(9) != null){
		        Al9 = Alerts.get(9).text();
		    }
		   
		   if(Alerts.size() > 10 && Alerts.get(10) != null){
		        Al10 = Alerts.get(10).text();
		    }
		   if(Alerts.size() > 11 && Alerts.get(11) != null){
		        Al11 = Alerts.get(11).text();
		    }
		   
		   if(Alerts.size() > 12 && Alerts.get(12) != null){
		        Al12 = Alerts.get(12).text();
		    }
		   
		   if(Alerts.size() > 13 && Alerts.get(13) != null){
		        Al13 = Alerts.get(13).text();
		    }
		   
		   if(Alerts.size() > 14 && Alerts.get(14) != null){
		        Al14 = Alerts.get(14).text();
		    }
		   
		   if(Alerts.size() > 15 && Alerts.get(15) != null){
		        Al15 = Alerts.get(15).text();
		    }
		   
		   if(Names.size() > 0 && Names.get(0) != null){
		        Na = Names.get(0).text();
		    }
		   
		   if(Names.size() > 1 && Names.get(1) != null){
		        Na1 = Names.get(1).text();
		    }
		   
		   if(Names.size() > 2 && Names.get(2) != null){
		        Na2 = Names.get(2).text();
		    }
		   
		   if(Names.size() > 3 && Names.get(3) != null){
		        Na3 = Names.get(3).text();
		    }
		   
		   if(Names.size() > 4 && Names.get(4) != null){
		        Na4 = Names.get(4).text();
		    }
		   
		   if(Names.size() > 5 && Names.get(5) != null){
		        Na5 = Names.get(5).text();
		    }
		   
		   if(Names.size() > 6 && Names.get(6) != null){
		        Na6 = Names.get(6).text();
		    }
		   
		   if(Names.size() > 7 && Names.get(7) != null){
		        Na7 = Names.get(7).text();
		    }
		   
		   if(Names.size() > 8 && Names.get(8) != null){
		        Na8 = Names.get(8).text();
		    }
		   
		   if(Names.size() > 9 && Names.get(9) != null){
		        Na9 = Names.get(9).text();
		    }
		   
		   if(Names.size() > 10 && Names.get(10) != null){
		        Na10 = Names.get(10).text();
		    }
		   
		   if(Names.size() > 11 && Names.get(11) != null){
		        Na11 = Names.get(11).text();
		    }
		   
		   if(Names.size() > 12 && Names.get(12) != null){
		        Na12 = Names.get(12).text();
		    }
		   
		   if(Names.size() > 13 && Names.get(13) != null){
		        Na13 = Names.get(13).text();
		    }
		   
		   if(Names.size() > 14 && Names.get(14) != null){
		        Na14 = Names.get(14).text();
		    }
		   
		   if(Names.size() > 15 && Names.get(15) != null){
		        Na15 = Names.get(15).text();
		    }
		   
		   Delay.this.takeItBack(result);    
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

}
