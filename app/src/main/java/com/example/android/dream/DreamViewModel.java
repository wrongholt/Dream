package com.example.android.dream;

import android.app.Application;
import android.app.ListActivity;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class DreamViewModel extends AndroidViewModel{
    private DreamRepository mRepository;
    private LiveData<List<Player>> mAllPlayers;
    public DreamViewModel(@NonNull Application application) {
        super(application);
        mRepository = new DreamRepository(application);
        mAllPlayers = mRepository.getmAllPlayers();
    }
    LiveData<List<Player>> getmAllPlayers(){return mAllPlayers;}

    public void insert(Player player){
        mRepository.insert(player);
    }
}
