package com.rjdeleon.dictionaryapp.feature.entrylist;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.data.Entry;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntryListFragment extends Fragment {

    private RecyclerView listRecyclerView;

    private EntryListAdapter mAdapter;
    private EntryListViewModel mViewModel;

    public EntryListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new EntryListAdapter(getContext());
        mViewModel = ViewModelProviders.of(this).get(EntryListViewModel.class);

        mViewModel.getEntries().observe(this, new Observer<List<Entry>>() {
            @Override
            public void onChanged(@Nullable List<Entry> entries) {
                mAdapter.setEntries(entries);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listRecyclerView = view.findViewById(R.id.dictionaryList);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
