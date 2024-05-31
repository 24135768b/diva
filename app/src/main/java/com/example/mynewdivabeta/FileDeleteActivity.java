package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

// import android.Manifest;
// import android.content.Context;
// import android.content.pm.PackageManager;
// import androidx.core.app.ActivityCompat;
// import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;
//import java.lang.invoke.ClassSpecializer.Factory;

import android.util.Log;

public class FileDeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_delete);
        iotest();
    }

    public void iotest() {
        // create new file
        File sdir = Environment.getDataDirectory();
        boolean bool;
        boolean bool2;
        try {
            // checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, 101);
            File f = new File("/data/data/com.example.mynewdivabeta/test.txt");
            bool = f.createNewFile();
            if (bool) {
                Log.d("Diva", "create new file return true");
            } else {
                Log.d("Diva", "Failed to create new file");
            }
            bool2 = f.delete();
            if (bool2) {
                Log.d("Diva", "delete return true");
            } else {
                Log.d("Diva", "Failed to delete the file");
            }
            Toast.makeText(getApplicationContext(), "delete fin",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Diva", "create new file error: " + e.getMessage());
            Toast.makeText(getApplicationContext(), "exception",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public static void Delete() {
        File f = new File("filename.txt");
        if (f.delete()) {
            Log.d("Diva", "delete return true");
        } else {
            Log.d("Diva", "Failed to delete the file");
        }
    }

    // public void checkPermission(String permission, int requestCode) {
    // if (ContextCompat.checkSelfPermission(this.activity, permission) ==
    // PackageManager.PERMISSION_DENIED) {
    // ActivityCompat.requestPermissions(this.activity, new String[] { permission },
    // requestCode);
    // } else {
    // Toast.makeText(this.activity, "Permission already granted",
    // Toast.LENGTH_SHORT).show();
    // }
    // }
}