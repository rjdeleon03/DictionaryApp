package com.rjdeleon.dictionaryapp.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rjdeleon.dictionaryapp.R;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private final ListPresenter presenter;

    public ListAdapter(ListPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fragment_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        presenter.onBindListItemViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getEntriesCount();
    }
}
