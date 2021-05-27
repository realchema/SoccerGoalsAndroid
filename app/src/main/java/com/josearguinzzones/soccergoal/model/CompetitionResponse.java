package com.josearguinzzones.soccergoal.model;

import java.util.List;

public class CompetitionResponse {

    private int count;
    private List<Competition> competitions;

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "CompetitionResponse{" +
                "count=" + count +
                ", competitions=" + competitions +
                '}';
    }
}
