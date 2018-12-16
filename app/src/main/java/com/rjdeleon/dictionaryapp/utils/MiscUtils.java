package com.rjdeleon.dictionaryapp.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.CardView;
import android.view.View;

import com.rjdeleon.dictionaryapp.data.MeaningSet;

import java.util.List;

public class MiscUtils {

    @BindingAdapter("android:visibility")
    public static void noteToVisibility(CardView cardView, String note) {
        cardView.setVisibility((note == null || note.isEmpty()) ? View.GONE : View.VISIBLE);
    }

    @SuppressWarnings("ConstantConditions")
    @BindingAdapter("android:visibility")
    public static void meaningSetsToVisibility(CardView cardView, List<MeaningSet> meaningSets) {
        boolean shouldHideMeaningSet = false;
        if (meaningSets != null && meaningSets.size() > 0) {
            shouldHideMeaningSet = meaningSets.get(0).getMeaning().isEmpty();
        }
        cardView.setVisibility((shouldHideMeaningSet || meaningSets == null || meaningSets.size() == 0) ?
                View.GONE : View.VISIBLE);
    }
}
