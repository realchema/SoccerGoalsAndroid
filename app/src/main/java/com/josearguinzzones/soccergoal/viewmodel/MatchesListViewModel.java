package com.josearguinzzones.soccergoal.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.josearguinzzones.soccergoal.db.FavoriteTeamEntity;
import com.josearguinzzones.soccergoal.model.MatchesResponse;
import com.josearguinzzones.soccergoal.network.FootballDataService;
import com.josearguinzzones.soccergoal.network.ServiceBuilder;
import com.josearguinzzones.soccergoal.repository.MatchRepository;

//import org.jetbrains.annotations.NotNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;


import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.rxjava3.core.Scheduler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MatchesListViewModel extends AndroidViewModel {
    private MatchRepository repository;
    private LiveData<List<FavoriteTeamEntity>> allFavoritesTeams;
    protected static final String TAG = "Message";

    public MutableLiveData<MatchesResponse> matchesResult;

    public MatchesListViewModel(@NonNull Application application) {
        super(application);
        repository = new MatchRepository(application);
        allFavoritesTeams = repository.getAllFavoritesTeams();
        matchesResult = new MutableLiveData<>();
    }

    public MutableLiveData<MatchesResponse> getMatchesResultObserver() {
        return matchesResult;
    }

    public void insert(FavoriteTeamEntity favoriteTeamEntity){
        repository.insert(favoriteTeamEntity);
    }

    public void update(FavoriteTeamEntity favoriteTeamEntity){
        repository.update(favoriteTeamEntity);
    }

    public void delete(FavoriteTeamEntity favoriteTeamEntity){
        repository.delete(favoriteTeamEntity);
    }

    public void deleteAllFavoriteTeams(FavoriteTeamEntity favoriteTeamEntity){
        repository.deleteAllFavoritesTeams();
    }

    public LiveData<List<FavoriteTeamEntity>> getAllFavoritesTeams(){
        return allFavoritesTeams;
    }

    private CompositeDisposable disposable = new CompositeDisposable();
    private FootballDataService taskService = ServiceBuilder.buildService(FootballDataService.class);


    public void refresh(){
        fetchFromRemote();
    }

    private void fetchFromRemote() {

        // Like making a phone
        FootballDataService taskService = ServiceBuilder.buildService(FootballDataService.class);

        Call<MatchesResponse> call = taskService.getMatchesForCompetition(2014, 38);
        // Like onPostExecute()
        call.enqueue(new Callback<MatchesResponse>() {
            @Override
            public void onResponse(Call<MatchesResponse> request, Response<MatchesResponse> response) {
                matchesResult.postValue(response.body());
            }

            @Override
            public void onFailure(Call<MatchesResponse> request, Throwable t) {
                matchesResult.postValue(null);
            }
        });

    }

}
