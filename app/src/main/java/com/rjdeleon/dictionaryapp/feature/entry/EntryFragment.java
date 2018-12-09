package com.rjdeleon.dictionaryapp.feature.entry;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.databinding.FragmentEntryBinding;
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
        final FragmentEntryBinding binding = FragmentEntryBinding.inflate(inflater, container, false);
        Bundle args = getArguments();
        if (args != null && getActivity() != null) {
            EntryViewModelFactory factory = new EntryViewModelFactory(
                    getActivity().getApplication(),
                    EntryFragmentArgs.fromBundle(args).getEntryId());

            mViewModel = ViewModelProviders.of(this, factory).get(EntryViewModel.class);
            binding.setViewModel(mViewModel);
            binding.setLifecycleOwner(this);
        }

        return binding.getRoot();
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
