package com.dev.chicagotraintracker;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
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
     String selectedValue1;
     String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_list);

        final DatabaseHelper db = new DatabaseHelper(this);

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

        tv0.setText(Red_Line);

        // Show the Up button in the action bar.
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
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
                tv11.setText(selectedValue);
                if(selectedValue.equals(Red_Line)){
                    ArrayAdapter<String> firstAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,RedLin);
                    Spinner2.setAdapter(firstAdapter);
                }
                else if(selectedValue.equals(Blue_Line)){
                    ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,BlueLin);
                    Spinner2.setAdapter(SecondAdapter);
                }
                else if(selectedValue.equals(Green_Line)){
                    ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,GreenLin);
                    Spinner2.setAdapter(SecondAdapter);
                }
                else if(selectedValue.equals(Orange_Line)){
                    ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,OrangeLin);
                    Spinner2.setAdapter(SecondAdapter);
                }
                else if(selectedValue.equals(Brown_Line)){
                    ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,BrownLin);
                    Spinner2.setAdapter(SecondAdapter);
                }
                else if(selectedValue.equals(Pink_Line)){
                    ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,PinkLin);
                    Spinner2.setAdapter(SecondAdapter);
                }
                else if(selectedValue.equals(Purple_Line)){
                    ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,PurpleLin);
                    Spinner2.setAdapter(SecondAdapter);
                }
                else if(selectedValue.equals(Yellow_Line)){
                    ArrayAdapter<String> SecondAdapter = new ArrayAdapter<String>(StationList.this,android.R.layout.simple_spinner_dropdown_item,YellowLin);
                    Spinner2.setAdapter(SecondAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // there should never be nothing selected
            }
        });

        Spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String line = null;

                if(selectedValue.equals(Red_Line)){
                    line = "Red";
                }
                else if(selectedValue.equals(Blue_Line)){
                    line = "Blue";
                }
                else if(selectedValue.equals(Green_Line)){
                    line = "Green";
                }
                else if(selectedValue.equals(Orange_Line)){
                    line = "Orange";
                }
                else if(selectedValue.equals(Brown_Line)){
                    line = "Brown";
                }
                else if(selectedValue.equals(Pink_Line)){
                    line = "Pink";
                }
                else if(selectedValue.equals(Purple_Line)){
                    line = "Purple";
                }
                else if(selectedValue.equals(Yellow_Line)){
                    line = "Yellow";
                }

                selectedValue1 = arg0.getItemAtPosition(arg2).toString();
                String[] id = {"Id"};
                String query = "StationName = '"+selectedValue1+"' AND "+line+" = 1";
                Cursor station = db.executeQuery(id, query);
                for (station.moveToFirst(); !station.isAfterLast(); station.moveToNext()) {
                    Log.i("station", "Station Name: "+selectedValue1+" Id: "+station.getString(station.getColumnIndex("Id")));
                    value = station.getString(station.getColumnIndex("Id"));
                }
                tv12.setText(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // there should never be nothing selected
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
        Intent9.putExtra("station", selectedValue1);
        startActivityForResult(Intent9, 0); 
    }

}