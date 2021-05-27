package com.josearguinzzones.soccergoal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.josearguinzzones.soccergoal.model.CompetitionResponse;
import com.josearguinzzones.soccergoal.network.FootballDataService;
import com.josearguinzzones.soccergoal.network.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    protected static final String TAG = "Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        endPointCallWithRetrofit();
    }

    public void endPointCallWithRetrofit(){
        Toast.makeText(this,"endPointCallWithRetrofit",Toast.LENGTH_SHORT).show();

        // Like making a phone
        FootballDataService taskService = ServiceBuilder.buildService(FootballDataService.class);

        // Use phone to make a Call http://10.0.2.2:9000/messages
        Call<CompetitionResponse> call = taskService.getCompetitions();
        Log.e(TAG, "Retrofit Before Call:" );
        // Like onPostExecute()
        call.enqueue(new Callback<CompetitionResponse>() {
            @Override
            public void onResponse(Call<CompetitionResponse> request, Response<CompetitionResponse> response) {
                ((TextView)findViewById(R.id.message)).setText(response.body().getCompetitions().get(0).getName());
                System.out.print(response.body().getCount() + "helooooo2");
                Log.e(TAG, "Retrofit Passing:" + response.body().getCount() );

            }

            @Override
            public void onFailure(Call<CompetitionResponse> request, Throwable t) {
                System.out.print( "helooooo3");
                Log.e(TAG, "Retrofit ERROR:" );
                ((TextView)findViewById(R.id.message)).setText("Request Failed");
                System.out.println(
                        "----------------------------------------" + "\n" +
                                t.toString() + "\n" +
                                "----------------------------------------");
            }
        });
    }
}