package com.rjdeleon.dictionaryapp.feature.entrylist;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.databinding.FragmentListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntryListFragment extends Fragment {

    private EntryListAdapter mAdapter;
    private EntryListViewModel mViewModel;
    private MaterialSearchView mSearchView;

    public EntryListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new EntryListAdapter(getContext());
        mViewModel = ViewModelProviders.of(this).get(EntryListViewModel.class);

        mViewModel.getEntries().observe(this, entries -> mAdapter.setEntries(entries));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentListBinding binding = FragmentListBinding.inflate(inflater, container, false);
        binding.dictionaryList.setAdapter(mAdapter);
        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentActivity parentActivity = getActivity();

        assert parentActivity != null;
        mSearchView = parentActivity.findViewById(R.id.searchView);
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
        setupActionBar();

        MenuItem mSearch = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(mSearch);
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
