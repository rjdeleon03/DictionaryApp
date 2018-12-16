package com.rjdeleon.dictionaryapp;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.rjdeleon.dictionaryapp.data.DictionaryDatabase;
import com.rjdeleon.dictionaryapp.data.Entry;
import com.rjdeleon.dictionaryapp.data.MeaningSet;
import com.rjdeleon.dictionaryapp.utils.AppExecutors;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DictionaryApp extends Application {

    private final String SEED_FILENAME = "dict.json";
    private final String SEED_FOLDER = "json/";
    private final String UTF_8_ENCODING = "UTF-8";

    @Override
    public void onCreate() {
        super.onCreate();
        seedData();
    }

    private void seedData() {

        final DictionaryDatabase db = DictionaryDatabase
                .getInstance(getApplicationContext());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if(db.entryDao().getCount() > 0) return;

                Gson gson = new GsonBuilder().create();

                String dictJson;
                try {
                    /* Read JSON data from file */
                    InputStream is = getApplicationContext()
                            .getAssets().open(SEED_FOLDER + SEED_FILENAME);
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    dictJson = new String(buffer, UTF_8_ENCODING);

                    /* Deserialize JSON data */
                    List<Entry> dictEntries = null;
                    Type listType = new TypeToken<ArrayList<Entry>>(){}.getType();

                    dictEntries = gson.fromJson(dictJson, listType);

                    for (int i = 1; i <= dictEntries.size(); i++) {
                        Entry entry = dictEntries.get(i);
                        entry.setId(i);
                        db.entryDao().insertAll(entry);

                        for(MeaningSet ms : entry.getMeaningSet()) {
                            ms.setWordId(entry.getId());
                        }
                        db.meaningSetDao().insertAll(entry.getMeaningSet());
                    }

//                    db.entryDao().getAll().observeForever(entries -> {
//
//                        int x = 5;
//                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
