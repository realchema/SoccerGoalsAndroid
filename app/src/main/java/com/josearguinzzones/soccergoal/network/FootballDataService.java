package com.josearguinzzones.soccergoal.network;

import com.josearguinzzones.soccergoal.model.Competition;
import com.josearguinzzones.soccergoal.model.CompetitionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FootballDataService {

    // URL mapping and return type
    @GET("competitions?plan=TIER_ONE")
    Call<Competition> getMessages();
    @GET("competitions?plan=TIER_ONE")
    Call<CompetitionResponse> getCompetitions();
}
