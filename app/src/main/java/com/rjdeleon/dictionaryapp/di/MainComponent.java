package com.rjdeleon.dictionaryapp.di;

import android.content.Context;

import dagger.Component;

@Component(modules = {
        ContextModule.class
})
public interface MainComponent {

    Context getContext();
}
