package com.rjdeleon.dictionaryapp.list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.dictionaryapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private ListPresenter listPresenter;
    private RecyclerView listRecyclerView;
    private ListAdapter listAdapter;

    public ListFragment() {
        // Required empty public constructor
    }

    public void setPresenter(ListPresenter listPresenter) {
        this.listPresenter = listPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listRecyclerView = view.findViewById(R.id.dictionaryList);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listAdapter = new ListAdapter(listPresenter);
        listRecyclerView.setAdapter(listAdapter);

        return view;
    }

}
