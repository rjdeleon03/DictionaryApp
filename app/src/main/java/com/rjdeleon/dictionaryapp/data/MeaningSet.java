package com.rjdeleon.dictionaryapp.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "meaning_set",
    indices = {@Index("wordId")},
    foreignKeys = @ForeignKey(entity = Entry.class,
                            parentColumns = "id",
                            childColumns = "wordId",
                            onDelete = CASCADE))
public class MeaningSet {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String partOfSpeech;

    private String meaning;

    private int wordId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
}
