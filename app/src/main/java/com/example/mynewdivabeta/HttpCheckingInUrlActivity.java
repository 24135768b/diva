package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class HttpCheckingInUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_checking_in_url);
    }

    public void get(View view) {
        EditText uriText = (EditText) findViewById(R.id.httpckuri);
        WebView wview = (WebView) findViewById(R.id.httpckwview);

        // hook loadUrl to check use https
        wview.loadUrl(uriText.getText().toString());
    }
}