package com.example.android.dream;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface PlayerDao {
    @Insert
    void insert(Player player);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Query("SELECT * from player_table ORDER BY username ASC")
    LiveData<List<Player>> getAllPlayers();
}
