package com.josearguinzzones.soccergoal.model;

import java.util.List;

public class MatchesResponse {

    private int count;
    private List<Match> matches;
    private Competition competition;

    public int getCount() {
        return count;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public Competition getCompetition() {
        return competition;
    }
}
