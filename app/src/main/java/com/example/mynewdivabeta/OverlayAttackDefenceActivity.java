package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class OverlayAttackDefenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlay_attack_defence);

        // button 1 setFilterTouchesWhenObscured
        Button btn = (Button) findViewById(R.id.oadbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setFilterTouchesWhenObscured(true);
                Toast.makeText(view.getContext(), "setFilterTouchesWhenObscured setup true", Toast.LENGTH_LONG).show();
            }
        });
    }

    // setup 3 FLAG: FLAG_WATCH_OUTSIDE_TOUCH, FLAG_NOT_FOCUSABLE, FLAG_NOT_TOUCH_MODAL
    public void vulnerable(View view){
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.RIGHT | Gravity.TOP;
        params.setTitle("Load Average");
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,0);
        window.addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        Toast.makeText(this, "3 FLAG setup", Toast.LENGTH_LONG).show();
    }
}