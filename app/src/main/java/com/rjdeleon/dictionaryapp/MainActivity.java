package com.rjdeleon.dictionaryapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rjdeleon.dictionaryapp.data.DictionaryRepository;
import com.rjdeleon.dictionaryapp.list.ListFragment;
import com.rjdeleon.dictionaryapp.list.ListPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Context context;

    public MainActivity() {
        context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listFragment = new ListFragment();
        ListPresenter listPresenter = new ListPresenter();
        listFragment.setPresenter(listPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, listFragment)
                .commit();
    }
}
