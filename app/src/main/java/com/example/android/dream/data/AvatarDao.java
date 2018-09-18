package com.example.android.dream.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android.dream.models.Avatar;

import java.util.List;

@Dao
public interface AvatarDao {
    @Insert
    void insertAll(Avatar... avatars);

    @Query("DELETE FROM avatar_table")
    void deleteAll();

    @Query("SELECT * from avatar_table ORDER BY id ASC")
    LiveData<List<Avatar>> getAllAvatars();

    @Query("SELECT * from avatar_table WHERE id = :mId")
    LiveData<Avatar> getSingleAvatar(int mId);


}
