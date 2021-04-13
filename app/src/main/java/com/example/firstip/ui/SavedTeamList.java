package com.example.firstip.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstip.Constants;
import com.example.firstip.R;
import com.example.firstip.adapters.FirebaseTeamViewHolder;
import com.example.firstip.models.Team;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

//LAYOUT FOR SAVED TEAMS
public class SavedTeamList extends AppCompatActivity {
    @BindView(R.id.recyclerView) RecyclerView recycler;
    private DatabaseReference teamRef;
    private FirebaseRecyclerAdapter<Team, FirebaseTeamViewHolder> FirebaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);
        teamRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TEAM);
        setUpFirebaseAdapter();//declare logic for this method outside oncreate
    }

    private void setUpFirebaseAdapter() {
        //build object
        FirebaseRecyclerOptions<Team> options = new FirebaseRecyclerOptions.Builder<Team>().setQuery(teamRef, Team.class).build();
        FirebaseAdapter = new FirebaseRecyclerAdapter<Team, FirebaseTeamViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseTeamViewHolder holder, int position, @NonNull Team team) {
                    holder.bindTeam(team);
            }

            @NonNull
            @Override
            public FirebaseTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item_drag,parent,false);
                return new FirebaseTeamViewHolder(view);
            }
        };
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(FirebaseAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(FirebaseAdapter!= null) {
            FirebaseAdapter.stopListening();
        }
    }

}