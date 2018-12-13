package com.rjdeleon.dictionaryapp.feature.entry;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.databinding.FragmentEntryBinding;
import com.rjdeleon.dictionaryapp.data.Entry;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntryFragment extends Fragment {


    private EntryViewModel mViewModel;

    public EntryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final FragmentEntryBinding binding = FragmentEntryBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);

        Bundle args = getArguments();
        if (args != null && getActivity() != null) {
            EntryViewModelFactory factory = new EntryViewModelFactory(
                    getActivity().getApplication(),
                    EntryFragmentArgs.fromBundle(args).getEntryId());

            mViewModel = ViewModelProviders.of(this, factory).get(EntryViewModel.class);
            binding.setViewModel(mViewModel);
            binding.setLifecycleOwner(this);
        }

        ImageButton upButton = binding.getRoot().findViewById(R.id.upButton);
        final NavController navController = NavHostFragment.findNavController(this);
        upButton.setOnClickListener(v -> navController.navigateUp());

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setupActionBar();
    }

    private void setupActionBar() {
        AppCompatActivity activity = ((AppCompatActivity) getActivity());
        if (activity == null) return;

        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar == null) return;

        actionBar.hide();
    }
}
