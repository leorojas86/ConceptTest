package com.test.leo.concepttest;

import android.database.sqlite.*;
import android.database.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.*;

/**
 * Created by Leo on 6/25/2016.
 */
public class SQLiteWrapper
{
    private MainActivity _activity = null;
    private SQLiteDatabase _database = null;
    private File _file = null;

    public SQLiteWrapper(MainActivity activity)
    {
        _activity = activity;
    }

    public void CreateFile(String fileName)
    {
        _file = new File("MyDatabase.sqlite");

        if(!_file.exists())
        {
            try
            {
                _file.createNewFile();
            }
            catch(Exception e)
            {
                String message = e.getMessage();
                _activity.ShowDialog("Exception", message);
            }
        }
    }

    public void OpenConnection(String connectionSettings)
    {
        if(_file.exists())
            _database = SQLiteDatabase.openOrCreateDatabase(_file, null);
    }

    public String ExecuteNonQuery(String query)
    {
        Cursor cursor = _database.rawQuery(query, null);
        ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

        while(cursor.moveToNext())
        {
            HashMap<String, String> currentRow = new HashMap<String, String>();

            for(int i = 0; i < cursor.getColumnCount(); i++)
            {
                String key   = cursor.getColumnName(i);
                String value = cursor.getString(i);

                currentRow.put(key, value);
            }

            rows.add(currentRow);
        }

        HashMap<String, ArrayList> result = new HashMap<String, ArrayList>();
        result.put("rows", rows);
        JSONObject jsonObject = new JSONObject(result);

        return jsonObject.toString();
    }

    public String ExecuteSelect(String query)
    {
        Cursor cursor = _database.rawQuery(query, null);
        ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

        while(cursor.moveToNext())
        {
            HashMap<String, String> currentRow = new HashMap<String, String>();

            for(int i = 0; i < cursor.getColumnCount(); i++)
            {
                String key   = cursor.getColumnName(i);
                String value = cursor.getString(i);

                currentRow.put(key, value);
            }

            rows.add(currentRow);
        }

        HashMap<String, ArrayList> result = new HashMap<String, ArrayList>();
        result.put("rows", rows);
        JSONObject jsonObject = new JSONObject(result);

        return jsonObject.toString();
    }
}