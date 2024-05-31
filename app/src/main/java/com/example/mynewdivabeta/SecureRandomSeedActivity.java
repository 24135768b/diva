package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.security.SecureRandom;

public class SecureRandomSeedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_random_seed);
    }

    // many sourcecode call Random(), but Random is insecure
    // I have no idea how to deal with this problem.
    public void getRandomNumber(View view){
        TextView textView = (TextView) findViewById(R.id.showRandSeedView);
        Random number = new Random();
        number.setSeed(123); // Specifying the seed value may reduce randomness
        String number2Str = Integer.toString(number.nextInt());
        textView.setText(number2Str);
    }

    // Don't set seed by yourself. It's insecure
    public void getSecureRandomNumber(View view){
        TextView textView = (TextView) findViewById(R.id.showRandSeedView);
//        byte[] bytes = new byte[20];
        SecureRandom secure_number = new SecureRandom();
        secure_number.setSeed(20); // Specifying the seed value may reduce randomness
//        secure_number.setSeed(bytes);
        String sNumber2Str = Integer.toString(secure_number.nextInt());
        textView.setText(sNumber2Str);
    }
}