package com.josearguinzzones.soccergoal.model;

public class Table {

    private int position;
    private Team team;
    private int playedGames;
    private int won;
    private int draw;
    private int lost;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;

    public int getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getWon() {
        return won;
    }

    public int getDraw() {
        return draw;
    }

    public int getLost() {
        return lost;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

//    @Override
//    public int getType() {
//        return TYPE_DEFAULT;
//    }

    //@Override
    public int getId() {
        return team.getId();
    }
}
