package com.rjdeleon.dictionaryapp.list;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.rjdeleon.dictionaryapp.data.Entry;
import com.rjdeleon.dictionaryapp.data.EntryListRepository;

import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private EntryListRepository mRepository;
    private LiveData<List<Entry>> mEntries;

    public ListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new EntryListRepository(application);
        mEntries = mRepository.getEntries();
    }

    public LiveData<List<Entry>> getEntries() {
        return mEntries;
    }

}
