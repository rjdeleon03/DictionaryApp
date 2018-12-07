package com.rjdeleon.dictionaryapp.di;

import android.content.Context;

import com.rjdeleon.dictionaryapp.data.DictionaryRepository;
import com.rjdeleon.dictionaryapp.list.ListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        DatabaseModule.class
})
public interface MainComponent {

    void injectListPresenter(ListPresenter listPresenter);
}
