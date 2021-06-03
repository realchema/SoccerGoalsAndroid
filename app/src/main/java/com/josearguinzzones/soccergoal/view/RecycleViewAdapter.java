package com.josearguinzzones.soccergoal.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.josearguinzzones.soccergoal.R;
import com.josearguinzzones.soccergoal.model.Match;
import com.josearguinzzones.soccergoal.model.MatchResponse;
import com.josearguinzzones.soccergoal.model.MatchesResponse;
import com.josearguinzzones.soccergoal.util.Util;
import com.josearguinzzones.soccergoal.viewmodel.MatchesListViewModel;

import java.util.ArrayList;
import java.util.List;

//import masoud.ca.mvvm.R;
//import masoud.ca.mvvm.model.DogBreed;
//import masoud.ca.mvvm.util.Util;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MatchesViewHolder>  {

    private Context context;
    protected static final String TAG = "MessageFromR";
    // 1- Create an array of model objects
    private List<Match> matchesList;


    // Constructor
    public RecycleViewAdapter(Context context, Activity activity, List<Match> matchesList) {
        this.context = context;
        this.matchesList = matchesList;
        //this.matchesListViewModel = matchesListViewModel;
        //Log.e(TAG, "Recicly Passing:" );
        Log.e(TAG, "Recicly Passing:"  );
    }

    public void setMatchesList(List<Match> matchesList) {
        this.matchesList = matchesList;
        notifyDataSetChanged();
    }


    // 2- Inflate the cell layout
    @Override
    public MatchesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);

        // Create an object type MatchViewHolder and pass inflated view for each cell to its constructor

        return new MatchesViewHolder(view);
    }

    // 3- Attach the information from ArrayList to MatchViewHolder object for each cell
    @Override
    public void onBindViewHolder(MatchesViewHolder holder, int position) {
        Match match = matchesList.get(position);
        //Glide.with(context).load(match.getHomeTeam()).apply(options).into(holder.photo_image);
        // Create Reference to UI elements
//        ImageView crestHomeTeam = holder.itemView.findViewById(R.id.crestHomeTeam);
//        ImageView crestAwayTeam = holder.itemView.findViewById(R.id.crestAwayTeam);

//        TextView lifeSpan = holder.itemView.findViewById(R.id.lifespan);

        // Set value for UI elements
//        name.setText(dogsList.get(position).dogBreed);
        holder.status.setText(match.getStatus());
        holder.dateLabel.setText(match.getUtcDate().toString());
         holder.homeTeamScore.setText(match.getScore().getHomeTeamScore());
         holder.awayTeamScore.setText(match.getScore().getAwayTeamScore());
         holder.homeTeamName.setText(match.getHomeTeam().getName());
         String homeTeamCrestUrl = match.teamCrestUrl(match.getHomeTeam().getId());
         Util.loadImage(holder.crestHomeTeam, homeTeamCrestUrl, Util.getProgressDrawable(holder.crestHomeTeam.getContext()));
         holder.awayTeamName.setText(match.getAwayTeam().getName());
         String awayTeamCrestUrl = match.teamCrestUrl(match.getAwayTeam().getId());
         Util.loadImage(holder.crestAwayTeam, awayTeamCrestUrl, Util.getProgressDrawable(holder.crestAwayTeam.getContext()));
         Log.e(TAG, "Recicly Passing:" + homeTeamCrestUrl);

    }

    // 4- Return the number of elements we have for our RecyclerView
    @Override
    public int getItemCount() {
        if (this.matchesList != null){
            return this.matchesList.size();
        }
        return 0;
    }


    // 0- Create an inner class as a controller for RecyclerView cell
    class MatchesViewHolder extends RecyclerView.ViewHolder {
        TextView status;
        TextView dateLabel;
        TextView homeTeamName;
        TextView awayTeamName;
        TextView homeTeamScore;
        TextView awayTeamScore;
        ImageView crestHomeTeam;
        ImageView crestAwayTeam;
        // Reference to each cell view. Each cell view will pass to constructor
        // when we want to create an object from this class
        public View itemView;
        //public ItemDogBinding itemView;

        public MatchesViewHolder(@NonNull View itemView) {
            super(itemView);
             status = itemView.findViewById(R.id.live_text);
             dateLabel = itemView.findViewById(R.id.date_text);
             homeTeamName = itemView.findViewById(R.id.home_name_text);
             awayTeamName = itemView.findViewById(R.id.away_name_text);
             homeTeamScore = itemView.findViewById(R.id.home_score_text);
             awayTeamScore = itemView.findViewById(R.id.away_score_tex);
             crestHomeTeam = itemView.findViewById(R.id.crestHomeTeam);
             crestAwayTeam = itemView.findViewById(R.id.crestAwayTeam);
             this.itemView = itemView;
        }
    }
}
