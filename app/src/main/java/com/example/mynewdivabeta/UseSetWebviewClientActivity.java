package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class UseSetWebviewClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_set_webview_client);
    }

    public void get(View view){
        EditText uriText = (EditText) findViewById(R.id.setwviewuri);
        WebView wview = (WebView) findViewById(R.id.setwview);
        wview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
        wview.loadUrl(uriText.getText().toString());
    }
}