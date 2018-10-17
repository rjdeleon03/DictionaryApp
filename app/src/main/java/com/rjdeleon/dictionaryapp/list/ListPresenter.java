package com.rjdeleon.dictionaryapp.list;

import android.content.Context;

import com.rjdeleon.dictionaryapp.data.DictionaryRepository;
import com.rjdeleon.dictionaryapp.data.Entry;
import com.rjdeleon.dictionaryapp.di.ContextModule;
import com.rjdeleon.dictionaryapp.di.DaggerMainComponent;
import com.rjdeleon.dictionaryapp.di.MainComponent;

import java.util.ArrayList;
import java.util.List;

public class ListPresenter {

    private List<Entry> entries;
    private DictionaryRepository dictionaryRepository;

    public ListPresenter() {
        entries = new ArrayList<>();
    }

    public void setContext(Context context) {

        MainComponent mainComponent = DaggerMainComponent.builder()
                .contextModule(new ContextModule(context))
                .build();
        dictionaryRepository = new DictionaryRepository(mainComponent.getContext());
        entries = dictionaryRepository.getAllEntries();
    }

    public void onBindListItemViewAtPosition(int position, IListItemView listItemView) {
        Entry entry = entries.get(position);
        listItemView.setWord(entry.getWord());
        listItemView.setContent(entry.getMeaning());
    }

    public int getEntriesCount() {
        return entries.size();
    }
}
