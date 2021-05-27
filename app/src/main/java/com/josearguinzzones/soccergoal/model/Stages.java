package com.josearguinzzones.soccergoal.model;

import java.util.List;

public class Stages {

    public static final String TYPE_TOTAL = "TOTAL";

    private String stage;
    private String type;
    private String group;
    private List<Table> table;

    public String getStageName() {
        return stage;
    }

    public String getType() {
        return type;
    }

    public String getGroup() {
        return group;
    }

    public List<Table> getTable() {
        return table;
    }

}
