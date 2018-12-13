package com.rjdeleon.dictionaryapp.feature.entrylist;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.databinding.FragmentListBinding;
import com.rjdeleon.dictionaryapp.data.Entry;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntryListFragment extends Fragment {

    private EntryListAdapter mAdapter;
    private EntryListViewModel mViewModel;
    private MenuItem mSearch;
    private SearchView mSearchView;

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
        FragmentListBinding binding = FragmentListBinding.inflate(inflater, container, false);
        binding.dictionaryList.setAdapter(mAdapter);
        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
        setupActionBar();

        mSearch = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Find a word");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mViewModel.setFilter(s);
                return true;
            }
        });
    }

    private void setupActionBar() {
        AppCompatActivity activity = ((AppCompatActivity) getActivity());
        if (activity == null) return;

        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar == null) return;

        actionBar.show();
        actionBar.setDisplayHomeAsUpEnabled(false);
    }
}
