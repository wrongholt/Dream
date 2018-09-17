package com.example.android.dream;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "player_table")
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name = "equipmentId")
    private int equipmentId;
    @ColumnInfo(name = "avatarId")
    private String avatarId;

//    public Player(@NonNull String username, int equipmentId, String avatarId) {
//        this.username = username;
//        this.equipmentId = equipmentId;
//        this.avatarId = avatarId;
//    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public Player(@NonNull String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }
}
