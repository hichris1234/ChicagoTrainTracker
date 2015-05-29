package com.dev.chicagotraintracker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class Delay extends Activity {

    SwipeRefreshLayout mSwipeRefreshLayout;
    String URL;
    Document doc;
    Elements alerts;
    Elements names;
    Elements starts;
    ListView lv;

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    void checkAndExecuteIfOnline (final boolean hadInternet) {
        if (isOnline()) {
            new loaddelays().execute();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (hadInternet) {
                        // we don't need to do anything here since the user had internet at one time (the original load)
                    }
                    else {
                        finish();
                        Delay.this.overridePendingTransition(0, android.R.anim.fade_out);
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
        setContentView(R.layout.delay);
        lv = (ListView) findViewById(R.id.lv);

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

    public void takeItBack(String result) {
        ArrayList<CustomObject> objects = new ArrayList<CustomObject>();
        int num = -1;
        for (Element elemalert : alerts) {
            num++;
            String alert = elemalert.text();
            String name = names.get(num).text();
            String start = starts.get(num).text();
            String formatstart = null;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd HH:mm");
            SimpleDateFormat dateFormat3 = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
            try {
                if (start.length() == 8) {
                    formatstart = dateFormat1.format(dateFormat.parse(start));
                } else {
                    formatstart = dateFormat3.format(dateFormat2.parse(start));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            objects.add(new CustomObject(name, alert, formatstart));
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
                try {
                    doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").parser(Parser.xmlParser()).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                long startTime = System.nanoTime();

                names = doc.select("ServiceName");
                alerts = doc.select("ShortDescription");
                starts = doc.select("EventStart");

                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                Log.i("time", String.valueOf(duration));
                pdLoading.dismiss();
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