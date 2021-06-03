package com.josearguinzzones.soccergoal.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.josearguinzzones.soccergoal.db.FavoriteTeamDAO;
import com.josearguinzzones.soccergoal.db.FavoriteTeamDatabase;
import com.josearguinzzones.soccergoal.db.FavoriteTeamEntity;
import com.josearguinzzones.soccergoal.model.MatchesResponse;
import com.josearguinzzones.soccergoal.network.FootballDataService;
import com.josearguinzzones.soccergoal.network.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchRepository {

    private FavoriteTeamDAO favoriteTeamDao;
    private LiveData<List<FavoriteTeamEntity>> allFavoritesTeams;
    private static LiveData<MatchesResponse> allMatchesResponse;

    public MatchRepository(Application application) {
        FavoriteTeamDatabase favoriteTeamDatabase = FavoriteTeamDatabase.getInstance(application);
        favoriteTeamDao = favoriteTeamDatabase.favoriteTeamDAO();
        allFavoritesTeams = favoriteTeamDao.getAll();

    }

    public void insert(FavoriteTeamEntity favoriteTeamEntity){
        new InsertFavoriteElementAsyncTask(favoriteTeamDao).execute(favoriteTeamEntity);
    }
    
    public void update(FavoriteTeamEntity favoriteTeamEntity){
        new UpdateFavoriteElementAsyncTask(favoriteTeamDao).execute(favoriteTeamEntity);
    }
    
    public void delete(FavoriteTeamEntity favoriteTeamEntity){
        new DeleteFavoriteElementAsyncTask(favoriteTeamDao).execute(favoriteTeamEntity);
    }
    
    public void deleteAllFavoritesTeams() {
        new DeleteAllFavoriteElementAsyncTask(favoriteTeamDao).execute();
    }
    
    public LiveData<List<FavoriteTeamEntity>> getAllFavoritesTeams(){
        return allFavoritesTeams;
    }

    private static class InsertFavoriteElementAsyncTask extends AsyncTask<FavoriteTeamEntity, Void, Void> {
        private FavoriteTeamDAO favoriteTeamDAO;

        public InsertFavoriteElementAsyncTask(FavoriteTeamDAO favoriteTeamDAO) {
            this.favoriteTeamDAO = favoriteTeamDAO;
        }

        @Override
        protected Void doInBackground(FavoriteTeamEntity... favoriteTeamEntities) {
            favoriteTeamDAO.insert(favoriteTeamEntities[0]);
            return null;
        }
    }

    private static class UpdateFavoriteElementAsyncTask extends AsyncTask<FavoriteTeamEntity, Void, Void> {
        private FavoriteTeamDAO favoriteTeamDAO;

        public UpdateFavoriteElementAsyncTask(FavoriteTeamDAO favoriteTeamDAO) {
            this.favoriteTeamDAO = favoriteTeamDAO;
        }

        @Override
        protected Void doInBackground(FavoriteTeamEntity... favoriteTeamEntities) {
            favoriteTeamDAO.update(favoriteTeamEntities[0]);
            return null;
        }
    }

    private static class DeleteFavoriteElementAsyncTask extends AsyncTask<FavoriteTeamEntity, Void, Void> {
        private FavoriteTeamDAO favoriteTeamDAO;

        public DeleteFavoriteElementAsyncTask(FavoriteTeamDAO favoriteTeamDAO) {
            this.favoriteTeamDAO = favoriteTeamDAO;
        }

        @Override
        protected Void doInBackground(FavoriteTeamEntity... favoriteTeamEntities) {
            favoriteTeamDAO.delete(favoriteTeamEntities[0]);
            return null;
        }
    }

    private static class DeleteAllFavoriteElementAsyncTask extends AsyncTask<FavoriteTeamEntity, Void, Void> {
        private FavoriteTeamDAO favoriteTeamDAO;

        public DeleteAllFavoriteElementAsyncTask(FavoriteTeamDAO favoriteTeamDAO) {
            this.favoriteTeamDAO = favoriteTeamDAO;
        }

        @Override
        protected Void doInBackground(FavoriteTeamEntity... favoriteTeamEntities) {
            favoriteTeamDAO.deleteAllTeams();
            return null;
        }
    }

    private static class FetchMatchesByCompetition {
        private MatchesResponse matchesResponse;

        public FetchMatchesByCompetition(MatchesResponse matchesResponse) {
            this.matchesResponse = matchesResponse;
        }

        private void fetchFromRemote() {

            // Like making a phone
            FootballDataService taskService = ServiceBuilder.buildService(FootballDataService.class);

            Call<MatchesResponse> call = taskService.getMatchesForCompetition(2014, 38);
            // Like onPostExecute()
            call.enqueue(new Callback<MatchesResponse>() {
                @Override
                public void onResponse(Call<MatchesResponse> request, Response<MatchesResponse> response) {
                    //allMatchesResponse.postValue(response.body());
                }

                @Override
                public void onFailure(Call<MatchesResponse> request, Throwable t) {
                    //allMatchesResponse.postValue(null);
                }
            });

        }
    }


}
