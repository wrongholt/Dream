package com.example.android.dream;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Player.class,Avatar.class}, version = 3)
public abstract class DreamRoomDatabase extends RoomDatabase{
    public abstract PlayerDao playerDao();
    public  abstract AvatarDao avatarDao();
    private static DreamRoomDatabase INSTANCE;
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
                  }
    };
    static DreamRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (DreamRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DreamRoomDatabase.class ,"dream_database").addMigrations(MIGRATION_2_3).addCallback(sRoomDatabaseCallback).build();
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

        private final AvatarDao mAvatarDao;

        PopulateDbAsync(DreamRoomDatabase db) {
            mAvatarDao = db.avatarDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mAvatarDao.deleteAll();

            Avatar[] avatars = {
                new Avatar(1,"Cheetah","This cool cat is fast and nice",12,22,12,14,14,23,R.drawable.jaguar),
                        new Avatar(2,"Cheetah","This cool cat is fast and nice",12,22,12,14,14,23,R.drawable.jaguar),
                        new Avatar(3,"Cheetah","This cool cat is fast and nice",12,22,12,14,14,23,R.drawable.jaguar),
                        new Avatar(4,"Cheetah","This cool cat is fast and nice",12,22,12,14,14,23,R.drawable.jaguar)
            };
            mAvatarDao.insertAll(avatars);


            return null;
        }
    }
}
