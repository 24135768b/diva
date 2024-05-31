package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

public class WebViewSetJavaScriptEnabledPotentialXSSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_set_java_script_enabled_potential_xssactivity);

        WebView wview = (WebView) findViewById(R.id.wviewXSS);
        WebSettings wset = wview.getSettings();

        // potential XSS attack
        wset.setJavaScriptEnabled(true);
        wview.getSettings().setJavaScriptEnabled(true);
    }

    public void get(View view) {
        EditText uriText = (EditText) findViewById(R.id.wviewXSSuri);
        WebView wview = (WebView) findViewById(R.id.wviewXSS);

        wview.loadUrl(uriText.getText().toString());
    }
}