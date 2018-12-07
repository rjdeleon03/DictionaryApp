package com.rjdeleon.dictionaryapp.di;

import android.content.Context;

import com.rjdeleon.dictionaryapp.data.DictionaryRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private final Context context;

    public DatabaseModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    DictionaryRepository dictionaryRepo() {
        return new DictionaryRepository(context);
    }
}
