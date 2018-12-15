package com.rjdeleon.dictionaryapp.feature.entry;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjdeleon.dictionaryapp.R;
import com.rjdeleon.dictionaryapp.data.MeaningSet;

import java.util.List;

public class MeaningSetAdapter extends RecyclerView.Adapter<MeaningSetAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<MeaningSet> mMeaningSets;

    public MeaningSetAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.fragment_entry_meaning_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MeaningSet ms = mMeaningSets.get(i);
        assert ms != null;
        viewHolder.posField.setText(ms.getPartOfSpeech());
        viewHolder.meaningField.setText(ms.getMeaning());
    }

    @Override
    public int getItemCount() {
        return mMeaningSets == null ? 0 : mMeaningSets.size();
    }

    public void setMeaningSets(List<MeaningSet> meaningSets) {
        mMeaningSets = meaningSets;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView posField;
        public TextView meaningField;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            posField = itemView.findViewById(R.id.posField);
            meaningField = itemView.findViewById(R.id.meaningField);
        }
    }
}
