package com.josearguinzzones.soccergoal.model;

public class Competition {

    private int id;
    private String name;
    private String code;
    private Season currentSeason;
    private Area area;
    private int themeColor;

    public Competition(int id, String name, Season currentSeason, int themeColor) {
        this.id = id;
        this.name = name;
        this.currentSeason = currentSeason;
        this.themeColor = themeColor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Area getArea() {
        return area;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public int getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(int themeColor) {
        this.themeColor = themeColor;
    }
}
