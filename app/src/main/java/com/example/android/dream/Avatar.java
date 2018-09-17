package com.example.android.dream;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "avatar_table")
public class Avatar {
    @PrimaryKey
    private int id;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "strength")
    private int strength;

    @ColumnInfo(name = "agility")
    private int agility;

    @ColumnInfo(name = "intelligence")
    private int intelligence;

    @ColumnInfo(name = "finesse")
    private int finesse;

    @ColumnInfo(name = "health")
    private int health;

    @ColumnInfo(name = "defense")
    private int defense;
    @ColumnInfo(name = "avatarPicture")
    private int avatarPicture;



    public Avatar(int id, @NonNull String name, @NonNull String description, int strength, int agility, int intelligence, int finesse, int health, int defense, int avatarPicture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.finesse = finesse;
        this.health = health;
        this.defense = defense;
        this.avatarPicture = avatarPicture;
    }
    public Avatar() {
    }
    public int getAvatarPicture() {
        return avatarPicture;
    }

    public void setAvatarPicture(int avatarPicture) {
        this.avatarPicture = avatarPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setFinesse(int finesse) {
        this.finesse = finesse;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getFinesse() {
        return finesse;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }


}
