package com.dev.chicagotraintracker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class TestStation extends Activity {
	Elements arrT;
	Elements arrT1;
	Elements arrT2;
	Elements arrT3;
	Elements arrT4;
	Elements arrT5;
	Elements arrT6;
	Elements arrT7;
	Elements arrT8;
	Elements arrT9;
	Elements arrT10;
	Elements arrT11;
	Elements arrT12;
	Elements arrT13;
	Elements arrT14;
	Elements arrT15;
	Elements arrT16;
	
	Elements prdt;
	Elements prdt1;
	Elements prdt2;
	Elements prdt3;
	Elements prdt4;
	Elements prdt5;
	Elements prdt6;
	Elements prdt7;
	Elements prdt8;
	Elements prdt9;
	Elements prdt10;
	Elements prdt11;
	Elements prdt12;
	Elements prdt13;
	Elements prdt14;
	Elements prdt15;
	Elements prdt16;
	
	String rt;
	String rt1;
	String rt2;
	String rt3;
	String rt4;
	String rt5;
	String rt6;
	String rt7;
	String rt8;
	String rt9;
	String rt10;
	String rt11;
	String rt12;
	String rt13;
	String rt14;
	String rt15;
	String rt16;
	
    Document doc = null;
    
	ArrayList<Elements> arT = new ArrayList<Elements>();
	ArrayList<Elements> prT = new ArrayList<Elements>();
	ArrayList<Elements> DestNm = new ArrayList<Elements>();
	ArrayList<Elements> rta = new ArrayList<Elements>();
	
	Iterator<Element> iterator;
	 
	int count = 0;
	
	String URL = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=201412abc85d49b2b83f907f9e329eaa&mapid=40380";
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
            setContentView(R.layout.test_station);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); 
            
            Intent intent = getIntent();
            String value = intent.getExtras().getString("value");
            
            Uri my = Uri.parse("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=201412abc85d49b2b83f907f9e329eaa&mapid="+value);
                    
            final String myUrl = my.toString();
    
    final TextView tv = (TextView) findViewById(R.id.tv);
    final TextView tv1 = (TextView) findViewById(R.id.tv1);
    final TextView tv2 = (TextView) findViewById(R.id.tv2);
    final TextView tv3 = (TextView) findViewById(R.id.tv3);
    final TextView tv4 = (TextView) findViewById(R.id.tv4);
    final TextView tv5 = (TextView) findViewById(R.id.tv5);
    final TextView tv6 = (TextView) findViewById(R.id.tv6);
    final TextView tv7 = (TextView) findViewById(R.id.tv7);
    final TextView tv8 = (TextView) findViewById(R.id.tv8);
    final TextView tv9 = (TextView) findViewById(R.id.tv9);
    final TextView tv10 = (TextView) findViewById(R.id.tv10);
    final TextView tv11 = (TextView) findViewById(R.id.tv11);
    final TextView tv12 = (TextView) findViewById(R.id.tv12);
    final TextView tv13 = (TextView) findViewById(R.id.tv13);
    final TextView tv14 = (TextView) findViewById(R.id.tv14);
    final TextView tv15 = (TextView) findViewById(R.id.tv15);
    final TextView tv16 = (TextView) findViewById(R.id.tv16);
    final TextView tv17 = (TextView) findViewById(R.id.tv17);
    final TextView tv18 = (TextView) findViewById(R.id.tv18);
    final TextView tv19 = (TextView) findViewById(R.id.tv19);
    final TextView tv20 = (TextView) findViewById(R.id.tv20);
    final TextView tv21 = (TextView) findViewById(R.id.tv21);
    final TextView tv22 = (TextView) findViewById(R.id.tv22);
    final TextView tv23 = (TextView) findViewById(R.id.tv23);
    final TextView tv24 = (TextView) findViewById(R.id.tv24);
    final TextView tv25 = (TextView) findViewById(R.id.tv25);
    final TextView tv26 = (TextView) findViewById(R.id.tv26);
    final TextView tv27 = (TextView) findViewById(R.id.tv27);
    final TextView tv28 = (TextView) findViewById(R.id.tv28);
    final TextView tv29 = (TextView) findViewById(R.id.tv29);
    final ImageView iv = (ImageView) findViewById(R.id.imageView);
    final ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
    final ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
    final ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
    final ImageView iv4 = (ImageView) findViewById(R.id.imageView4);
    final ImageView iv5 = (ImageView) findViewById(R.id.imageView5);
    final ImageView iv6 = (ImageView) findViewById(R.id.imageView6);
    final ImageView iv7 = (ImageView) findViewById(R.id.imageView7);
    final ImageView iv8 = (ImageView) findViewById(R.id.imageView8);
    final ImageView iv9 = (ImageView) findViewById(R.id.imageView9);
    final ImageView iv10 = (ImageView) findViewById(R.id.imageView10);
    final ImageView iv11 = (ImageView) findViewById(R.id.imageView11);
    final ImageView iv12 = (ImageView) findViewById(R.id.imageView12);
    final ImageView iv13 = (ImageView) findViewById(R.id.imageView13);
    final ImageView iv14 = (ImageView) findViewById(R.id.imageView14);
    final String Red = this.getString(R.string.Red);
    final String Blue = this.getString(R.string.Blue);
    final String Green = this.getString(R.string.Green);
    final String Brown = this.getString(R.string.Brown);
    final String Purple = this.getString(R.string.Purple);
    final String Orange = this.getString(R.string.Orange);
    final String Yellow = this.getString(R.string.Yellow);
    final String Pink = this.getString(R.string.Pink);
    final String Approaching = this.getString(R.string.Approaching);
    final String min = this.getString(R.string.min);
    
    class loadtrains extends AsyncTask<Void, Void, Void> {
    	
    	ProgressDialog pdLoading = new ProgressDialog(TestStation.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("Loading...");
            pdLoading.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

	try {
	    doc = Jsoup.connect(myUrl).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").get();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Elements elem = doc.select("eta"); 
	iterator = elem.iterator();
	
	String elemn = elem.text();
	
	String findStr = "2013";
	int lastIndex = 0;
	Log.i("MYMESSAGE1", String.valueOf(count));
	while(lastIndex != -1){
		Log.i("MYMESSAGE2", String.valueOf(elemn));
	       lastIndex = elemn.indexOf(findStr,lastIndex);
	       if( lastIndex != -1){
	             count ++;
	             Log.i("MYMESSAGE4", String.valueOf(count));
	             lastIndex+=findStr.length();
	      }
	}
	return null;
        }
        
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pdLoading.dismiss();
	
	int times = (count/2);
	Log.i("MYMESSAGE", String.valueOf(times));
	
	while(iterator.hasNext()){
		
	for (int i=0; i<times;i++){

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

    if(arT.size() > 0 && arT.get(0) != null){
    arrT = arT.get(0);
    }
    if(arT.size() > 1 && arT.get(1) != null){
    arrT1 = arT.get(1);
    }
    if(arT.size() > 2 && arT.get(2) != null){
    arrT2 = arT.get(2);
    }
    if(arT.size() > 3 && arT.get(3) != null){
    arrT3 = arT.get(3);
    }
    if(arT.size() > 4 && arT.get(4) != null){
    arrT4 = arT.get(4);
    }
    if(arT.size() > 5 && arT.get(5) != null){
    arrT5 = arT.get(5);
    }
    if(arT.size() > 6 && arT.get(6) != null){
    arrT6 = arT.get(6);
    }
    if(arT.size() > 7 && arT.get(7) != null){
    arrT7 = arT.get(7);
    }
    if(arT.size() > 8 && arT.get(8) != null){
    arrT8 = arT.get(8);
    }
    if(arT.size() > 9 && arT.get(9) != null){
    arrT9 = arT.get(9);
    }
    if(arT.size() > 10 && arT.get(10) != null){
    arrT10 = arT.get(10);
    }
    if(arT.size() > 11 && arT.get(11) != null){
    arrT11 = arT.get(11);
    }
    if(arT.size() > 12 && arT.get(12) != null){
    arrT12 = arT.get(12);
    }
    if(arT.size() > 13 && arT.get(13) != null){
    arrT13 = arT.get(13);
    }
    if(arT.size() > 14 && arT.get(14) != null){
    arrT14 = arT.get(14);
    }
    if(arT.size() > 15 && arT.get(15) != null){
        arrT15 = arT.get(15);
        }
    if(arT.size() > 16 && arT.get(16) != null){
        arrT16 = arT.get(16);
        }
    
    if(prT.size() > 0 && prT.get(0) != null){
    prdt = prT.get(0);
    }
    if(prT.size() > 1 && prT.get(1) != null){
    prdt1 = prT.get(1);
    }
    if(prT.size() > 2 && prT.get(2) != null){
    prdt2 = prT.get(2);
    }
    if(prT.size() > 3 && prT.get(3) != null){
    prdt3 = prT.get(3);
    }
    if(prT.size() > 4 && prT.get(4) != null){
    prdt4 = prT.get(4);
    }
    if(prT.size() > 5 && prT.get(5) != null){
    prdt5 = prT.get(5);
    }
    if(prT.size() > 6 && prT.get(6) != null){
    prdt6 = prT.get(6);
    }
    if(prT.size() > 7 && prT.get(7) != null){
    prdt7 = prT.get(7);
    }
    if(prT.size() > 8 && prT.get(8) != null){
    prdt8 = prT.get(8);
    }
    if(prT.size() > 9 && prT.get(9) != null){
    prdt9 = prT.get(9);
    }
    if(prT.size() > 10 && prT.get(10) != null){
    prdt10 = prT.get(10);
    }
    if(prT.size() > 11 && prT.get(11) != null){
    prdt11 = prT.get(11);
    }
    if(prT.size() > 12 && prT.get(12) != null){
    prdt12 = prT.get(12);
    }
    if(prT.size() > 13 && prT.get(13) != null){
    prdt13 = prT.get(13);
    }
    if(prT.size() > 14 && prT.get(14) != null){
    prdt14 = prT.get(14);
    }
    if(prT.size() > 15 && prT.get(15) != null){
        prdt15 = prT.get(15);
        }
    if(prT.size() > 16 && prT.get(16) != null){
        prdt16 = prT.get(16);
        }
    
    if(DestNm.size() > 0 && DestNm.get(0) != null){
    String DestNma = DestNm.get(0).text();
    tv1.setText(String.valueOf (DestNma));
    }
    if(DestNm.size() > 1 && DestNm.get(1) != null){
    String DestNm1 = DestNm.get(1).text();
    tv2.setText(String.valueOf (DestNm1));
    }
    if(DestNm.size() > 2 && DestNm.get(2) != null){
    String DestNm2 = DestNm.get(2).text();
    tv4.setText(String.valueOf (DestNm2));
    }
    if(DestNm.size() > 3 && DestNm.get(3) != null){
    String DestNm3 = DestNm.get(3).text();
    tv6.setText(String.valueOf (DestNm3));
    }
    if(DestNm.size() > 4 && DestNm.get(4) != null){
    String DestNm4 = DestNm.get(4).text();
    tv8.setText(String.valueOf (DestNm4));
    }
    if(DestNm.size() > 5 && DestNm.get(5) != null){
    String DestNm5 = DestNm.get(5).text();
    tv10.setText(String.valueOf (DestNm5));
    }
    if(DestNm.size() > 6 && DestNm.get(6) != null){
    String DestNm6 = DestNm.get(6).text();
    tv12.setText(String.valueOf (DestNm6));
    }
    if(DestNm.size() > 7 && DestNm.get(7) != null){
    String DestNm7 = DestNm.get(7).text();
    tv14.setText(String.valueOf (DestNm7));
    }
    if(DestNm.size() > 8 && DestNm.get(8) != null){
    String DestNm8 = DestNm.get(8).text();
    tv16.setText(String.valueOf (DestNm8));
    }
    if(DestNm.size() > 9 && DestNm.get(9) != null){
    String DestNm9 = DestNm.get(9).text();
    tv18.setText(String.valueOf (DestNm9));
    }
    if(DestNm.size() > 10 && DestNm.get(10) != null){
    String DestNm10 = DestNm.get(10).text();
    tv20.setText(String.valueOf (DestNm10));
    }
    if(DestNm.size() > 11 && DestNm.get(11) != null){
    String DestNm11 = DestNm.get(11).text();
    tv22.setText(String.valueOf (DestNm11));
    }
    if(DestNm.size() > 12 && DestNm.get(12) != null){
    String DestNm12 = DestNm.get(12).text();
    tv24.setText(String.valueOf (DestNm12));
    }
    if(DestNm.size() > 13 && DestNm.get(13) != null){
    String DestNm13 = DestNm.get(13).text();
    tv26.setText(String.valueOf (DestNm13));
    }
    if(DestNm.size() > 14 && DestNm.get(14) != null){
    String DestNm14 = DestNm.get(14).text();
    tv28.setText(String.valueOf (DestNm14));
    }
        
    

    if(rta.size() > 0 && rta.get(0) != null){
    Elements Rt = rta.get(0);
    rt = Rt.text();
    }
    if(rta.size() > 1 && rta.get(1) != null){
    Elements Rt1 = rta.get(1);
    rt1 = Rt1.text();
    }
    if(rta.size() > 2 && rta.get(2) != null){
    Elements Rt2 = rta.get(2);
    rt2 = Rt2.text();
    }
    if(rta.size() > 3 && rta.get(3) != null){
    Elements Rt3 = rta.get(3);
    rt3 = Rt3.text();
    }
    if(rta.size() > 4 && rta.get(4) != null){
    Elements Rt4 = rta.get(4);
    rt4 = Rt4.text();
    }
    if(rta.size() > 5 && rta.get(5) != null){
    Elements Rt5 = rta.get(5);
    rt5 = Rt5.text();
    }
    if(rta.size() > 6 && rta.get(6) != null){
    Elements Rt6 = rta.get(6);
    rt6 = Rt6.text();
    }
    if(rta.size() > 7 && rta.get(7) != null){
    Elements Rt7 = rta.get(7);
    rt7 = Rt7.text();
    }
    if(rta.size() > 8 && rta.get(8) != null){
    Elements Rt8 = rta.get(8);
    rt8 = Rt8.text();
    }
    if(rta.size() > 9 && rta.get(9) != null){
    Elements Rt9 = rta.get(9);
    rt9 = Rt9.text();
    }
    if(rta.size() > 10 && rta.get(10) != null){
    Elements Rt10 = rta.get(10);
    rt10 = Rt10.text();
    }
    if(rta.size() > 11 && rta.get(11) != null){
    Elements Rt11 = rta.get(11);
    rt11 = Rt11.text();
    }
    if(rta.size() > 12 && rta.get(12) != null){
    Elements Rt12 = rta.get(12);
    rt12 = Rt12.text();
    }
    if(rta.size() > 13 && rta.get(13) != null){
    Elements Rt13 = rta.get(13);
    rt13 = Rt13.text();
    }
    if(rta.size() > 14 && rta.get(14) != null){
    Elements Rt14 = rta.get(14);
    rt14 = Rt14.text();
    }
    if(rta.size() > 15 && rta.get(15) != null){
        Elements Rt15 = rta.get(15);
        rt15 = Rt15.text();
        }
    if(rta.size() > 16 && rta.get(16) != null){
        Elements Rt16 = rta.get(16);
        rt16 = Rt16.text();
        }
    
    Log.i("MYMESSAGE3", String.valueOf(rta.size()));
    
    if(rt!=null && !rt.isEmpty()){
    if(rt.contains(Red)){
    iv.setImageResource(R.drawable.red);
    }
    if(rt.contains(Blue)){
    iv.setImageResource(R.drawable.blue);
	}
    if(rt.contains(Orange)){
    iv.setImageResource(R.drawable.orange);
	}
    if(rt.contains(Green)){
    iv.setImageResource(R.drawable.green);
	}
    if(rt.contains(Yellow)){
    iv.setImageResource(R.drawable.yellow);
	}
    if(rt.equals(Purple)){
    iv.setImageResource(R.drawable.purple);
	}
    if(rt.contains(Pink)){
    iv.setImageResource(R.drawable.pink);
	}
    if(rt.contains(Brown)){
    iv.setImageResource(R.drawable.brown);
	}
    }
    
    if(rt1!=null && !rt1.isEmpty()){
    if(rt1.contains(Red)){
        iv1.setImageResource(R.drawable.red);
        }
        if(rt1.contains(Blue)){
        iv1.setImageResource(R.drawable.blue);
    	}
        if(rt1.contains(Orange)){
        iv1.setImageResource(R.drawable.orange);
    	}
        if(rt1.contains(Green)){
        iv1.setImageResource(R.drawable.green);
    	}
        if(rt1.contains(Yellow)){
        iv1.setImageResource(R.drawable.yellow);
    	}
        if(rt1.equals(Purple)){
        iv1.setImageResource(R.drawable.purple);
    	}
        if(rt1.contains(Pink)){
        iv1.setImageResource(R.drawable.pink);
    	}
        if(rt1.contains(Brown)){
        iv1.setImageResource(R.drawable.brown);
    	}
    }
    
    if(rt2!=null && !rt2.isEmpty()){
    if(rt2.contains(Red)){
            iv2.setImageResource(R.drawable.red);
            }
            if(rt2.contains(Blue)){
            iv2.setImageResource(R.drawable.blue);
        	}
            if(rt2.contains(Orange)){
            iv2.setImageResource(R.drawable.orange);
        	}
            if(rt2.contains(Green)){
            iv2.setImageResource(R.drawable.green);
        	}
            if(rt2.contains(Yellow)){
            iv2.setImageResource(R.drawable.yellow);
        	}
            if(rt2.equals(Purple)){
            iv2.setImageResource(R.drawable.purple);
        	}
            if(rt2.contains(Pink)){
            iv2.setImageResource(R.drawable.pink);
        	}
            if(rt2.contains(Brown)){
            iv2.setImageResource(R.drawable.brown);
        	}
    }
            
            
    if(rt3!=null && !rt3.isEmpty()){
    if(rt3.contains(Red)){
    iv3.setImageResource(R.drawable.red);
    }
    if(rt3.contains(Blue)){ 
    iv3.setImageResource(R.drawable.blue);
    }
    if(rt3.contains(Orange)){
    iv3.setImageResource(R.drawable.orange);
    }
    if(rt3.contains(Green)){
    iv3.setImageResource(R.drawable.green);
    }
    if(rt3.contains(Yellow)){
    iv3.setImageResource(R.drawable.yellow);
    }
    if(rt3.equals(Purple)){
    iv3.setImageResource(R.drawable.purple);
    }
    if(rt3.contains(Pink)){
    iv3.setImageResource(R.drawable.pink);
    }
    if(rt3.contains(Brown)){
    iv3.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt4!=null && !rt4.isEmpty()){
    if(rt4.contains(Red)){
    iv4.setImageResource(R.drawable.red);
    }
    if(rt4.contains(Blue)){ 
    iv4.setImageResource(R.drawable.blue);
    }
    if(rt4.contains(Orange)){
    iv4.setImageResource(R.drawable.orange);
    }
    if(rt4.contains(Green)){
    iv4.setImageResource(R.drawable.green);
    }
    if(rt4.contains(Yellow)){
    iv4.setImageResource(R.drawable.yellow);
    }
    if(rt4.equals(Purple)){
    iv4.setImageResource(R.drawable.purple);
    }
    if(rt4.contains(Pink)){
    iv4.setImageResource(R.drawable.pink);
    }
    if(rt4.contains(Brown)){
    iv4.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt5!=null && !rt5.isEmpty()){
    if(rt5.contains(Red)){
    iv5.setImageResource(R.drawable.red);
    }
    if(rt5.contains(Blue)){
    iv5.setImageResource(R.drawable.blue);
    }
    if(rt5.contains(Orange)){
    iv5.setImageResource(R.drawable.orange);
    }
    if(rt5.contains(Green)){
    iv5.setImageResource(R.drawable.green);
    }
    if(rt5.contains(Yellow)){
    iv5.setImageResource(R.drawable.yellow);
    }
    if(rt5.equals(Purple)){
    iv5.setImageResource(R.drawable.purple);
    }
    if(rt5.contains(Pink)){
    iv5.setImageResource(R.drawable.pink);
    }
    if(rt5.contains(Brown)){
    iv5.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt6!=null && !rt6.isEmpty()){
    if(rt6.contains(Red)){
    iv6.setImageResource(R.drawable.red);
    }
    if(rt6.contains(Blue)){
    iv6.setImageResource(R.drawable.blue);
    }
    if(rt6.contains(Orange)){
    iv6.setImageResource(R.drawable.orange);
    }
    if(rt6.contains(Green)){
    iv6.setImageResource(R.drawable.green);
    }
    if(rt6.contains(Yellow)){
    iv6.setImageResource(R.drawable.yellow);
    }
    if(rt6.equals(Purple)){
    iv6.setImageResource(R.drawable.purple);
    }
    if(rt6.contains(Pink)){
    iv6.setImageResource(R.drawable.pink);
    }
    if(rt6.contains(Brown)){
    iv6.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt7!=null && !rt7.isEmpty()){
    if(rt7.contains(Red)){
    iv7.setImageResource(R.drawable.red);
    }
    if(rt7.contains(Blue)){
    iv7.setImageResource(R.drawable.blue);
    }
    if(rt7.contains(Orange)){
    iv7.setImageResource(R.drawable.orange);
    }
    if(rt7.contains(Green)){
    iv7.setImageResource(R.drawable.green);
    }
    if(rt7.contains(Yellow)){
    iv7.setImageResource(R.drawable.yellow);
    }
    if(rt7.equals(Purple)){
    iv7.setImageResource(R.drawable.purple);
    }
    if(rt7.contains(Pink)){
    iv7.setImageResource(R.drawable.pink);
    }
    if(rt7.contains(Brown)){
    iv7.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt8!=null && !rt8.isEmpty()){
    if(rt8.contains(Red)){
    iv8.setImageResource(R.drawable.red);
    }
    if(rt8.contains(Blue)){
    iv8.setImageResource(R.drawable.blue);
    }
    if(rt8.contains(Orange)){
    iv8.setImageResource(R.drawable.orange);
    }
    if(rt8.contains(Green)){
    iv8.setImageResource(R.drawable.green);
    }
    if(rt8.contains(Yellow)){
    iv8.setImageResource(R.drawable.yellow);
    }
    if(rt8.equals(Purple)){
    iv8.setImageResource(R.drawable.purple);
    }
    if(rt8.contains(Pink)){
    iv8.setImageResource(R.drawable.pink);
    }
    if(rt8.contains(Brown)){
    iv8.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt9!=null && !rt9.isEmpty()){
    if(rt9.contains(Red)){
    iv9.setImageResource(R.drawable.red);
    }
    if(rt9.contains(Blue)){
    iv9.setImageResource(R.drawable.blue);
    }
    if(rt9.contains(Orange)){
    iv9.setImageResource(R.drawable.orange);
    }
    if(rt9.contains(Green)){
    iv9.setImageResource(R.drawable.green);
    }
    if(rt9.contains(Yellow)){
    iv9.setImageResource(R.drawable.yellow);
    }
    if(rt9.equals(Purple)){
    iv9.setImageResource(R.drawable.purple);
    }
    if(rt9.contains(Pink)){
    iv9.setImageResource(R.drawable.pink);
    }
    if(rt9.contains(Brown)){
    iv9.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt10!=null && !rt10.isEmpty()){
    if(rt10.contains(Red)){
    iv10.setImageResource(R.drawable.red);
    }
    if(rt10.contains(Blue)){
    iv10.setImageResource(R.drawable.blue);
    }
    if(rt10.contains(Orange)){
    iv10.setImageResource(R.drawable.orange);
    }
    if(rt10.contains(Green)){
    iv10.setImageResource(R.drawable.green);
    }
    if(rt10.contains(Yellow)){
    iv10.setImageResource(R.drawable.yellow);
    }
    if(rt10.equals(Purple)){
    iv10.setImageResource(R.drawable.purple);
    }
    if(rt10.contains(Pink)){
    iv10.setImageResource(R.drawable.pink);
    }
    if(rt10.contains(Brown)){
    iv10.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt11!=null && !rt11.isEmpty()){
    if(rt11.contains(Red)){
    iv11.setImageResource(R.drawable.red);
    }
    if(rt11.contains(Blue)){
    iv11.setImageResource(R.drawable.blue);
    }
    if(rt11.contains(Orange)){
    iv11.setImageResource(R.drawable.orange);
    }
    if(rt11.contains(Green)){
    iv11.setImageResource(R.drawable.green);
    }
    if(rt11.contains(Yellow)){
    iv11.setImageResource(R.drawable.yellow);
    }
    if(rt11.equals(Purple)){
    iv11.setImageResource(R.drawable.purple);
    }
    if(rt11.contains(Pink)){
    iv11.setImageResource(R.drawable.pink);
    }
    if(rt11.contains(Brown)){
    iv11.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt12!=null && !rt12.isEmpty()){
    if(rt12.contains(Red)){
    iv12.setImageResource(R.drawable.red);
    }
    if(rt12.contains(Blue)){
    iv12.setImageResource(R.drawable.blue);
    }
    if(rt12.contains(Orange)){
    iv12.setImageResource(R.drawable.orange);
    }
    if(rt12.contains(Green)){
    iv12.setImageResource(R.drawable.green);
    }
    if(rt12.contains(Yellow)){
    iv12.setImageResource(R.drawable.yellow);
    }
    if(rt12.equals(Purple)){
    iv12.setImageResource(R.drawable.purple);
    }
    if(rt12.contains(Pink)){
    iv12.setImageResource(R.drawable.pink);
    }
    if(rt12.contains(Brown)){
    iv12.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt13!=null && !rt13.isEmpty()){
    if(rt13.contains(Red)){
    iv13.setImageResource(R.drawable.red);
    }
    if(rt13.contains(Blue)){
    iv13.setImageResource(R.drawable.blue);
    }
    if(rt13.contains(Orange)){
    iv13.setImageResource(R.drawable.orange);
    }
    if(rt13.contains(Green)){
    iv13.setImageResource(R.drawable.green);
    }
    if(rt13.contains(Yellow)){
    iv13.setImageResource(R.drawable.yellow);
    }
    if(rt13.equals(Purple)){
    iv13.setImageResource(R.drawable.purple);
    }
    if(rt13.contains(Pink)){
    iv13.setImageResource(R.drawable.pink);
    }
    if(rt13.contains(Brown)){
    iv13.setImageResource(R.drawable.brown);
    }
    }
    
    if(rt14!=null && !rt14.isEmpty()){
    if(rt14.contains(Red)){
    iv14.setImageResource(R.drawable.red);
    }
    if(rt14.contains(Blue)){
    iv14.setImageResource(R.drawable.blue);
    }
    if(rt14.contains(Orange)){
    iv14.setImageResource(R.drawable.orange);
    }
    if(rt14.contains(Green)){
    iv14.setImageResource(R.drawable.green);
    }
    if(rt14.contains(Yellow)){
    iv14.setImageResource(R.drawable.yellow);
    }
    if(rt14.equals(Purple)){
    iv14.setImageResource(R.drawable.purple);
    }
    if(rt14.contains(Pink)){
    iv14.setImageResource(R.drawable.pink);
    }
    if(rt14.contains(Brown)){
    iv14.setImageResource(R.drawable.brown);
    }
    }
    
    try {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    	SimpleDateFormat sdf1 = new SimpleDateFormat("mm:00");
    	
    	if(arrT!=null && !arrT.isEmpty()){
        Date date1 = sdf.parse(arrT.text());
        Date date2 = sdf.parse(prdt.text());
        long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
        String dateDif = sdf1.format(dateDiff);
        
        if(String.valueOf(dateDif).equals(min)) {
        	tv.setText(String.valueOf (Approaching));
        }
        else{
	    tv.setText(String.valueOf (dateDif));
    	}
    	}
    	
    	if(arrT1!=null && !arrT1.isEmpty()){
            Date date3 = sdf.parse(arrT1.text());
            Date date4 = sdf.parse(prdt1.text());
            long dateDiff = (date3.getTime() - date4.getTime())>0 ? (date3.getTime() - date4.getTime()) :(date4.getTime() - date3.getTime());
            String dateDif = sdf1.format(dateDiff);
            if(String.valueOf(dateDif).equals(min)) {
            	tv3.setText(String.valueOf (Approaching));
            }
            else{
    	    tv3.setText(String.valueOf (dateDif));
        	}
        	}
    	
    	if(arrT2!=null && !arrT2.isEmpty()){
            Date date1 = sdf.parse(arrT2.text());
            Date date2 = sdf.parse(prdt2.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
            if(String.valueOf(dateDif).equals(min)) {
            	tv5.setText(String.valueOf (Approaching));
            }
            else{
    	    tv5.setText(String.valueOf (dateDif));
        	}
        	}
    	
    	if(arrT3!=null && !arrT3.isEmpty()){
            Date date1 = sdf.parse(arrT3.text());
            Date date2 = sdf.parse(prdt3.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv7.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT4!=null && !arrT4.isEmpty()){
            Date date1 = sdf.parse(arrT4.text());
            Date date2 = sdf.parse(prdt4.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv9.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT5!=null && !arrT5.isEmpty()){
            Date date1 = sdf.parse(arrT5.text());
            Date date2 = sdf.parse(prdt5.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv11.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT6!=null && !arrT6.isEmpty()){
            Date date1 = sdf.parse(arrT6.text());
            Date date2 = sdf.parse(prdt6.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv13.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT7!=null && !arrT7.isEmpty()){
            Date date1 = sdf.parse(arrT7.text());
            Date date2 = sdf.parse(prdt7.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv15.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT8!=null && !arrT8.isEmpty()){
            Date date1 = sdf.parse(arrT8.text());
            Date date2 = sdf.parse(prdt8.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv17.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT9!=null && !arrT9.isEmpty()){
            Date date1 = sdf.parse(arrT9.text());
            Date date2 = sdf.parse(prdt.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv19.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT10!=null && !arrT10.isEmpty()){
            Date date1 = sdf.parse(arrT10.text());
            Date date2 = sdf.parse(prdt10.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv21.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT11!=null && !arrT11.isEmpty()){
            Date date1 = sdf.parse(arrT11.text());
            Date date2 = sdf.parse(prdt11.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv23.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT12!=null && !arrT12.isEmpty()){
            Date date1 = sdf.parse(arrT12.text());
            Date date2 = sdf.parse(prdt12.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv25.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT13!=null && !arrT13.isEmpty()){
            Date date1 = sdf.parse(arrT13.text());
            Date date2 = sdf.parse(prdt13.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv27.setText(String.valueOf (dateDif));
        	}
    	
    	if(arrT14!=null && !arrT14.isEmpty()){
            Date date1 = sdf.parse(arrT14.text());
            Date date2 = sdf.parse(prdt14.text());
            long dateDiff = (date1.getTime() - date2.getTime())>0 ? (date1.getTime() - date2.getTime()) :(date2.getTime() - date1.getTime());
            String dateDif = sdf1.format(dateDiff);
    	    tv29.setText(String.valueOf (dateDif));
        	}
	    }

    catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	}
    }
    new loadtrains().execute();
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
