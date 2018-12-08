package com.rjdeleon.dictionaryapp.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.data.Entry;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private LayoutInflater mInflater;
    private List<Entry> mEntries;

    public ListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(mInflater.inflate(R.layout.fragment_list_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Entry entry = mEntries.get(position);
        holder.wordTextView.setText(entry.getWord());
        holder.contentTextView.setText(entry.getMeaning());
    }

    @Override
    public int getItemCount() {
        if (mEntries == null) return 0;
        return mEntries.size();
    }

    public void setEntries(List<Entry> entries) {
        mEntries = entries;
        notifyDataSetChanged();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView wordTextView;
        TextView contentTextView;

        ListViewHolder(View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.wordTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }
    }
}
