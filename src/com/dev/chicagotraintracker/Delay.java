package com.dev.chicagotraintracker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher.OnRefreshListener;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class Delay extends Activity implements AsyncTaskCallback, OnRefreshListener{
	
	private PullToRefreshAttacher mPullToRefreshAttacher;
	String URL;
	Document doc;
    ArrayList<Elements> Alerts = new ArrayList<Elements>();
	ArrayList<Elements> Names = new ArrayList<Elements>();
	ArrayList<Elements> Starts = new ArrayList<Elements>();
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
	String Al16;
	String Al17;
	String Al18;
	String Al19;
	String Al20;
	
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
	String Na16;
	String Na17;
	String Na18;
	String Na19;
	String Na20;
	
	String St;
	String St1;
	String St2;
	String St3;
	String St4;
	String St5;
	String St6;
	String St7;
	String St8;
	String St9;
	String St10;
	String St11;
	String St12;
	String St13;
	String St14;
	String St15;
	String St16;
	String St17;
	String St18;
	String St19;
	String St20;
	
	String Sta;
	String Sta1;
	String Sta2;
	String Sta3;
	String Sta4;
	String Sta5;
	String Sta6;
	String Sta7;
	String Sta8;
	String Sta9;
	String Sta10;
	String Sta11;
	String Sta12;
	String Sta13;
	String Sta14;
	String Sta15;
	String Sta16;
	String Sta17;
	String Sta18;
	String Sta19;
	String Sta20;
	
	public boolean isOnline() {
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delay);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	            lv = (ListView) findViewById(R.id.lv);
	            if(isOnline() == true){
	                new loaddelays().execute();
	            }
	            else{
	            	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	            	// Add the buttons
	            	builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
	            	           public void onClick(DialogInterface dialog, int id) {
	            	               finish();
	            	               Delay.this.overridePendingTransition(0, android.R.anim.fade_out);
	            	           }
	            	       });
	            	builder.setMessage("You're not connected to the internet. Connect to the internet and try again.")
	                .setTitle("You're not connected");
	            	AlertDialog dialog = builder.create();
	            	dialog.show();
	            }

	            ListView scrollableView = lv;
	            mPullToRefreshAttacher = PullToRefreshAttacher.get(this);
	            mPullToRefreshAttacher.addRefreshableView(scrollableView, this);
	    }
	
    @Override
    public void takeItBack(String result) {
        ArrayList<CustomObject> objects = new ArrayList<CustomObject>();
       if(Na!=null && !Na.isEmpty()){
   	    objects.add(new CustomObject(Na, Al, St));
           }
       if(Na1!=null && !Na1.isEmpty()){
   	    objects.add(new CustomObject(Na1, Al1, St1));
       }
       if(Na2!=null && !Na2.isEmpty()){
      	    objects.add(new CustomObject(Na2, Al2, St2));
          }
       if(Na3!=null && !Na3.isEmpty()){
     	    objects.add(new CustomObject(Na3, Al3, St3));
         }
       if(Na4!=null && !Na4.isEmpty()){
     	    objects.add(new CustomObject(Na4, Al4, St4));
         }
       if(Na5!=null && !Na5.isEmpty()){
     	    objects.add(new CustomObject(Na5, Al5, St5));
         }
       if(Na6!=null && !Na6.isEmpty()){
     	    objects.add(new CustomObject(Na6, Al6, St6));
         }
       if(Na7!=null && !Na7.isEmpty()){
     	    objects.add(new CustomObject(Na7, Al7, St7));
         }
       if(Na8!=null && !Na8.isEmpty()){
     	    objects.add(new CustomObject(Na8, Al8, St8));
         }
       if(Na9!=null && !Na9.isEmpty()){
     	    objects.add(new CustomObject(Na9, Al9, St9));
         }
       if(Na10!=null && !Na10.isEmpty()){
     	    objects.add(new CustomObject(Na10, Al10, St10));
         }
       if(Na11!=null && !Na11.isEmpty()){
    	    objects.add(new CustomObject(Na11, Al11, St11));
        }
       if(Na12!=null && !Na12.isEmpty()){
    	    objects.add(new CustomObject(Na12, Al12, St12));
        }
       if(Na13!=null && !Na13.isEmpty()){
    	    objects.add(new CustomObject(Na13, Al13, St13));
        }
       if(Na14!=null && !Na14.isEmpty()){
    	    objects.add(new CustomObject(Na14, Al14, St14));
        }
       if(Na15!=null && !Na15.isEmpty()){
    	    objects.add(new CustomObject(Na15, Al15, St15));
        }
       if(Na16!=null && !Na16.isEmpty()){
   	    objects.add(new CustomObject(Na16, Al16, St16));
       }
       if(Na17!=null && !Na17.isEmpty()){
   	    objects.add(new CustomObject(Na17, Al17, St17));
       }
       if(Na18!=null && !Na18.isEmpty()){
   	    objects.add(new CustomObject(Na18, Al18, St18));
       }
       if(Na19!=null && !Na19.isEmpty()){
   	    objects.add(new CustomObject(Na19, Al19, St19));
       }
       if(Na20!=null && !Na20.isEmpty()){
   	    objects.add(new CustomObject(Na20, Al20, St20));
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
	            pdLoading.setMessage("Loading Delays...");
	            pdLoading.show();
	            
	            Calendar c = Calendar.getInstance();

	            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	            c.add(Calendar.DATE, 2);
	            String formattedDate = df.format(c.getTime());
	            Log.i("date", formattedDate);
	            
	            URL = "http://www.transitchicago.com/api/1.0/alerts.aspx?routeid=red,blue,brn,y,p,org,pexp,g,pink&accessibility=false&bystartdate="+formattedDate;
	        }

	        @Override
	        protected String doInBackground(Void... params) {

		doc = null;
		
		try {
		    doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
			return null;
		}
		
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pdLoading.dismiss();
            
        	Names.clear();
        	Alerts.clear();
        	Starts.clear();
            
		Elements elem1 = doc.select("Alert"); 
		
		Iterator<Element> iterator = elem1.iterator();
		
		while(iterator.hasNext())
		{ Element div = iterator.next();	    	
	    Elements Short = div.select("ShortDescription");
	    Elements Impacted = div.select("ImpactedService");
	    Elements Start = div.select("EventStart");
	    Elements Name = Impacted.select("ServiceName");
	    Names.add(Name);
	    Alerts.add(Short);
	    Starts.add(Start);
		}

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
		   
		   if(Alerts.size() > 16 && Alerts.get(16) != null){
		        Al16 = Alerts.get(16).text();
		    }
		   
		   if(Alerts.size() > 17 && Alerts.get(17) != null){
		        Al17 = Alerts.get(17).text();
		    }
		   
		   if(Alerts.size() > 18 && Alerts.get(18) != null){
		        Al18 = Alerts.get(18).text();
		    }
		   
		   if(Alerts.size() > 19 && Alerts.get(19) != null){
		        Al19 = Alerts.get(19).text();
		    }
		   
		   if(Alerts.size() > 20 && Alerts.get(20) != null){
		        Al20 = Alerts.get(20).text();
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
		   
		   if(Names.size() > 16 && Names.get(16) != null){
		        Na16 = Names.get(16).text();
		    }
		   
		   if(Names.size() > 17 && Names.get(17) != null){
		        Na17 = Names.get(17).text();
		    }
		   
		   if(Names.size() > 18 && Names.get(18) != null){
		        Na18 = Names.get(18).text();
		    }
		   
		   if(Names.size() > 19 && Names.get(19) != null){
		        Na19 = Names.get(19).text();
		    }
		   
		   if(Names.size() > 20 && Names.get(20) != null){
		        Na20 = Names.get(20).text();
		    }
		   
		   if(Starts.size() > 0 && Starts.get(0) != null){
		        Sta = Starts.get(0).text();
		    }
		   
		   if(Starts.size() > 1 && Starts.get(1) != null){
		        Sta1 = Starts.get(1).text();
		    }
		   
		   if(Starts.size() > 2 && Starts.get(2) != null){
		        Sta2 = Starts.get(2).text();
		    }
		   
		   if(Starts.size() > 3 && Starts.get(3) != null){
		        Sta3 = Starts.get(3).text();
		    }
		   
		   if(Starts.size() > 4 && Starts.get(4) != null){
		        Sta4 = Starts.get(4).text();
		    }
		   
		   if(Starts.size() > 5 && Starts.get(5) != null){
		        Sta5 = Starts.get(5).text();
		    }
		   
		   if(Starts.size() > 6 && Starts.get(6) != null){
		        Sta6 = Starts.get(6).text();
		    }
		   
		   if(Starts.size() > 7 && Starts.get(7) != null){
		        Sta7 = Starts.get(7).text();
		    }
		   
		   if(Starts.size() > 8 && Starts.get(8) != null){
		        Sta8 = Starts.get(8).text();
		    }
		   
		   if(Starts.size() > 9 && Starts.get(9) != null){
		        Sta9 = Starts.get(9).text();
		    }
		   
		   if(Starts.size() > 10 && Starts.get(10) != null){
		        Sta10 = Starts.get(10).text();
		    }
		   
		   if(Starts.size() > 11 && Starts.get(11) != null){
		        Sta11 = Starts.get(11).text();
		    }
		   
		   if(Starts.size() > 12 && Starts.get(12) != null){
		        Sta12 = Starts.get(12).text();
		    }
		   
		   if(Starts.size() > 13 && Starts.get(13) != null){
		        Sta13 = Starts.get(13).text();
		    }
		   
		   if(Starts.size() > 14 && Starts.get(14) != null){
		        Sta14 = Starts.get(14).text();
		    }
		   
		   if(Starts.size() > 15 && Starts.get(15) != null){
		        Sta15 = Starts.get(15).text();
		    }
		   
		   if(Starts.size() > 16 && Starts.get(16) != null){
		        Sta16 = Starts.get(16).text();
		    }
		   
		   if(Starts.size() > 17 && Starts.get(17) != null){
		        Sta17 = Starts.get(17).text();
		    }
		   
		   if(Starts.size() > 18 && Starts.get(18) != null){
		        Sta18 = Starts.get(18).text();
		    }
		   
		   if(Starts.size() > 19 && Starts.get(19) != null){
		        Sta19 = Starts.get(19).text();
		    }
		   
		   if(Starts.size() > 20 && Starts.get(20) != null){
		        Sta20 = Starts.get(20).text();
		    }

			   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			   SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			   SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd HH:mm");
			   SimpleDateFormat dateFormat3 = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
		try {
			
			if (Sta!=null && !Sta.isEmpty()){
			if (Sta.length() == 8){
				Date myDate = null;
				myDate = dateFormat.parse(Sta);   
				St = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta);
				St = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta1!=null && !Sta1.isEmpty()){
			if (Sta1.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta1);   
				St1 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta1);
				St1 = dateFormat3.format(myDate1);
				}
		}
		
			if (Sta2!=null && !Sta2.isEmpty()){
			if (Sta2.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta2);   
				St2 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta2);
				St2 = dateFormat3.format(myDate1);
				}
		}
		
		if (Sta3!=null && !Sta3.isEmpty()){
			if (Sta3.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta3);   
				St3 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta3);
				St3 = dateFormat3.format(myDate1);
				}
		}
		
		if (Sta4!=null && !Sta4.isEmpty()){
			if (Sta4.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta4);   
				St4 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta4);
				St4 = dateFormat3.format(myDate1);
				}
		}
		
		if (Sta5!=null && !Sta5.isEmpty()){
			if (Sta5.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta5);   
				St5 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta5);
				St5 = dateFormat3.format(myDate1);
				}
		}
		
		if (Sta6!=null && !Sta6.isEmpty()){	
			if (Sta6.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta6);   
				St6 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta6);
				St6 = dateFormat3.format(myDate1);
				}
		}
		
		if (Sta7!=null && !Sta7.isEmpty()){
			if (Sta7.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta7);   
				St7 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta7);
				St7 = dateFormat3.format(myDate1);
				}
			}
		
			if (Sta8!=null && !Sta8.isEmpty()){
			if (Sta8.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta8);   
				St8 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta8);
				St8 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta9!=null && !Sta9.isEmpty()){
			if (Sta9.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta9);   
				St9 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta9);
				St9 = dateFormat3.format(myDate1);
				}
			}
			
			if (Sta10!=null && !Sta10.isEmpty()){
			if (Sta10.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta10);   
				St10 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta10);
				St10 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta11!=null && !Sta11.isEmpty()){
			if (Sta11.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta11);   
				St11 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta11);
				St11 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta12!=null && !Sta12.isEmpty()){
			if (Sta12.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta12);   
				St12 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta12);
				St12 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta13!=null && !Sta13.isEmpty()){
			if (Sta13.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta13);   
				St13 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta13);
				St13 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta14!=null && !Sta14.isEmpty()){
			if (Sta14.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta14);   
				St14 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta14);
				St14 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta15!=null && !Sta15.isEmpty()){
			if (Sta15.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta15);   
				St15 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta15);
				St15 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta16!=null && !Sta16.isEmpty()){
			if (Sta16.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta16);   
				St16 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta16);
				St16 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta17!=null && !Sta17.isEmpty()){
			if (Sta17.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta17);   
				St17 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta17);
				St17 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta18!=null && !Sta18.isEmpty()){
			if (Sta18.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta18);   
				St18 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta18);
				St18 = dateFormat3.format(myDate1);
				}
		}
			
			if (Sta19!=null && !Sta19.isEmpty()){
			if (Sta19.length() == 8 ){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta19);   
				St19 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta19);
				St19 = dateFormat3.format(myDate1);
				}
			}
			
			if (Sta20!=null && !Sta20.isEmpty()){
			if (Sta20.length() == 8){
	            Date myDate = null;
				myDate = dateFormat.parse(Sta20);   
				St20 = dateFormat1.format(myDate);
				}
			
			else{
				Date myDate1 = null;
				myDate1 = dateFormat2.parse(Sta20);
				St20 = dateFormat3.format(myDate1);
				}
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
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

	@Override
	public void onRefreshStarted(View view) {
		 if(isOnline() == true){
             new loaddelays().execute();
         }
         else{
         	AlertDialog.Builder builder = new AlertDialog.Builder(this);
         	// Add the buttons
         	builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
         	           public void onClick(DialogInterface dialog, int id) {
                           // we don't need to do anything here since the user had internet at one time (the origional load)
         	           }
         	       });
         	builder.setMessage("You're not connected to the internet. Connect to the internet and try again.")
             .setTitle("You're not connected");
         	AlertDialog dialog = builder.create();
         	dialog.show();
         }
		mPullToRefreshAttacher.setRefreshComplete();
	}
	
}