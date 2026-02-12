package com.example.mycart;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;

public class Database extends RoomDatabase {
    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
