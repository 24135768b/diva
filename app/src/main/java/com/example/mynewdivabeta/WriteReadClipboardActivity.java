package com.example.mynewdivabeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ClipData;
import android.content.ClipboardManager;

public class WriteReadClipboardActivity extends AppCompatActivity {

    private ClipboardManager myClipBoard;
    private ClipData myClipdata;
    private EditText CopyField, PasteField;
    // private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_read_clipboard);
        myClipBoard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    }

    // /***
    // * check if the text in the clipboard contains some important information
    // *
    // * @param text // the text we want to check
    // * @return false if there contains the important information
    // * @return true if the text is safe enough
    // */
    // public boolean check_security(String text) {
    // String pattern = "^.*passwd.*$";
    // // String str = "123passwd321";

    // // if (str.matches(pattern)) {
    // // return false;
    // // }
    // if (text.matches(pattern)) {
    // return false;
    // }
    // return true;
    // }

    /***
     * the android function of copy
     * We get the copyfield from view and get its text
     * then we check if the copied text is safe
     * and only set the safe text to the clipboard
     * 
     * @param view
     */
    public void copy(View view) {
        // String testbtntext = "Copy function can work!!!";
        CopyField = (EditText) findViewById(R.id.copytext);
        String text = CopyField.getText().toString();
        // Boolean safe_flag = check_security(text);
        // if (safe_flag) {
        myClipdata = ClipData.newPlainText("text", text);
        myClipBoard.setPrimaryClip(myClipdata);
        Toast.makeText(getApplicationContext(), "Text Copied",
                Toast.LENGTH_SHORT).show();
        // } else {
        // Toast.makeText(getApplicationContext(),
        // "You copied some sensitive information and failed to save it to the
        // clipboard",
        // Toast.LENGTH_SHORT).show();
        // }
    }

    /***
     * the android fuunction of paste
     * We get the pastefield from view and get the clipbroad
     * we will check all texts of the clipboard
     * and show if the whole clipboard contains sensitive information or not
     * 
     * @param view
     */
    public void paste(View view) {
        PasteField = (EditText) findViewById(R.id.pastetext);
        ClipData primaryClip = myClipBoard.getPrimaryClip();
        Integer clip_count = primaryClip.getItemCount();
        // Integer i;
        // Boolean safe_flag = true;
        // for (i = 0; i < clip_count; i++) {
        // ClipData.Item item = primaryClip.getItemAt(i);
        // String text = item.getText().toString();
        // if (safe_flag) {
        // safe_flag = check_security(text);
        // } else
        // break;
        // }
        // if (safe_flag) {
        ClipData.Item item = primaryClip.getItemAt(0);
        String text = item.getText().toString();
        PasteField.setText(text);
        Toast.makeText(getApplicationContext(), "Text Pasted",
                Toast.LENGTH_SHORT).show();
        // } else {
        // Toast.makeText(getApplicationContext(),
        // "The clipboard contains some sensitive information, please delete it or you
        // cannot paste anyything",
        // Toast.LENGTH_SHORT).show();

        // }
    }
}