package com.example.firstip.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.firstip.R;
import com.example.firstip.adapters.Adapter;
import com.example.firstip.models.Api;
import com.example.firstip.models.NbaSearchResponse;
import com.example.firstip.models.Team;
import com.example.firstip.network.RapidApi;
import com.example.firstip.network.RapidClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teams extends AppCompatActivity {
   // @BindView(R.id.errorTextView) TextView errorText;
    @BindView(R.id.recyclerView) RecyclerView recycler;
   // @BindView(R.id.westButton) Button West;
    //@BindView(R.id.editConferenceName) EditText western;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    public List<Team> eastTeams;//the teams we are retrieving
    private Adapter teamAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String confname = intent.getStringExtra("East");

        //Get default shared preference here
        //recycler needs a layout manager,adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);//our layout with the recyclerview activity-teams
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);


        RapidApi client = RapidClient.getClient();

        //this instance will be a retrofit object to allow building and making requests
        Call<NbaSearchResponse> call = client.getApi();//api object

        //processing request
        call.enqueue(new Callback<NbaSearchResponse>() {
            @Override
            public void onResponse(Call<NbaSearchResponse> call, Response<NbaSearchResponse> response) {
                //hideProgressBar();
                //Log.d("response", response.toString());
                if(response.isSuccessful()){
                    Log.d("succesful",response.body().getApi().getTeams().toString());
                    eastTeams = response.body().getApi().getTeams();//this should retrieve my teams
                    teamAdapter = new Adapter(Teams.this, eastTeams);
                    //instantiate an adapter and associate it to our recycler view
                   teamAdapter.notifyDataSetChanged();
                    recycler.setAdapter(teamAdapter);
                   //showTeams();
                }

                else{
                    showUnsuccessfulMessage();
                }

            }

            @Override
            public void onFailure(Call<NbaSearchResponse> call, Throwable t) {
                Log.d("error","no response");
                //hideProgressBar();
                //showFailureMessage();
            }
        });
    }


    //Toggling visibility and providing feedback
    private void showFailureMessage() {
       // errorText.setText("Something went wrong. Please check your Internet connection and try again later");
        //errorText.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
       // errorText.setText("Something went wrong. Please try again later");
       // errorText.setVisibility(View.VISIBLE);
    }

   private void showTeams() {
    //  recycler.setVisibility(View.VISIBLE);
       // mLocationTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);//toggle from visible to gone
    }

}