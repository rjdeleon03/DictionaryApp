package com.rjdeleon.dictionaryapp.feature.entry;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.data.Entry;

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
        final View view = inflater.inflate(R.layout.fragment_entry, container, false);
        Bundle args = getArguments();
        if (args != null && getActivity() != null) {
            EntryViewModelFactory factory = new EntryViewModelFactory(
                    getActivity().getApplication(),
                    EntryFragmentArgs.fromBundle(args).getEntryId());
            mViewModel = ViewModelProviders.of(this, factory).get(EntryViewModel.class);
            mViewModel.getEntry().observe(this, new Observer<Entry>() {
                @Override
                public void onChanged(@Nullable Entry entry) {
                    if (entry == null) return;
                    setupUi(view, entry);
                }
            });
        }

        return view;
    }

    private void setupUi(View view, Entry entry) {
        TextView wordField = view.findViewById(R.id.wordField);
        wordField.setText(entry.getWord());

        TextView posField = view.findViewById(R.id.posField);
        posField.setText(entry.getPartOfSpeech());

        TextView meaningField = view.findViewById(R.id.meaningField);
        meaningField.setText(entry.getMeaning());
    }

}
