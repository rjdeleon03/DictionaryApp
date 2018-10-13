package com.rjdeleon.dictionaryapp.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rjdeleon.dictionaryapp.R;

public class ListViewHolder extends RecyclerView.ViewHolder implements IListItemView {

    TextView wordTextView;
    TextView contentTextView;

    public ListViewHolder(View itemView) {
        super(itemView);
        wordTextView = itemView.findViewById(R.id.wordTextView);
        contentTextView = itemView.findViewById(R.id.contentTextView);
    }

    @Override
    public void setWord(String word) {
        wordTextView.setText(word);
    }

    @Override
    public void setContent(String content) {
        contentTextView.setText(content);
    }
}
