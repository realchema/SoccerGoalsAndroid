package com.josearguinzzones.soccergoal.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteTeamEntity.class}, version = 1)
public abstract class FavoriteTeamDatabase extends RoomDatabase {
    public abstract FavoriteTeamDAO getPersonDAO();
}
