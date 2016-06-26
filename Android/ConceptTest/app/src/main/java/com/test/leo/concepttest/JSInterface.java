package com.test.leo.concepttest;

import android.webkit.*;
/**
 * Created by Leo on 6/25/2016.
 */
public class JSInterface
{
    private MainActivity _activity = null;
    private SQLiteWrapper _sqliteWrapper = null;

    public JSInterface(MainActivity activity)
    {
        _activity = activity;
        _sqliteWrapper = new SQLiteWrapper(activity);
    }

    /*@JavascriptInterface
    public void showDialog(String msg)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(_activity).create();
        alertDialog.setTitle("Test Dialgo");
        alertDialog.setMessage(msg);
        alertDialog.show();
    }*/

    @JavascriptInterface
    public void SQLiteCreateFile(String fileName)
    {
        _sqliteWrapper.CreateFile(fileName);
    }

    @JavascriptInterface
    public void SQLiteOpenConnection(String connectionSettings)
    {
        _sqliteWrapper.OpenConnection(connectionSettings);
    }

    @JavascriptInterface
    public String SQLiteExecuteNonQuery(String query)
    {
        return _sqliteWrapper.ExecuteNonQuery(query);
    }

    @JavascriptInterface
    public String SQLiteExecuteSelect(String query)
    {
        return _sqliteWrapper.ExecuteSelect(query);
    }
}
