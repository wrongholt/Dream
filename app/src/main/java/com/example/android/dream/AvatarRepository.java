package com.example.android.dream;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AvatarRepository {
    private AvatarDao mAvatarDao;
private LiveData<List<Avatar>> mAllAvatars;
//    private LiveData<Avatar> singleAvatar;
    AvatarRepository(Application application) {
        DreamRoomDatabase db = DreamRoomDatabase.getDatabase(application);
        mAvatarDao = db.avatarDao();
        mAllAvatars = mAvatarDao.getAllAvatars();
//        singleAvatar = mAvatarDao.getSingleAvatar(1);
    }

LiveData<List<Avatar>> getmAllAvatars(){return mAllAvatars;}
//    LiveData<Avatar> singleAvatar(){return singleAvatar;}

    public void insertAll(Avatar avatar) {
        new insertAsyncTask(mAvatarDao).execute(avatar);
    }
    private static class insertAsyncTask extends AsyncTask<Avatar, Void, Void> {

        private AvatarDao mAsyncTaskDao;

        insertAsyncTask(AvatarDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Avatar... params) {
            return null;
        }
    }
}
