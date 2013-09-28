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
    Elements destNm = div.select("destNm");
    String DestNm = destNm.text();
    tv1.setText(String.valueOf (DestNm));
      

	while(iterator.hasNext())
	{ Element div1 = iterator.next();
    	
    Elements arrT1 = div1.select("arrT");
    Elements prdt1 = div1.select("prdt");
    Elements destNm1 = div1.select("destNm");
    String DestNm1 = destNm1.text();
    tv2.setText(String.valueOf (DestNm1));
    
    while(iterator.hasNext())
	{ Element div2 = iterator.next();
    	
    Elements arrT2 = div2.select("arrT");
    Elements prdt2 = div2.select("prdt");
    Elements destNm2 = div2.select("destNm");
    String DestNm2 = destNm2.text();
    tv4.setText(String.valueOf (DestNm2));
    
    while(iterator.hasNext())
	{ Element div3 = iterator.next();

    Elements arrT3 = div3.select("arrT");
    Elements prdt3 = div3.select("prdt");
    Elements destNm3 = div3.select("destNm");
    String DestNm3 = destNm3.text();
    tv6.setText(String.valueOf (DestNm3));
    
    while(iterator.hasNext())
	{ Element div4 = iterator.next();

    Elements arrT4 = div4.select("arrT");
    Elements prdt4 = div4.select("prdt");
    Elements destNm4 = div4.select("destNm");
    String DestNm4 = destNm4.text();
    tv8.setText(String.valueOf (DestNm4));
    
    while(iterator.hasNext())
	{ Element div5 = iterator.next();

    Elements arrT5 = div5.select("arrT");
    Elements prdt5 = div5.select("prdt");
    Elements destNm5 = div5.select("destNm");
    String DestNm5 = destNm5.text();
    tv10.setText(String.valueOf (DestNm5));
    
    while(iterator.hasNext())
	{ Element div6 = iterator.next();

    Elements arrT6 = div6.select("arrT");
    Elements prdt6 = div6.select("prdt");
    Elements destNm6 = div6.select("destNm");
    String DestNm6 = destNm6.text();
    tv12.setText(String.valueOf (DestNm6));
    
    while(iterator.hasNext())
	{ Element div7 = iterator.next();

    Elements arrT7 = div7.select("arrT");
    Elements prdt7 = div7.select("prdt");
    Elements destNm7 = div7.select("destNm");
    String DestNm7 = destNm7.text();
    tv14.setText(String.valueOf (DestNm7));
    
    while(iterator.hasNext())
	{ Element div8 = iterator.next();

    Elements arrT8 = div8.select("arrT");
    Elements prdt8 = div8.select("prdt");
    Elements destNm8 = div8.select("destNm");
    String DestNm8 = destNm8.text();
    tv16.setText(String.valueOf (DestNm8));
    
    while(iterator.hasNext())
	{ Element div9 = iterator.next();

    Elements arrT9 = div9.select("arrT");
    Elements prdt9 = div9.select("prdt");
    Elements destNm9 = div9.select("destNm");
    String DestNm9 = destNm9.text();
    tv18.setText(String.valueOf (DestNm9));
    
    while(iterator.hasNext())
	{ Element div10 = iterator.next();

    Elements arrT10 = div10.select("arrT");
    Elements prdt10 = div10.select("prdt");
    Elements destNm10 = div10.select("destNm");
    String DestNm10 = destNm10.text();
    tv20.setText(String.valueOf (DestNm10));
    
    while(iterator.hasNext())
	{ Element div11 = iterator.next();

    Elements arrT11 = div11.select("arrT");
    Elements prdt11 = div11.select("prdt");
    Elements destNm11 = div11.select("destNm");
    String DestNm11 = destNm11.text();
    tv22.setText(String.valueOf (DestNm11));
    
    while(iterator.hasNext())
	{ Element div12 = iterator.next();

    Elements arrT12 = div12.select("arrT");
    Elements prdt12 = div12.select("prdt");
    Elements destNm12 = div12.select("destNm");
    String DestNm12 = destNm12.text();
    tv24.setText(String.valueOf (DestNm12));
    
    while(iterator.hasNext())
	{ Element div13 = iterator.next();

    Elements arrT13 = div13.select("arrT");
    Elements prdt13 = div13.select("prdt");
    Elements destNm13 = div13.select("destNm");
    String DestNm13 = destNm13.text();
    tv26.setText(String.valueOf (DestNm13));
    
    while(iterator.hasNext())
	{ Element div14 = iterator.next();

    Elements arrT14 = div14.select("arrT");
    Elements prdt14 = div14.select("prdt");
    Elements destNm14 = div14.select("destNm");
    String DestNm14 = destNm14.text();
    tv28.setText(String.valueOf (DestNm14));
    
    
    
    
    

    try {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date1 = sdf.parse(arrT.text());
		Date date2 = sdf.parse(prdt.text());
		Date date3 = sdf.parse(arrT1.text());
		Date date4 = sdf.parse(prdt1.text());
		Date date5 = sdf.parse(arrT2.text());
		Date date6 = sdf.parse(prdt2.text());
		Date date7 = sdf.parse(arrT3.text());
		Date date8 = sdf.parse(prdt3.text());
		Date date9 = sdf.parse(arrT4.text());
		Date date10 = sdf.parse(prdt4.text());
		Date date11 = sdf.parse(arrT5.text());
		Date date12 = sdf.parse(prdt5.text());
		Date date13 = sdf.parse(arrT6.text());
		Date date14 = sdf.parse(prdt6.text());
		Date date15 = sdf.parse(arrT7.text());
		Date date16 = sdf.parse(prdt7.text());
		Date date17 = sdf.parse(arrT8.text());
		Date date18 = sdf.parse(prdt8.text());
		Date date19 = sdf.parse(arrT9.text());
		Date date20 = sdf.parse(prdt9.text());
		Date date21 = sdf.parse(arrT10.text());
		Date date22 = sdf.parse(prdt10.text());
		Date date23 = sdf.parse(arrT11.text());
		Date date24 = sdf.parse(prdt11.text());
		Date date25 = sdf.parse(arrT12.text());
		Date date26 = sdf.parse(prdt12.text());
		Date date27 = sdf.parse(arrT13.text());
		Date date28 = sdf.parse(prdt13.text());
		Date date29 = sdf.parse(arrT14.text());
		Date date30 = sdf.parse(prdt14.text());
		
		long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
		long dateDiff1 = (date3.getTime() - date4.getTime())>0 ? (date3.getTime() - date4.getTime()) :(date4.getTime() - date3.getTime());
		long dateDiff2 = (date5.getTime() - date6.getTime())>0 ? (date5.getTime() - date6.getTime()) :(date6.getTime() - date5.getTime());
		long dateDiff3 = (date7.getTime() - date8.getTime())>0 ? (date7.getTime() - date8.getTime()) :(date8.getTime() - date7.getTime());
		long dateDiff4 = (date9.getTime() - date10.getTime())>0 ? (date9.getTime() - date10.getTime()) :(date10.getTime() - date9.getTime());
		long dateDiff5 = (date11.getTime() - date12.getTime())>0 ? (date11.getTime() - date12.getTime()) :(date12.getTime() - date11.getTime());
		long dateDiff6 = (date13.getTime() - date14.getTime())>0 ? (date13.getTime() - date14.getTime()) :(date14.getTime() - date13.getTime());
		long dateDiff7 = (date15.getTime() - date16.getTime())>0 ? (date15.getTime() - date16.getTime()) :(date16.getTime() - date15.getTime());
		long dateDiff8 = (date17.getTime() - date18.getTime())>0 ? (date17.getTime() - date18.getTime()) :(date18.getTime() - date17.getTime());
		long dateDiff9 = (date19.getTime() - date20.getTime())>0 ? (date19.getTime() - date20.getTime()) :(date20.getTime() - date19.getTime());
		long dateDiff10 = (date21.getTime() - date22.getTime())>0 ? (date21.getTime() - date22.getTime()) :(date22.getTime() - date21.getTime());
		long dateDiff11 = (date23.getTime() - date24.getTime())>0 ? (date23.getTime() - date24.getTime()) :(date24.getTime() - date23.getTime());
		long dateDiff12 = (date25.getTime() - date26.getTime())>0 ? (date25.getTime() - date26.getTime()) :(date26.getTime() - date25.getTime());
		long dateDiff13 = (date27.getTime() - date28.getTime())>0 ? (date27.getTime() - date28.getTime()) :(date28.getTime() - date27.getTime());
		long dateDiff14 = (date29.getTime() - date30.getTime())>0 ? (date29.getTime() - date30.getTime()) :(date30.getTime() - date29.getTime());
		
	    SimpleDateFormat sdf1 = new SimpleDateFormat("mm:00");
	    String dateDif = sdf1.format(dateDiff);
	    String dateDif1 = sdf1.format(dateDiff1);
	    String dateDif2 = sdf1.format(dateDiff2);
	    String dateDif3 = sdf1.format(dateDiff3);
	    String dateDif4 = sdf1.format(dateDiff4);
	    String dateDif5 = sdf1.format(dateDiff5);
	    String dateDif6 = sdf1.format(dateDiff6);
	    String dateDif7 = sdf1.format(dateDiff7);
	    String dateDif8 = sdf1.format(dateDiff8);
	    String dateDif9 = sdf1.format(dateDiff9);
	    String dateDif10 = sdf1.format(dateDiff10);
	    String dateDif11 = sdf1.format(dateDiff11);
	    String dateDif12 = sdf1.format(dateDiff12);
	    String dateDif13 = sdf1.format(dateDiff13);
	    String dateDif14 = sdf1.format(dateDiff14);
	    
	    tv.setText(String.valueOf (dateDif));
	    tv3.setText(String.valueOf (dateDif1));
	    tv5.setText(String.valueOf (dateDif2));
	    tv7.setText(String.valueOf (dateDif3));
	    tv9.setText(String.valueOf (dateDif4));
	    tv11.setText(String.valueOf (dateDif5));
	    tv13.setText(String.valueOf (dateDif6));
	    tv15.setText(String.valueOf (dateDif7));
	    tv17.setText(String.valueOf (dateDif8));
	    tv19.setText(String.valueOf (dateDif9));
	    tv21.setText(String.valueOf (dateDif10));
	    tv23.setText(String.valueOf (dateDif11));
	    tv25.setText(String.valueOf (dateDif12));
	    tv27.setText(String.valueOf (dateDif13));
	    tv29.setText(String.valueOf (dateDif14));

	    
	    }
		
    catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
		
		
	 }
    
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}
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
