package com.rjdeleon.dictionaryapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "entry")
public class Entry {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "word")
    private String word;

    @ColumnInfo(name = "note")
    private String note;

    @ColumnInfo(name = "related_word")
    private String relatedWord;

    @Ignore
    private List<MeaningSet> meaningSet;

    public Entry(int id, String word, String note, String relatedWord) {
        this.id = id;
        this.word = word;
        this.note = note;
        this.relatedWord = relatedWord;
    }

    public Entry(int id, String word, String note, String relatedWord, List<MeaningSet> meaningSet) {
        this.id = id;
        this.word = word;
        this.note = note;
        this.relatedWord = relatedWord;
        this.meaningSet = meaningSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRelatedWord() {
        return relatedWord;
    }

    public void setRelatedWord(String relatedWord) {
        this.relatedWord = relatedWord;
    }

    public List<MeaningSet> getMeaningSet() {
        return meaningSet;
    }

    public void setMeaningSet(List<MeaningSet> meaningSetList) {
        this.meaningSet = meaningSetList;
    }
}
