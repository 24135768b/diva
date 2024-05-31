package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.content.ContentResolver;
import android.provider.Settings.Secure;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import static android.Manifest.permission.READ_PHONE_NUMBERS;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;

public class TelecommunicationActivity extends AppCompatActivity {
    private TelephonyManager telecommMgr;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telecommunication);
    }

    public void GetImei() {
        String imeiString, adidString;
        try {
            TextView checkimei = (TextView) findViewById(R.id.imeiId);
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            imeiString = telecommMgr.getImei();
            if (imeiString != null) {
                checkimei.setText("Imei ID: " + imeiString);
            } else {
                checkimei.setText("NULL imei ID");
            }
            // } else {
            // requestPermission();
            // }
        } catch (SecurityException e) {
            Log.d("Diva", "get imei error:" + e.getMessage());
        }
    }

    public void GetMeid() {
        String meidstring;
        try {
            TextView checkmeid = (TextView) findViewById(R.id.meidId);
            meidstring = telecommMgr.getMeid();
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (meidstring != null) {
                checkmeid.setText("Meid: " + meidstring);
            } else {
                checkmeid.setText("NULL meid ID");
            }
            // } else {
            // requestPermission();
            // }
        } catch (SecurityException e) {
            Log.d("Diva", "get meid error:" + e.getMessage());
        }
    }

    public void GetLine1Number() {
        try {
            TextView checkLine1Number = (TextView) findViewById(R.id.line1numberId);
            // if (ActivityCompat.checkSelfPermission(this, READ_SMS) ==
            // PackageManager.PERMISSION_GRANTED &&
            // ActivityCompat.checkSelfPermission(this, READ_PHONE_NUMBERS) ==
            // PackageManager.PERMISSION_GRANTED
            // && ActivityCompat.checkSelfPermission(this,
            // READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            // Toast.makeText(getApplicationContext(), "into permission check",
            // Toast.LENGTH_SHORT).show();
            String Line1NumberString = telecommMgr.getLine1Number();

            checkLine1Number.setText(Line1NumberString);
            return;
            // } else {
            // requestPermission();
            // }
        } catch (SecurityException e) {
            Log.d("Diva", "get line 1 number error:" + e.getMessage());
        }
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] { READ_SMS, READ_PHONE_NUMBERS, READ_PHONE_STATE }, 1010);
        }
    }

    public void GetDeviceId() {
        try {
            String deviceIdString = telecommMgr.getDeviceId();
            TextView checkdeviceId = (TextView) findViewById(R.id.deviceIdId);
            if (deviceIdString == null) {
                checkdeviceId.setText("NULL deviceId");
            } else {
                checkdeviceId.setText("Device ID :" + deviceIdString);
            }
        } catch (SecurityException e) {
            Log.d("Diva", "get deviced id error:" + e.getMessage());
        }
    }

    public void GetSubscriberId() {
        try {
            String SubscriberIdString = telecommMgr.getSubscriberId();
            TextView checkSubscriberId = (TextView) findViewById(R.id.subscribeIdId);
            if (SubscriberIdString == null) {
                checkSubscriberId.setText("NULL SubscriberId");
            } else {
                checkSubscriberId.setText("Device ID :" + SubscriberIdString);
            }
        } catch (SecurityException e) {
            Log.d("Diva", "get subscriber id error:" + e.getMessage());
        }
    }

    public void GetNetCountyISO() {
        try {
            String NetCountyISOString = telecommMgr.getNetworkCountryIso();
            TextView checkNetCountyISO = (TextView) findViewById(R.id.NetCountyISOId);

            if (NetCountyISOString == null) {
                checkNetCountyISO.setText("NULL NetworkCountryIso");
            } else {
                checkNetCountyISO.setText("ISO: " + NetCountyISOString);
            }
        } catch (SecurityException e) {
            Log.d("Diva", "get county iso error:" + e.getMessage());
        }
    }

    public void GetNetworkOperator() {
        try {
            String NetworkOperatorString = telecommMgr.getNetworkOperator();
            TextView checkNetworkOperator = (TextView) findViewById(R.id.networkOPId);

            if (NetworkOperatorString == null) {
                checkNetworkOperator.setText("NULL NetworkOperator");
            } else {
                checkNetworkOperator.setText("Operator: " + NetworkOperatorString);
            }
        } catch (SecurityException e) {
            Log.d("Diva", "get network operator error:" + e.getMessage());
        }
    }

    public void GetNetworkOperatorName() {
        try {
            String NetworkOperatorNameString = telecommMgr.getNetworkOperatorName();
            TextView checkNetworkOperatorName = (TextView) findViewById(R.id.networkOPnameId);

            if (NetworkOperatorNameString == null) {
                checkNetworkOperatorName.setText("NULL NetworkOperatorName");
            } else {
                checkNetworkOperatorName.setText("Operator Name: " + NetworkOperatorNameString);
            }
        } catch (SecurityException e) {
            Log.d("Diva", "get network operator name error:" + e.getMessage());
        }
    }

    public void Telecommunication(View view) {

        telecommMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        GetImei();
        GetMeid();
        GetLine1Number();
        GetDeviceId();
        GetSubscriberId();
        GetNetCountyISO();
        GetNetworkOperator();
        GetNetworkOperatorName();
    }
}