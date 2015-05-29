package com.dev.chicagotraintracker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class TestStation extends Activity {
    Elements arT;
    Elements prT;
    Elements DestNm;
    Elements rta;

    String stationtext;

    SwipeRefreshLayout mSwipeRefreshLayout;
    SparseArray<Integer[]> textViewMap = new SparseArray<>();

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    void checkAndExecuteIfOnline (final boolean hadInternet) {
        if (isOnline()) {
            new loadtrains().execute();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (hadInternet) {
                        // we don't need to do anything here since the user had internet at one time (the original load)
                    }
                    else {
                        finish();
                        TestStation.this.overridePendingTransition(0, android.R.anim.fade_out);
                    }
                }
            });
            builder.setMessage("You're not connected to the internet. Connect to the internet and try again.")
                    .setTitle("You're not connected");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_station);
        textViewMap.put(0, new Integer[] {R.id.tv, R.id.tv1, R.id.imageView});
        textViewMap.put(1, new Integer[] {R.id.tv2, R.id.tv3, R.id.imageView1});
        textViewMap.put(2, new Integer[] {R.id.tv4, R.id.tv5, R.id.imageView2});
        textViewMap.put(3, new Integer[] {R.id.tv6, R.id.tv7, R.id.imageView3});
        textViewMap.put(4, new Integer[] {R.id.tv8, R.id.tv9, R.id.imageView4});
        textViewMap.put(5, new Integer[] {R.id.tv10, R.id.tv11, R.id.imageView5});
        textViewMap.put(6, new Integer[] {R.id.tv12, R.id.tv13, R.id.imageView6});
        textViewMap.put(7, new Integer[] {R.id.tv14, R.id.tv15, R.id.imageView7});
        textViewMap.put(8, new Integer[] {R.id.tv16, R.id.tv17, R.id.imageView8});
        textViewMap.put(9, new Integer[] {R.id.tv18, R.id.tv19, R.id.imageView9});
        textViewMap.put(10, new Integer[] {R.id.tv20, R.id.tv21, R.id.imageView10});
        textViewMap.put(11, new Integer[] {R.id.tv22, R.id.tv23, R.id.imageView11});
        textViewMap.put(12, new Integer[] {R.id.tv24, R.id.tv25, R.id.imageView12});
        textViewMap.put(13, new Integer[] {R.id.tv26, R.id.tv27, R.id.imageView13});
        textViewMap.put(14, new Integer[] {R.id.tv28, R.id.tv29, R.id.imageView14});

        getActionBar().setDisplayHomeAsUpEnabled(true);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                checkAndExecuteIfOnline(true);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        checkAndExecuteIfOnline(false);
    }

    class loadtrains extends AsyncTask<Void, Void, Void> {
        String myUrl;
        Document doc = null;
        ProgressDialog pdLoading = new ProgressDialog(TestStation.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("Loading...");
            pdLoading.show();

            Intent intent = getIntent();
            String value = intent.getExtras().getString("value");
            stationtext = intent.getExtras().getString("station");

            ActionBar ab = getActionBar();
            ab.setTitle(stationtext);

            myUrl = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=201412abc85d49b2b83f907f9e329eaa&mapid="+value;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                doc = Jsoup.connect(myUrl).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").parser(Parser.xmlParser()).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            final String Approaching = getString(R.string.Approaching);
            final String min = getString(R.string.min);

            arT = doc.select("arrT");
            prT = doc.select("prdt");
            DestNm = doc.select("destNm");
            rta = doc.select("rt");

            int num = -1;
            for(Element elemnarrt : arT){
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
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Log.i("text", stringrt);
                if (stringrt.contains(getString(R.string.Red))) {
                    color = com.dev.chicagotraintracker.R.drawable.red;
                } else if(stringrt.contains(getString(R.string.Blue))){
                    color = com.dev.chicagotraintracker.R.drawable.blue;
                } else if(stringrt.contains(getString(R.string.Orange))){
                    color = com.dev.chicagotraintracker.R.drawable.orange;
                } else if(stringrt.contains(getString(R.string.Green))){
                    color = com.dev.chicagotraintracker.R.drawable.green;
                } else if(stringrt.contains(getString(R.string.Yellow))){
                    color = com.dev.chicagotraintracker.R.drawable.yellow;
                } else if(stringrt.equals(getString(R.string.Purple))){
                    color = com.dev.chicagotraintracker.R.drawable.purple;
                } else if(stringrt.contains(getString(R.string.Pink))){
                    color = com.dev.chicagotraintracker.R.drawable.pink;
                } else if(stringrt.contains(getString(R.string.Brown))){
                    color = com.dev.chicagotraintracker.R.drawable.brown;
                }
                Integer[] textViewInteger = textViewMap.get(num);
                TextView textView1 = (TextView) findViewById(textViewInteger[0]);
                TextView textView2 = (TextView) findViewById(textViewInteger[1]);
                ImageView imageView = (ImageView) findViewById(textViewInteger[2]);

                textView1.setText(destnm);
                imageView.setImageResource(color);
                if (dateDif.equals(min)) {
                    textView2.setText(Approaching);
                } else {
                    textView2.setText(dateDif);
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
}