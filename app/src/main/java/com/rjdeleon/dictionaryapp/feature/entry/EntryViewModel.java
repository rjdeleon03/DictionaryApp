package com.rjdeleon.dictionaryapp.feature.entry;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.rjdeleon.dictionaryapp.data.Entry;
import com.rjdeleon.dictionaryapp.data.EntryRepository;

public class EntryViewModel extends ViewModel {

    private EntryRepository mRepository;
    public LiveData<Entry> entry;

    public EntryViewModel(@NonNull Application application, int entryId) {
        mRepository = new EntryRepository(application, entryId);
        entry = mRepository.getEntry();
    }
}
