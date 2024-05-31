package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class ExternalStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
    }

    public void saveCredentials(View view) {
        EditText usr = (EditText) findViewById(R.id.exUsr);
        EditText pwd = (EditText) findViewById(R.id.exPwd);

        File sdir = Environment.getExternalStorageDirectory();

        try {
            File uinfo = new File(sdir.getAbsolutePath() + "/.uinfo.txt");
            uinfo.setReadable(true);
            uinfo.setWritable(true);
            FileWriter fw = new FileWriter(uinfo);
            fw.write(usr.getText().toString() + ":" + pwd.getText().toString() + "\n");
            fw.close();
            Toast.makeText(this, "3rd party credentials saved successfully!", Toast.LENGTH_SHORT).show();
            // Now you can read the temporary file where ever the credentials are required.
        }
        catch (Exception e) {
            Toast.makeText(this, "File error occurred", Toast.LENGTH_SHORT).show();
            Log.d("Diva", "File error: " + e.getMessage());
        }
    }

    public static class EndpointVerifyActivity extends AppCompatActivity {

        private static final String BAIDU_URL = "https://www.cctv.com/";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_endpoint_verify);

            WebView webView = findViewById(R.id.webView);
            WebSettings webSettings = webView.getSettings();
            // webSettings.setJavaScriptEnabled(true);

            webView.loadUrl(BAIDU_URL);
        }
    }
}