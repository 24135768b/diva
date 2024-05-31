package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;

public class CheckSecurityMethodAndCipherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_security_method_and_cipher);
    }

    public void checkciphertype(View view) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] EncryptionKey = new byte[16];
            random.nextBytes(EncryptionKey);
            Key key = new SecretKeySpec(EncryptionKey, "AES");
            byte[] output;
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            output = cipher.doFinal("encryptData".getBytes(StandardCharsets.UTF_8));
            // Toast.makeText(getApplicationContext(), "into checkciphertype",
            // Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d("Diva", "cipher exception" + e);
        }
    }

    public void checkdigestype(View view) {
        try {
            MessageDigest md5;
            md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            byte[] bytes = "digestion".getBytes(StandardCharsets.UTF_8);
            md5.update(bytes);
            // Toast.makeText(getApplicationContext(), "into checkdigestype",
            // Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.d("Diva", "digest exception" + e);
        }
    }

    public void checksignaturetype(View view) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey aPrivate = kp.getPrivate();
            PublicKey aPublic = kp.getPublic();
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(aPrivate);

            byte[] bytes = "signature".getBytes(StandardCharsets.UTF_8);
            signature.update(bytes);
            // Toast.makeText(getApplicationContext(), "into checksignaturetype",
            // Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d("Diva", "signature exception" + e);
        }
    }

    public void checkmactype(View view) {
        String key = "mykey"; // 雜湊用的密鑰字串，又稱為鹽(salt)
        String message = "hello world";
        try {
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8); // 把密鑰字串轉為byte[]
            Key hmacKey = new SecretKeySpec(keyBytes, "HmacSHA256"); // 建立HMAC加密用密鑰
            Mac hmacSHA256 = Mac.getInstance("HmacSHA256"); // 取得SHA256 HMAC的Mac實例
            hmacSHA256.init(hmacKey); // 使用密鑰對Mac進行初始化
            hmacSHA256.update(message.getBytes(StandardCharsets.UTF_8)); // 對原始訊息進行雜湊計算
            // String hexStringOfTheOriginMessage = Hex.encodeHexString(macData); //
            // 使用Apache Commons Codec的Hex把雜湊計算的結果轉為Hex字串

            // System.out.println(hexStringOfTheOriginMessage); //
            // 388b02bb9be6c19490d4014aaaccb62a3969f44f3ecef3b2218e7ee1d457188d

            // System.out.println(hmacSHA256.getAlgorithm()); // HmacSHA256
            // System.out.println(hmacSHA256.getMacLength()); // 32
            // System.out.println(hmacSHA256.getProvider().getName()); // SunJCE (JCE提供者)
        } catch (Exception e) {
            Log.d("Diva", "mac exception" + e);
        }
        Toast.makeText(getApplicationContext(), "into checkmactype",
                Toast.LENGTH_SHORT).show();
    }
}