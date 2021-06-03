package com.josearguinzzones.soccergoal.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class Match {

    public static String STATUS_FINISHED = "FINISHED";
    public static String STATUS_IN_PLAY = "IN_PLAY";
    public static String STATUS_PAUSED = "PAUSED";
    public static String STATUS_SCHEDULED = "SCHEDULED";

    private int id;
    private Season season;
    private Date utcDate;
    private String status;
    private int matchday;
    private String stage;
    private String group;
    private Team homeTeam;
    private Team awayTeam;
//    private HashMap<String,String> homeTeam;
//    private HashMap<String,String> awayTeam;
    private Competition competition;
    private Score score;

    //@Override
    public int getId() {
        return id;
    }

    public Season getSeason() {
        return season;
    }

    public Date getUtcDate() {
        return utcDate;
    }

//    public LocalDateTime getLocalDateTime() {
//        return Instant.ofEpochMilli(utcDate.getTime())
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime();
//    }

    public String getStatus() {
        return status;
    }

    public int getMatchday() {
        return matchday;
    }

    public String getStage() {
        return stage;
    }

    public String getGroup() {
        return group;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

//        public HashMap<String, String> getHomeTeam() {
//        return homeTeam;
//    }
//
//    public HashMap<String, String> getAwayTeam() {
//        return awayTeam;
//    }

    public Score getScore() {
        return score;
    }

//    @Override
//    public String toString() {
//        if(homeTeam != null && awayTeam != null)
//            return homeTeam.get("name") + " - " + awayTeam.get("name");
//        return "empty match";
//    }

    public boolean isFinished(){
        return status.equals(STATUS_FINISHED);
    }

    public boolean isInSecondHalf(){
        return status.equals(STATUS_IN_PLAY) && (score.getHalfTime().get("homeTeam") != null);
    }

    public boolean isInPlay(){
        return status.equals(STATUS_IN_PLAY);
    }

    public boolean isPaused() {
        return status.equals(STATUS_PAUSED);
    }

    public Competition getCompetition() {
        return competition;
    }

    public String teamCrestUrl(int id){
        String url = "https://crests.football-data.org/"+id+".svg";
        return url;
    }

//    @Override
//    public int getType() {
//        return TYPE_DEFAULT;
//    }
}
