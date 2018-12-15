package com.rjdeleon.dictionaryapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Entry.class, MeaningSet.class}, version = 1)
public abstract class DictionaryDatabase extends RoomDatabase {

    private static DictionaryDatabase INSTANCE;
    private static final Object LOCK = new Object();

    public abstract EntryDao entryDao();

    public abstract MeaningSetDao meaningSetDao();

    public static DictionaryDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized(LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DictionaryDatabase.class, "dictionary-database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        synchronized(DictionaryDatabase.class) {
            INSTANCE = null;
        }
    }
}
