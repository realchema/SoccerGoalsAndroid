package com.josearguinzzones.soccergoal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.josearguinzzones.soccergoal.R;
import com.josearguinzzones.soccergoal.model.Competition;
import com.josearguinzzones.soccergoal.model.CompetitionResponse;
import com.josearguinzzones.soccergoal.model.Match;
import com.josearguinzzones.soccergoal.model.MatchesResponse;
import com.josearguinzzones.soccergoal.model.Team;
import com.josearguinzzones.soccergoal.network.FootballDataService;
import com.josearguinzzones.soccergoal.network.ServiceBuilder;
import com.josearguinzzones.soccergoal.viewmodel.MatchesListViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    protected static final String TAG = "MessageMainActivity";
    private RecyclerView recyclerView;
    private RecycleViewAdapter recyclerView_adapter;
    private List<Match> matchesList;
    private MatchesListViewModel viewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {

//        matchesListViewModel  = ViewModelProviders.of(this).get(MatchesListViewModel.class);
//        matchesListViewModel.getMatchesResult().observe(this, new Observer<MatchesResponse>() {
//            @Override
//            public void onChanged(MatchesResponse matchesResponse) {
//                // update RecyclerView
//                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
//            }
//        });

        //Log.e(TAG, "Retrofit Passing:" + matchesListViewModel.getResult().getValue().toString() );
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView_adapter = new RecycleViewAdapter(this, MainActivity.this, matchesList);
        recyclerView.setAdapter(recyclerView_adapter);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        viewModel = ViewModelProviders.of(this).get(MatchesListViewModel.class);
        viewModel.getMatchesResultObserver().observe(this, new Observer<MatchesResponse>() {
            @Override
            public void onChanged(MatchesResponse matchesResponse) {
                if(matchesResponse != null){
                    matchesList = matchesResponse.getMatches();
                    recyclerView_adapter.setMatchesList(matchesResponse.getMatches());

                } else {
                    System.out.println("no result");
                    Log.e(TAG, "No Data!!!:");
                }
            }
        });
        viewModel.refresh();
    }
}