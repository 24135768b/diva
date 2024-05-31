package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.lang.Runtime;
import android.util.Log;
import android.widget.Toast;
import android.view.View;
import java.io.InputStream;

public class RuntimeExecCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_exec_check);
        // CheckRunTime();
    }

    public void CheckRunTime(View view) {
        try {
            Runtime rt = Runtime.getRuntime();

            Process proc = rt.exec("/system/bin/ls /data/data/com.example.mynewdivabeta");
            int exitVal = proc.exitValue();
            if (exitVal != 0) {
                String err = "";
                InputStream error = proc.getErrorStream();
                int c = 0;
                for (int i = 0; i < error.available() + 25; i++) {
                    err += (char) error.read();
                }
                Log.d("Diva", "Error stream: " + err);
            }
            Log.d("Diva", "Process exitValue: " + exitVal);
            Toast.makeText(getApplicationContext(), "runtime exec",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Diva", "exception: " + e);
            Toast.makeText(getApplicationContext(), "exception",
                    Toast.LENGTH_SHORT).show();
        }
    }
}