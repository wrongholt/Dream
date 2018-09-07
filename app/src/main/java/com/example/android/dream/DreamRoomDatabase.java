package com.example.android.dream;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Player.class}, version = 1)
public abstract class DreamRoomDatabase extends RoomDatabase{
    public abstract PlayerDao playerDao();

    private static DreamRoomDatabase INSTANCE;

    static DreamRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (DreamRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DreamRoomDatabase.class ,"dream_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
