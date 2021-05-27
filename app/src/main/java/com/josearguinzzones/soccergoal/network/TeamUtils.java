package com.josearguinzzones.soccergoal.network;

import android.net.Uri;
import android.util.Log;

import com.josearguinzzones.soccergoal.model.Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class TeamUtils extends NetworkUtils {
    private String code;

    public URL buildUrl(String code){
        this.code = code;
        Uri builtUri = Uri.parse(API_URL).buildUpon()
                .appendPath("v1")
                .appendPath("competitions")
                .appendPath(code)
                .appendPath("leagueTable")
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException mfe){
            mfe.printStackTrace();
        }
        return url;
    }


    public Team getResponseFromJson(String response, String team){

        //HashMap<String,Team> competitionMap = new HashMap<String, Team>();
        Team teamObj = null;
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray standings = jsonObj.getJSONArray("standing");
            for(int j = 0; j < standings.length(); j++){

                JSONObject row = standings.getJSONObject(j);
                if( row.getString("teamName").equals(team)) {

                    JSONObject homeObj = row.getJSONObject("home");
                    JSONObject awayObj = row.getJSONObject("away");


                    // competitionMap.put("team", teamObj);

                }

            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return teamObj;
    }
}
