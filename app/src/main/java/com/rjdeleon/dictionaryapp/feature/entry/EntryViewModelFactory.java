package com.rjdeleon.dictionaryapp.feature.entry;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class EntryViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application mApplication;
    private final int mId;

    public EntryViewModelFactory(Application mApplication, int mId) {
        this.mApplication = mApplication;
        this.mId = mId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new EntryViewModel(mApplication, mId);
    }
}
