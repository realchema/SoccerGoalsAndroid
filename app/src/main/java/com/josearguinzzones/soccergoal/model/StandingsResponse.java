package com.josearguinzzones.soccergoal.model;

import java.util.List;

public class StandingsResponse {

    private Competition competition;
    private List<Stages> standings;

    public Competition getCompetition() {
        return competition;
    }

    public List<Stages> getStages() {
        return standings;
    }
}
