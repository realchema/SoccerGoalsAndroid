package com.josearguinzzones.soccergoal.network;

import com.josearguinzzones.soccergoal.model.Competition;
import com.josearguinzzones.soccergoal.model.CompetitionResponse;
import com.josearguinzzones.soccergoal.model.MatchResponse;
import com.josearguinzzones.soccergoal.model.MatchesResponse;
import com.josearguinzzones.soccergoal.model.StandingsResponse;
import com.josearguinzzones.soccergoal.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FootballDataService {

    // URL mapping and return type
    @GET("competitions?plan=TIER_ONE")
    Call<CompetitionResponse> getCompetitions();

    @GET("competitions/{id}")
    Call<Competition> getCompetitionById(@Path("id") int id);

    @GET("competitions/{id}/standings")
    Call<StandingsResponse> getCompetitionStandings(@Path("id") int id);

    @GET("teams/{id}")
    Call<Team> getTeamById(@Path("id") int id);

    @GET("matches/{id}")
    Call<MatchResponse> getMatchById(@Path("id") int id);

    @GET("competitions/{id}/matches")
    Call<MatchesResponse> getMatchesForCompetition(@Path("id") int competitionId, @Query("matchday") int matchday);

    @GET("teams/{id}/matches")
    Call<MatchesResponse> getMatchesForTeam(@Path("id") int teamId, @Query("dateFrom") String dateFrom,@Query("dateTo") String dateTo);
}
