package com.josearguinzzones.soccergoal.model;

public class Season {

    private int id;
    private int currentMatchday;

    public Season(int id, int currentMatchday) {
        this.id = id;
        this.currentMatchday = currentMatchday;
    }

    public int getId() {
        return id;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }
}
