package com.test.leo.concepttest;

import android.database.sqlite.*;
import android.database.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 * Created by Leo on 6/25/2016.
 */
public class SQLiteWrapper implements DatabaseErrorHandler
{
    private SQLiteDatabase _database = null;

    public SQLiteWrapper()
    {

    }

    public void onCorruption(SQLiteDatabase var1)
    {
        boolean isOpen = var1.isOpen();
    }

    public void CreateFile(String fileName)
    {
        _database = SQLiteDatabase.openOrCreateDatabase(fileName, null, this);
    }

    public void OpenConnection(String connectionSettings)
    {
        //if(_database == null || !_database.isOpen())
            //_database = SQLiteDatabase.openOrCreateDatabase(connectionSettings);
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
