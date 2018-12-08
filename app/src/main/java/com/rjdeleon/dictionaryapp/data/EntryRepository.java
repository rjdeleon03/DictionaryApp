package com.rjdeleon.dictionaryapp.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;

public class EntryRepository {

    private final EntryDao mDao;
    private final LiveData<Entry> mEntry;

    public EntryRepository(Application application, int id) {
        mDao = DictionaryDatabase.getInstance(application.getApplicationContext())
                .entryDao();
        mEntry = mDao.findById(id);
    }

    public LiveData<Entry> getEntry() {
        return mEntry;
    }

}
