package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstip.adapters.Adapter;
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
    @BindView(R.id.errorTextView) TextView errorText;
    @BindView(R.id.recyclerView) RecyclerView recycler;
    @BindView(R.id.westButton) Button West;
    @BindView(R.id.editConferenceName) EditText western;

    public List<Team> eastTeams;
    public Adapter teamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        Intent intent = getIntent();
        String Retrieved = intent.getStringExtra("East");
        //this instance will be a retrofit object to allow building and making requests
        RapidApi client = RapidClient.getClient();

        Call<NbaSearchResponse> call = client.getTeams(Retrieved);
        //processing request
        call.enqueue(new Callback<NbaSearchResponse>() {
            @Override
            public void onResponse(Call<NbaSearchResponse> call, Response<NbaSearchResponse> response) {

                if(response.isSuccessful()){
                    //hideprogressbar
                    eastTeams = response.body().getTeams();
                    //note no resource for our layout
                    teamAdapter = new Adapter(Teams.this, eastTeams);
                    recycler.setAdapter(teamAdapter);

                    //layout manager
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Teams.this);
                    recycler.setLayoutManager(layoutManager);
                    recycler.setHasFixedSize(true);

                    //show teams
                }
            }

            @Override
            public void onFailure(Call<NbaSearchResponse> call, Throwable t) {

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
}