package com.example.android.dream.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android.dream.models.Player;

import java.util.List;

public class PlayerRepository {
    private PlayerDao mPlayerDao;
    private LiveData<List<Player>> mAllPlayers;

    PlayerRepository(Application application) {
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
