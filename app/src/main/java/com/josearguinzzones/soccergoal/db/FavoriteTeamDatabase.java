package com.josearguinzzones.soccergoal.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

@Database(entities = {FavoriteTeamEntity.class}, version = 1)
public abstract class FavoriteTeamDatabase extends RoomDatabase {
    private static FavoriteTeamDatabase instance;
    public abstract FavoriteTeamDAO favoriteTeamDAO();

    public static synchronized FavoriteTeamDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FavoriteTeamDatabase.class, "favoriteTeamData")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback  = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private FavoriteTeamDAO favoriteTeamDAO;

        private PopulateDbAsyncTask(FavoriteTeamDatabase db){
            favoriteTeamDAO = db.favoriteTeamDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //favoriteTeamDAO.insert(new FavoriteTeamEntity(1,"Real Madrid", ));
            return null;
        }
    }
}
