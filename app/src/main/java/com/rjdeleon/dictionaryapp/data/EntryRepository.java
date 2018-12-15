package com.rjdeleon.dictionaryapp.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class EntryRepository {

    private final EntryDao mEntryDao;
    private final LiveData<Entry> mEntry;

    private final MeaningSetDao mMeaningSetDao;
    private final LiveData<List<MeaningSet>> mMeaningSets;

    public EntryRepository(Application application, int id) {
        mEntryDao = DictionaryDatabase.getInstance(application.getApplicationContext())
                .entryDao();
        mEntry = mEntryDao.findById(id);

        mMeaningSetDao = DictionaryDatabase.getInstance(application.getApplicationContext())
                .meaningSetDao();
        mMeaningSets = mMeaningSetDao.findMeaningSetByWordId(id);
    }

    public LiveData<Entry> getEntry() {
        return mEntry;
    }

    public LiveData<List<MeaningSet>> getMeaningSets() {
        return mMeaningSets;
    }

}
