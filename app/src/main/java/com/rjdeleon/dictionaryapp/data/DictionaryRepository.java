package com.rjdeleon.dictionaryapp.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DictionaryRepository {

    private final Gson _gson;
    private final DictionaryDatabase _db;

    public DictionaryRepository(Context context) {
        _gson = new GsonBuilder().create();
        _db = DictionaryDatabase.getDictionaryDatabase(context);
        seedData(context);
    }

    private void seedData(Context context) {

        if(_db.entryDao().getCount() > 0) return;

        String dictJson;
        try {
            /* Read JSON data from file */
            InputStream is = context.getAssets().open("json/dict.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            dictJson = new String(buffer, "UTF-8");

            /* Deserialize JSON data */
            List<Entry> dictEntries = null;
            Type listType = new TypeToken<ArrayList<Entry>>(){}.getType();

            dictEntries = _gson.fromJson(dictJson, listType);

            for(Entry entry : dictEntries) {
                _db.entryDao().insertAll(entry);
            }

            List<Entry> retrieved = _db.entryDao().getAll();
            int x = 5;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
