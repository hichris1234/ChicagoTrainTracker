package com.dev.chicagotraintracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
  
    public void sendMessage(View v) {
        Intent myIntent = new Intent(MainActivity.this, Screenmap.class);
        startActivityForResult(myIntent, 0);
    }
    
    public void sendStation(View x) {
        Intent Intent1 = new Intent(MainActivity.this, StationList.class);
        startActivityForResult(Intent1, 0); 
    }
    
    public void sendDelay(View y) {
        Intent Intent2 = new Intent(MainActivity.this, Delay.class);
        startActivityForResult(Intent2, 0); 
    }
    
    public void sendTrip(View z) {
        Intent Intent3 = new Intent(MainActivity.this, Tripplanner.class);
        startActivityForResult(Intent3, 0); 
    }
    
    public void sendNearest(View w) {
        Intent Intent4 = new Intent(MainActivity.this, Neareststations.class);
        startActivityForResult(Intent4, 0); 
    }
}
