package com.rjdeleon.dictionaryapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EntryDao {

    @Query("SELECT * FROM entry")
    List<Entry> getAll();

    @Query("SELECT * FROM entry where word LIKE :word")
    Entry findByWord(String word);

    @Insert
    void insertAll(Entry... entries);

    @Delete
    void delete(Entry entry);
}
