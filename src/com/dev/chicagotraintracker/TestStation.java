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
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class TestStation extends Activity implements PullToRefreshAttacher.OnRefreshListener {
	String myUrl;
    Document doc = null;
    
	ArrayList<Elements> arT = new ArrayList<Elements>();
	ArrayList<Elements> prT = new ArrayList<Elements>();
	ArrayList<Elements> DestNm = new ArrayList<Elements>();
	ArrayList<Elements> rta = new ArrayList<Elements>();
	
	Iterator<Element> iterator;
	 
	int count;
	int times;
	
	private PullToRefreshAttacher mPullToRefreshAttacher;
	
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
            setContentView(R.layout.test_station);
            getActionBar().setDisplayHomeAsUpEnabled(true);
            
            mPullToRefreshAttacher = PullToRefreshAttacher.get(this);
            PullToRefreshLayout ptrLayout = (PullToRefreshLayout) findViewById(R.id.scroll);
            ptrLayout.setPullToRefreshAttacher(mPullToRefreshAttacher, this);
            
            if(isOnline() == true){
                new loadtrains().execute();
            }
            else{
            	AlertDialog.Builder builder = new AlertDialog.Builder(this);
            	builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            	           public void onClick(DialogInterface dialog, int id) {
            	               finish();
            	               TestStation.this.overridePendingTransition(0, android.R.anim.fade_out);
            	           }
            	       });
            	builder.setMessage("You're not connected to the internet. Connect to the internet and try again.")
                .setTitle("You're not connected");
            	AlertDialog dialog = builder.create();
            	dialog.show();
            }
    }
    
    class loadtrains extends AsyncTask<Void, Void, Void> {
    	
    	ProgressDialog pdLoading = new ProgressDialog(TestStation.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("Loading...");
            pdLoading.show();
            
            Intent intent = getIntent();
            String value = intent.getExtras().getString("value");
            
            Uri my = Uri.parse("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=201412abc85d49b2b83f907f9e329eaa&mapid="+value);
                    
            myUrl = my.toString();
        }

        @Override
        protected Void doInBackground(Void... params) {
	        try {
	            doc = Jsoup.connect(myUrl).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
	        } catch (IOException e) {
		        e.printStackTrace();
	        }
			Elements elem = null;
			elem = doc.select("eta");
			iterator = elem.iterator();
			times = 0;
			count = 0;
	
			String elemn = elem.text();
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String formattedDate = df.format(c.getTime());
			Log.i("date", formattedDate);

			String findStr = formattedDate;
			int lastIndex = 0;
			while (lastIndex != -1) {
				lastIndex = elemn.indexOf(findStr, lastIndex);
				if (lastIndex != -1) {
					count++;
					Log.i("MYMESSAGE4", String.valueOf(count));
					lastIndex += findStr.length();
				}
			}

			times = (count / 2);
			Log.i("times", String.valueOf(times));
			return null;
		}
        
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            
            TextView tv = (TextView) findViewById(R.id.tv1);
            TextView tv1 = (TextView) findViewById(R.id.tv);
            TextView tv2 = (TextView) findViewById(R.id.tv2);
            TextView tv3 = (TextView) findViewById(R.id.tv3);
            TextView tv4 = (TextView) findViewById(R.id.tv4);
            TextView tv5 = (TextView) findViewById(R.id.tv5);
            TextView tv6 = (TextView) findViewById(R.id.tv6);
            TextView tv7 = (TextView) findViewById(R.id.tv7);
            TextView tv8 = (TextView) findViewById(R.id.tv8);
            TextView tv9 = (TextView) findViewById(R.id.tv9);
            TextView tv10 = (TextView) findViewById(R.id.tv10);
            TextView tv11 = (TextView) findViewById(R.id.tv11);
            TextView tv12 = (TextView) findViewById(R.id.tv12);
            TextView tv13 = (TextView) findViewById(R.id.tv13);
            TextView tv14 = (TextView) findViewById(R.id.tv14);
            TextView tv15 = (TextView) findViewById(R.id.tv15);
            TextView tv16 = (TextView) findViewById(R.id.tv16);
            TextView tv17 = (TextView) findViewById(R.id.tv17);
            TextView tv18 = (TextView) findViewById(R.id.tv18);
            TextView tv19 = (TextView) findViewById(R.id.tv19);
            TextView tv20 = (TextView) findViewById(R.id.tv20);
            TextView tv21 = (TextView) findViewById(R.id.tv21);
            TextView tv22 = (TextView) findViewById(R.id.tv22);
            TextView tv23 = (TextView) findViewById(R.id.tv23);
            TextView tv24 = (TextView) findViewById(R.id.tv24);
            TextView tv25 = (TextView) findViewById(R.id.tv25);
            TextView tv26 = (TextView) findViewById(R.id.tv26);
            TextView tv27 = (TextView) findViewById(R.id.tv27);
            TextView tv28 = (TextView) findViewById(R.id.tv28);
            TextView tv29 = (TextView) findViewById(R.id.tv29);
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
            ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
            ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
            ImageView iv4 = (ImageView) findViewById(R.id.imageView4);
            ImageView iv5 = (ImageView) findViewById(R.id.imageView5);
            ImageView iv6 = (ImageView) findViewById(R.id.imageView6);
            ImageView iv7 = (ImageView) findViewById(R.id.imageView7);
            ImageView iv8 = (ImageView) findViewById(R.id.imageView8);
            ImageView iv9 = (ImageView) findViewById(R.id.imageView9);
            ImageView iv10 = (ImageView) findViewById(R.id.imageView10);
            ImageView iv11 = (ImageView) findViewById(R.id.imageView11);
            ImageView iv12 = (ImageView) findViewById(R.id.imageView12);
            ImageView iv13 = (ImageView) findViewById(R.id.imageView13);
            ImageView iv14 = (ImageView) findViewById(R.id.imageView14);
            final String Approaching = getString(R.string.Approaching);
            final String min = getString(R.string.min);
            
        	arT.clear();
        	prT.clear();
        	DestNm.clear();
        	rta.clear();

			while (iterator.hasNext()) {
				for (int i = 0; i < times; i++) {
					Element div = iterator.next();
					Elements arrT = div.select("arrT");
					arT.add(arrT);
					Elements prdt = div.select("prdt");
					prT.add(prdt);
					Elements destNm = div.select("destNm");
					DestNm.add(destNm);
					Elements rt = div.select("rt");
					rta.add(rt);
				}
			}
			
			int num = -1;
			for(Elements elemnarrt : arT){
				num++;
				String arrt = elemnarrt.text();
				String prdtstring = prT.get(num).text();
				String destnm = DestNm.get(num).text();
				String stringrt = rta.get(num).text();
				String dateDif = null;
				int color = 0;
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		    	SimpleDateFormat sdf1 = new SimpleDateFormat("mm:00");
		    	try {
		    		Date date1 = sdf.parse(arrt);
		    		Date date2 = sdf.parse(prdtstring);
				    long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
				    dateDif = sdf1.format(dateDiff);
			    }  catch (ParseException e) {
					e.printStackTrace();
				}
		    	
		    	if(stringrt.contains(getString(R.string.Red))){
		    		color = com.dev.chicagotraintracker.R.drawable.red;
		    	}
		    	if(stringrt.contains(getString(R.string.Blue))){
		    		color = com.dev.chicagotraintracker.R.drawable.blue;
		    	}
		    	if(stringrt.contains(getString(R.string.Orange))){
		    		color = com.dev.chicagotraintracker.R.drawable.orange;
		    	}
		    	if(stringrt.contains(getString(R.string.Green))){
		    		color = com.dev.chicagotraintracker.R.drawable.green;
		    	}
		    	if(stringrt.contains(getString(R.string.Yellow))){
		    		color = com.dev.chicagotraintracker.R.drawable.yellow;
		    	}
		    	if(stringrt.equals(getString(R.string.Purple))){
		    		color = com.dev.chicagotraintracker.R.drawable.purple;
		    	}
		    	if(stringrt.contains(getString(R.string.Pink))){
		    		color = com.dev.chicagotraintracker.R.drawable.pink;
		    	}
		    	if(stringrt.contains(getString(R.string.Brown))){
		    		color = com.dev.chicagotraintracker.R.drawable.brown; 
		    	}

				switch(num){
				    case 0:
				    	tv1.setText(destnm);
				    	iv.setImageResource(color);
				        if(dateDif.equals(min)) {
				        	tv.setText(Approaching);
				        }
				        else{
				        	tv.setText(dateDif);
				        }
				        break;
				    case 1:
				    	tv2.setText(destnm);
				    	iv1.setImageResource(color);
				        if(dateDif.equals(min)) {
				        	tv3.setText(Approaching);
				        }
				        else{
				        	tv3.setText(dateDif);
				        }
				        break;
				    case 2:
				    	tv4.setText(destnm);
				    	iv2.setImageResource(color);
				        if(dateDif.equals(min)) {
				        	tv5.setText(Approaching);
				        }
				        else{
				        	tv5.setText(dateDif);
				        }
				        break;
				    case 3:
				    	tv6.setText(destnm);
				    	iv3.setImageResource(color);
				        if(dateDif.equals(min)) {
				        	tv7.setText(Approaching);
				        }
				        else{
				        	tv7.setText(dateDif);
				        }
				        break;
				    case 4:
				    	tv8.setText(destnm);
				    	iv4.setImageResource(color);
				        if(dateDif.equals(min)) {
				        	tv9.setText(Approaching);
				        }
				        else{
				        	tv9.setText(dateDif);
				        }
				        break;
				    case 5:
				    	tv10.setText(destnm);
				    	iv5.setImageResource(color);
				        if(dateDif.equals(min)) {
				        	tv11.setText(Approaching);
				        }
				        else{
				        	tv11.setText(dateDif);
				        }
				        break;
				    case 6:
				    	tv12.setText(destnm);
				    	iv6.setImageResource(color);
				        tv13.setText(dateDif);
				        break;
				    case 7:
				    	tv14.setText(destnm);
				    	iv7.setImageResource(color);
				        tv15.setText(dateDif);
				        break;
				    case 8:
				    	tv16.setText(destnm);
				    	iv8.setImageResource(color);
				        tv17.setText(dateDif);
				        break;
				    case 9:
				    	tv18.setText(destnm);
				    	iv9.setImageResource(color);
				        tv19.setText(dateDif);
				        break;
				    case 10:
				    	tv20.setText(destnm);
				    	iv10.setImageResource(color);
				        tv21.setText(dateDif);
				        break;
				    case 11:
				    	tv22.setText(destnm);
				    	iv11.setImageResource(color);
				        tv23.setText(dateDif);
				        break;
				    case 12:
				    	tv24.setText(destnm);
				    	iv12.setImageResource(color);
				        tv25.setText(dateDif);
				        break;
				    case 13:
				    	tv26.setText(destnm);
				    	iv13.setImageResource(color);
				        tv27.setText(dateDif);
				        break;
				    case 14:
				    	tv28.setText(destnm);
				    	iv14.setImageResource(color);
				        tv29.setText(dateDif);
				        break;
				}
			}
            pdLoading.dismiss();
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
	public void onRefreshStarted(View view) {
		if(isOnline() == true){
            new loadtrains().execute();
        }
        else{
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
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