package com.example.arnec.demobap;

import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {

    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        info = (TextView) findViewById(R.id.info);

        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        int batIsCharigng = bm.getIntProperty(BatteryManager.BATTERY_STATUS_NOT_CHARGING);
        info.setText("Batterij level: " + batLevel + " Aan het opladen? " + batIsCharigng);
    }
}
