package com.example.arnec.demobap;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Netwerk extends AppCompatActivity {

    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netwerk);

        TextView info = (TextView) findViewById(R.id.info);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager mTelephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            info.setText(activeNetwork.getTypeName() + " " + activeNetwork.getExtraInfo());


            int networkType = mTelephonyManager.getNetworkType();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    info.setText(activeNetwork.getTypeName() + " " + activeNetwork.getExtraInfo() + "2g");
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    info.setText(activeNetwork.getTypeName() + " " + activeNetwork.getExtraInfo() + "3g");
                case TelephonyManager.NETWORK_TYPE_LTE:
                    info.setText(activeNetwork.getTypeName() + " " + activeNetwork.getExtraInfo() + "4g");
            }
        } else {
            // not connected to the internet
            info.setText("Geen internetverbinding");
        }
    }
}
