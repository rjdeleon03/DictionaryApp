package com.rjdeleon.dictionaryapp.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EntryDao {

    @Query("SELECT count(*) FROM entry")
    int getCount();

    @Query("SELECT * FROM entry")
    LiveData<List<Entry>> getAll();

    @Query("SELECT * FROM entry where id = :id")
    LiveData<Entry> findById(int id);

    @Query("SELECT * FROM entry where word LIKE :word")
    LiveData<List<Entry>> findByWord(String word);

    @Insert
    void insertAll(Entry... entries);

    @Delete
    void delete(Entry entry);
}
