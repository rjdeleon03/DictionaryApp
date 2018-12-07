package com.rjdeleon.dictionaryapp.app;

import android.app.Activity;
import android.app.Application;

import com.rjdeleon.dictionaryapp.di.ContextModule;
import com.rjdeleon.dictionaryapp.di.DaggerMainComponent;
import com.rjdeleon.dictionaryapp.di.DatabaseModule;
import com.rjdeleon.dictionaryapp.di.MainComponent;

public class DictionaryApplication extends Application {

    private MainComponent mainComponent;

    public static DictionaryApplication get(Activity activity) {
        return (DictionaryApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mainComponent = DaggerMainComponent.builder()
                .contextModule(new ContextModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
    }


}
