package com.example.android.dream;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class DreamRepository {
    private PlayerDao mPlayerDao;
    private LiveData<List<Player>> mAllPlayers;

    DreamRepository(Application application) {
        DreamRoomDatabase db = DreamRoomDatabase.getDatabase(application);
        mPlayerDao = db.playerDao();
        mAllPlayers = mPlayerDao.getAllPlayers();
    }

    LiveData<List<Player>> getmAllPlayers() {
        return mAllPlayers;
    }

    public void insert(Player player) {
        new insertAsyncTask(mPlayerDao).execute(player);
    }

    private static class insertAsyncTask extends AsyncTask<Player, Void, Void> {

        private PlayerDao mAsyncTaskDao;

        insertAsyncTask(PlayerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Player... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
