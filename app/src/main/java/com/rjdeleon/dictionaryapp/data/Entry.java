package com.rjdeleon.dictionaryapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "entry")
public class Entry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "parent_id")
    private int parentId;

    @ColumnInfo(name = "word")
    private String word;

    @ColumnInfo(name = "part_of_speech")
    private String partOfSpeech;

    @ColumnInfo(name = "meaning")
    private String meaning;

    @ColumnInfo(name = "note")
    private String note;

    @ColumnInfo(name = "related_word")
    private String relatedWord;

    public Entry(int parentId, String word, String partOfSpeech, String meaning, String note, String relatedWord) {
        this.parentId = parentId;
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.note = note;
        this.relatedWord = relatedWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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
}
