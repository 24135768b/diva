package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.lang.Object;
import java.io.IOException;
import 	java.io.OutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class InternalStorageActivity extends AppCompatActivity {
    EditText Write_File;
    Button Readable,Writable,Read_Write;
    String File_Name = "testFile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        Write_File = (EditText)findViewById(R.id.Write_File_Text);
        Readable = (Button)findViewById(R.id.Readable);
        Writable = (Button)findViewById(R.id.Writable);
        Read_Write = (Button)findViewById(R.id.Read_Write);
        Readable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputStream = openFileOutput(File_Name,MODE_PRIVATE);
                    outputStream.write(Write_File.getText().toString().getBytes(StandardCharsets.UTF_8));
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Writable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Read_Write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}