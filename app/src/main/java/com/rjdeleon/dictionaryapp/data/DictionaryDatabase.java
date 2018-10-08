package com.rjdeleon.dictionaryapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Entry.class}, version = 1)
public abstract class DictionaryDatabase extends RoomDatabase {

    private static DictionaryDatabase INSTANCE;

    public abstract EntryDao entryDao();

    public static DictionaryDatabase getDictionaryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    DictionaryDatabase.class, "dictionary-database")
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
