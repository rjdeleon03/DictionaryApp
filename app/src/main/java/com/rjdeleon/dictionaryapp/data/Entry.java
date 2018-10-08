package com.rjdeleon.dictionaryapp.data;

public class Entry {

    private int parentId;
    private String word;
    private String partOfSpeech;
    private String meaning;
    private String note;
    private String relatedWord;

    public Entry(int parentId, String word, String partOfSpeech, String meaning, String note, String relatedWord) {
        this.parentId = parentId;
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.note = note;
        this.relatedWord = relatedWord;
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
