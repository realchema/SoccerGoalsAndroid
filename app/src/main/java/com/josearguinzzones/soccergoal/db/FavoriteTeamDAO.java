package com.josearguinzzones.soccergoal.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.josearguinzzones.soccergoal.model.Team;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface FavoriteTeamDAO {

    @Insert
    void insert(FavoriteTeamEntity favoriteTeamEntity);

    @Update
    void update(FavoriteTeamEntity favoriteTeamEntity);

    @Delete
    void delete(FavoriteTeamEntity favoriteTeamEntity);

    @Query("DELETE FROM favoriteTeamEntity")
    void deleteAllTeams();

    @Query("SELECT * FROM favoriteTeamEntity")
    LiveData<List<FavoriteTeamEntity>> getAll();

    @Query("SELECT * FROM favoriteTeamEntity WHERE id = :id")
    Single<FavoriteTeamEntity> getById(int id);

//    @Query("SELECT * FROM favoriteTeamEntity")
//    Single<List<FavoriteTeamEntity>> getAll();
//
//    @Query("SELECT * FROM favoriteTeamEntity WHERE id = :id")
//    Single<FavoriteTeamEntity> getById(int id);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    Completable insert(FavoriteTeamEntity favoriteTeamEntity);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    Completable insertAll(List<FavoriteTeamEntity> favoriteTeamEntity);
//
//    @Update
//    Completable update(FavoriteTeamEntity favoriteTeamEntity);
//
//    @Delete
//    Completable delete(FavoriteTeamEntity favoriteTeamEntity);
}
