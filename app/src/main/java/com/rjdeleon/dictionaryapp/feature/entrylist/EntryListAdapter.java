package com.rjdeleon.dictionaryapp.feature.entrylist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.rjdeleon.dictionaryapp.Constants;
import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.data.Entry;

import java.util.List;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;

public class EntryListAdapter extends RecyclerView.Adapter<EntryListAdapter.EntryListViewHolder> {

    private LayoutInflater mInflater;
    private List<Entry> mEntries;

    EntryListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public EntryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EntryListViewHolder(mInflater.inflate(R.layout.fragment_list_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EntryListViewHolder holder, int position) {
        Entry entry = mEntries.get(position);

        ViewCompat.setTransitionName(holder.wordTextView,
                Constants.ITEM_TRANSITION_PREFIX + String.valueOf(entry.getId()));

        holder.wordTextView.setText(entry.getWord());
        holder.contentTextView.setText(entry.getPartOfSpeech());
        holder.setItemClickListener(createItemClickListener(entry.getId()));
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

    private View.OnClickListener createItemClickListener(final int entryId) {
        return v -> {

            EntryListFragmentDirections.ActionEntryListFragmentToEntryFragment action =
                    EntryListFragmentDirections.actionEntryListFragmentToEntryFragment().setEntryId(entryId);

            String transitionName = ViewCompat.getTransitionName(v.findViewById(R.id.wordTextView));
            FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                    .addSharedElement(v.findViewById(R.id.wordTextView), transitionName)
                    .build();

            Navigation.findNavController(v).navigate(action, extras);

        };
    }

    class EntryListViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView wordTextView;
        TextView contentTextView;

        EntryListViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            wordTextView = itemView.findViewById(R.id.wordTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }

        void setItemClickListener(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
        }
    }
}
