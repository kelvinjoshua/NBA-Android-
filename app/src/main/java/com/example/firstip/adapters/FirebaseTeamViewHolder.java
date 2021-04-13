package com.example.firstip.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstip.Constants;
import com.example.firstip.R;
import com.example.firstip.models.Team;
import com.example.firstip.ui.TeamActivty;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseTeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.city) TextView City;
    @BindView(R.id.fullName) TextView teamName;
    @BindView(R.id.logo) ImageView logo;
    View view;
    Context context;

    public FirebaseTeamViewHolder(View itemView){
        super(itemView);
        view = itemView;
        context = itemView.getContext();
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }
    public void bindTeam(Team team){

        City.setText(team.getCity());
        teamName.setText(team.getFullName());
        Picasso.get().load(team.getLogo()).into(logo);
    }
    @Override
    public void onClick(View v) {
        final List<Team> savedTeams = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TEAM);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                for (DataSnapshot textSnap: snapshot.getChildren()) {
                    savedTeams.add(snapshot.getValue(Team.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(context, TeamActivty.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("Teams", Parcels.wrap(savedTeams));

                context.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
