package com.test.leo.concepttest;

import 	android.app.*;
import android.webkit.*;
/**
 * Created by Leo on 6/25/2016.
 */
public class JSInterface
{
    private MainActivity _activity = null;

    public JSInterface(MainActivity activity)
    {
        _activity = activity;
    }

    @JavascriptInterface
    public void showDialog(String msg)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(_activity).create();
        alertDialog.setTitle("Test Dialgo");
        alertDialog.setMessage(msg);
        alertDialog.show();
    }
}
