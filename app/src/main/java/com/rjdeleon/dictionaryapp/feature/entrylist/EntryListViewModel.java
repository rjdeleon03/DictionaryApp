package com.rjdeleon.dictionaryapp.feature.entrylist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.rjdeleon.dictionaryapp.data.Entry;
import com.rjdeleon.dictionaryapp.data.EntryListRepository;

import java.util.List;

public class EntryListViewModel extends AndroidViewModel {

    private EntryListRepository mRepository;
    private final MediatorLiveData<List<Entry>> mEntries = new MediatorLiveData<>();
    private final MutableLiveData<String> mFilter = new MutableLiveData<>();

    public EntryListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new EntryListRepository(application);
        LiveData<List<Entry>> liveEntryList = Transformations.switchMap(mFilter,
                filter -> {
                    if (filter.isEmpty()) return mRepository.getEntries();
                    return mRepository.getEntriesContainingString(filter);
                });
        mEntries.addSource(liveEntryList, mEntries::setValue);
        mFilter.setValue("");
    }

    public LiveData<List<Entry>> getEntries() {
        return mEntries;
    }

    void setFilter(String filter) {
        mFilter.setValue(filter);
    }

}
