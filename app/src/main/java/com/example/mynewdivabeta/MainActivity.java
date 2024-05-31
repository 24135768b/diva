package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startChallenge(View view){

        if (view == findViewById(R.id.d1button)) {
            Intent i = new Intent(this, CheckScreenshotDisableActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d2button)) {
            Intent i = new Intent(this, RuntimeExecCheckActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d3button)) {
            Intent i = new Intent(this, CheckKeyStoreNullPwdHardcorePwdActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d4button)) {
            Intent i = new Intent(this, HttpCheckingInUrlActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d5button)) {
            Intent i = new Intent(this, WebViewSetJavaScriptEnabledPotentialXSSActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d6button)) {
            Intent i = new Intent(this, WebviewAllowFileAccessActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d7button)) {
            Intent i = new Intent(this, GetAndroidIDWithSecureStringActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d8button)) {
            Intent i = new Intent(this, CheckBase64StringActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d9button)) {
            Intent i = new Intent(this, AllowAllHostnameVerifierActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d10button)) {
            Intent i = new Intent(this,CheckSecurityMethodAndCipherActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d11button)) {
            Intent i = new Intent(this, WebviewPasswordStorageInPlaintextActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d12button)) {
            Intent i = new Intent(this, SQLInjectionActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d13button)) {
            Intent i = new Intent(this, InternalStorageActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d14button)) {
            Intent i = new Intent(this, ExternalStorageActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d15button)) {
            Intent i = new Intent(this, FileDeleteActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d16button)) {
            Intent i = new Intent(this, SecureRandomSeedActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d17button)) {
            Intent i = new Intent(this, TelecommunicationActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d18button)) {
            Intent i = new Intent(this, SendSMSActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d19button)) {
            Intent i = new Intent(this, LogActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d20button)) {
            Intent i = new Intent(this, WriteReadClipboardActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d21button)) {
            Intent i = new Intent(this, SSLCertificateInformationActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d22button)) {
            Intent i = new Intent(this, StrandHogg1_0Activity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d23button)) {
            Intent i = new Intent(this, RepeatUseCryptoKeyActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d24button)) {
            Intent i = new Intent(this, InsecureRandomActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d25button)) {
            Intent i = new Intent(this, UseSetWebviewClientActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d26button)) {
            Intent i = new Intent(this, OverlayAttackDefenceActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d27button)) {
            Intent i = new Intent(this, EndPointActivity.class);
            startActivity(i);
        } else if (view == findViewById(R.id.d28button)) {
            Intent i = new Intent(this, WebviewAddJavascriptInterface.class);
            startActivity(i);
        }
    }
}

/*
complete 1. CheckScreenshotDisableActivity
complete 5. HttpCheckingInUrlActivity
complete 6. WebViewSetJavaScriptEnabledPotentialXSSActivity
complete 14. SQLInjectionActivity
complete 16. ExternalStorageActivity
complete 18. SecureRandomSeedActivity
complete 21. LogActivity
complete 22. WriteReadClipboardActivity
complete 23. WriteReadClipboardActivity
complete 26. RepeatUseCryptoKeyActivity
complete 28. UseSetWebviewClientActivity
complete 29. OverlayAttackDefenceActivity
 */