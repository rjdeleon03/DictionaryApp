package com.rjdeleon.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rjdeleon.dictionaryapp.data.DictionaryRepository;
import com.rjdeleon.dictionaryapp.list.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DictionaryRepository dictionaryRepository = new DictionaryRepository(this);
        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new ListFragment())
                    .commit();
        }
    }
}
