package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.content.ContentResolver;
import android.view.View;
import android.widget.TextView;

public class GetAndroidIDWithSecureStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_android_idwith_secure_string);
    }

    public void checkAndroidID(View view) {
        String adidString = Secure.getString(
                getContentResolver(), Secure.ANDROID_ID);

        TextView checkand = (TextView) findViewById(R.id.andId);

        if (adidString != null) {
            checkand.setText("Android ID: " + adidString);
        } else {
            checkand.setText("NULL android ID");
        }
    }
}