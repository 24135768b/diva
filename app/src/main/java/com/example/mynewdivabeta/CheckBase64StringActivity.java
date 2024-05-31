package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Base64;
import android.widget.TextView;
import java.util.Calendar;
import java.io.UnsupportedEncodingException;

public class CheckBase64StringActivity extends AppCompatActivity {
    String username, passwd, EncodeStr, DecodeStr;
    EditText UserInput, PasswdInput;
    Button Encode, Decode;
    TextView UserSession, UserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_base64_string);
        // UserInput = (EditText) findViewById(R.id.UserName_Input);
        // PasswdInput = (EditText) findViewById(R.id.Password_Input);
        // UserSession = (TextView) findViewById(R.id.User_Session);
        // UserInfo = (TextView) findViewById(R.id.User_Info);
        // Encode = (Button) findViewById(R.id.Encode);
        // EncodeStr = "";
        // Encode.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View view) {
        // username = UserInput.getText().toString();
        // passwd = PasswdInput.getText().toString();
        // String Buffer = "user:" + username + "password:" + passwd;
        // byte[] EncodeData = new byte[0];
        // try {
        // EncodeData = Buffer.getBytes("UTF-8");
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }
        // EncodeStr = Base64.encodeToString(EncodeData, Base64.DEFAULT);
        // UserSession.setText(EncodeStr);
        // }
        // });
        // Decode = (Button) findViewById(R.id.Decode);
        // Decode.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View view) {
        // byte[] data = Base64.decode(EncodeStr, Base64.DEFAULT);
        // try {
        // DecodeStr = new String(data, "UTF-8");
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }
        // UserInfo.setText(DecodeStr);
        // }
        // });
    }

    public void encode(View view) {
        UserInput = (EditText) findViewById(R.id.UserName_Input);
        PasswdInput = (EditText) findViewById(R.id.Password_Input);
        UserSession = (TextView) findViewById(R.id.User_Session);
        UserInfo = (TextView) findViewById(R.id.User_Info);
        username = UserInput.getText().toString();
        passwd = PasswdInput.getText().toString();
        String Buffer = "user:" + username + "password:" + passwd;
        byte[] EncodeData = new byte[0];
        try {
            EncodeData = Buffer.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        EncodeStr = Base64.encodeToString(EncodeData, Base64.DEFAULT);
        UserSession.setText(EncodeStr);
    }

    public void decode(View view) {
        UserInfo = (TextView) findViewById(R.id.User_Info);
        byte[] data = Base64.decode(EncodeStr, Base64.DEFAULT);
        try {
            DecodeStr = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        UserInfo.setText(DecodeStr);
    }
}