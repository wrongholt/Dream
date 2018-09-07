package com.example.android.dream;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PlayerDao mDao;

        PopulateDbAsync(DreamRoomDatabase db) {
            mDao = db.playerDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll();

            Player player = new Player("John");
            mDao.insert(player);
            return null;
        }
    }
}
