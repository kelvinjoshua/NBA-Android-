package com.example.firstip.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstip.R;
import com.example.firstip.models.Team;
import com.example.firstip.ui.TeamActivty;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.teamViewHolder>{
//Adapter populates,view stores
    private Context Context;
    private List<Team> teams;

    public Adapter(Context Context ,List <Team> teams){
            Context= Context;
            teams = teams;
    }

    @NonNull
    @Override
    public teamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout return viewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_item, parent, false);
        teamViewHolder viewHolder = new teamViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull teamViewHolder holder, int position) {
        holder.bindTeam(teams.get(position));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class teamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.city) TextView City;
        @BindView(R.id.fullName) TextView teamName;
        @BindView(R.id.logo) ImageView logo;
        private Context context;
        public teamViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener((View.OnClickListener) this);
        }


        public void bindTeam(Team team){
            City.setText(team.getCity());
            teamName.setText(team.getFullName());
            Picasso.get().load(team.getLogo()).into(logo);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(context, TeamActivty.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("Teams", Parcels.wrap(teams));
            context.startActivity(intent);
        }
    }

}
