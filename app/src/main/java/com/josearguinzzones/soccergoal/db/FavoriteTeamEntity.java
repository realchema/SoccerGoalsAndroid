package com.josearguinzzones.soccergoal.db;

import java.io.Serializable;
import java.util.Arrays;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FavoriteTeamEntity implements Serializable {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "image")
    private byte[] image;

    public FavoriteTeamEntity() {
    }

    public FavoriteTeamEntity(int id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FavoriteTeamEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
