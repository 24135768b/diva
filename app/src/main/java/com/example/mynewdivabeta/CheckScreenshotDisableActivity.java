package com.example.mynewdivabeta;


import static android.view.WindowManager.LayoutParams.FLAG_SECURE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CheckScreenshotDisableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_screenshot_disable);

        // FLAG_SECURE can disable screenshot
        Window window = getWindow();
        window.addFlags(FLAG_SECURE);
    }
}