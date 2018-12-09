package com.rjdeleon.dictionaryapp.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import java.util.List;

public class EntryListRepository {

    private EntryDao mDao;
    private final LiveData<List<Entry>> mEntries;

    public EntryListRepository(Application application) {
        mDao = DictionaryDatabase.getInstance(application.getApplicationContext())
                .entryDao();
        mEntries = mDao.getAll();
    }

    public LiveData<List<Entry>> getEntries() {
        return mEntries;
    }

    public LiveData<List<Entry>> getEntriesContainingString(String filter) {
        return mDao.findByWord("%" + filter + "%");
    }
}
