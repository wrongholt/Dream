package com.example.android.dream.views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.dream.data.AvatarRepository;
import com.example.android.dream.data.PlayerRepository;
import com.example.android.dream.models.Avatar;
import com.example.android.dream.models.Player;

import java.util.List;

public class DreamViewModel extends AndroidViewModel{
    private PlayerRepository mRepository;
    private AvatarRepository mAvatarRepository;
    private LiveData<List<Player>> mAllPlayers;
    private LiveData<List<Avatar>> mAllAvatars;
//    private LiveData<Avatar> singleAvatar;
    public DreamViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PlayerRepository(application);
        mAllPlayers = mRepository.getmAllPlayers();
        mAvatarRepository = new AvatarRepository(application);
        mAllAvatars = mAvatarRepository.getmAllAvatars();
//        singleAvatar = mAvatarRepository.singleAvatar();
    }
    LiveData<List<Player>> getmAllPlayers(){return mAllPlayers;}
    LiveData<List<Avatar>> getAllAvatars(){return mAllAvatars;}
//    LiveData<Avatar> singleAvatar(){return singleAvatar;}
    public void insert(Player player){
        mRepository.insert(player);
    }

    public void  insert(Avatar avatar){mAvatarRepository.insertAll(avatar);}
}
