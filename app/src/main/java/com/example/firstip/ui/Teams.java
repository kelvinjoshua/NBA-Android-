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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.firstip.R;
import com.example.firstip.adapters.Adapter;
import com.example.firstip.model2.NbaSearchResponse;
import com.example.firstip.model2.Team;
import com.example.firstip.network.RapidApi;
import com.example.firstip.network.RapidClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teams extends AppCompatActivity {
    //@BindView(R.id.errorTextView) TextView errorText;
    @BindView(R.id.recyclerView) RecyclerView recycler;
    //@BindView(R.id.westButton) Button West;
    //@BindView(R.id.editConferenceName) EditText western;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    public List<Team> eastTeams;
    private Adapter teamAdapter;
    private static final String TAG = "Teams";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String confname = intent.getStringExtra("East");
        //this instance will be a retrofit object to allow building and making requests
        //our recycler needs a layout manager and an adapter
        //RecyclerView.LayoutManager

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Teams.this);//our layout with the recyclerview activity-teams
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);

        RapidApi client = RapidClient.getClient();
        //Response<NbaSearchResponse> response = client.newCall(request).execute();
        Call<NbaSearchResponse> call = client.getApi();
        //processing request
        call.enqueue(new Callback<NbaSearchResponse>() {
            @Override
            public void onResponse(Call<NbaSearchResponse> call, Response<NbaSearchResponse> response) {
                //response = okHttpClient.newCall(request).execute();
                //hideProgressBar();
                //Response response = client.newCall(request).execute();
                if(response.isSuccessful()){
                    Log.d(TAG,response.body().getApi().getTeams().toString());
                    eastTeams =response.body().getApi().getTeams();
                   // Log.d("data",eastTeams.toString());
                    //instantiate an adapter and associate it to our recycler view
                    teamAdapter = new Adapter(Teams.this, eastTeams);

                    teamAdapter.notifyDataSetChanged();
                    recycler.setAdapter(teamAdapter);
                    //create layout manager for respective recycler view
                }
                /*
                else{
                    showUnsuccessfulMessage();
                }
                 */
               teamAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NbaSearchResponse> call, Throwable t) {
                //hideProgressBar();
                //showFailureMessage();
                Log.d("errr","failure");
            }
        });
        /*Custom adapter*/

        //attach adapter to list view
            /*
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start another activity
                Intent intent = new Intent(Teams.this,last.class);
                //String conferenceName = eastern.getText().toString();
                //intent.putExtra("EasternConf",conferenceName); //key-value
                startActivity(intent);
            }
        });
       // mlist.setAdapter(adapter);
       /* mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Teams.this,"Clinched Playoff position",Toast.LENGTH_LONG).show();
            }
        });

        */
           

        //we get text and set it to the display value//
        //showText.setText("Here are the Standings for " + " " + Retrieved + " "+"Western-Conference");
    }

    //Toggling visibility and providing feedback
    /*
    private void showFailureMessage() {
        errorText.setText("Something went wrong. Please check your Internet connection and try again later");
        errorText.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        errorText.setText("Something went wrong. Please try again later");
        errorText.setVisibility(View.VISIBLE);
    }
    */
    private void showTeams() {
        recycler.setVisibility(View.VISIBLE);
        //mLocationTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);//toggle from visible to gone
    }

}