package com.josearguinzzones.soccergoal.model;

public class Team {

    private int id;
    private String name;
    private String crestUrl;
    private String clubColors;
    private String venue;
    private int founded;
    private Area area;
    private String website;
    private String tla;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public String getClubColors() {
        return clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public int getFounded() {
        return founded;
    }

    public Area getArea() {
        return area;
    }

    public String getWebsite() {
        return website;
    }

    public String getTla() {
        return tla;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crestUrl='" + crestUrl + '\'' +
                ", clubColors='" + clubColors + '\'' +
                ", venue='" + venue + '\'' +
                ", founded=" + founded +
                ", area=" + area +
                ", website='" + website + '\'' +
                ", tla='" + tla + '\'' +
                '}';
    }
}
