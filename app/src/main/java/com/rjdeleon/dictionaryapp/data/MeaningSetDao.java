package com.rjdeleon.dictionaryapp.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MeaningSetDao {

    @Insert
    void insertAll(List<MeaningSet> meaningSets);

    @Query("SELECT * FROM meaning_set WHERE wordId = :wordId")
    LiveData<List<MeaningSet>> findMeaningSetByWordId(int wordId);
}
