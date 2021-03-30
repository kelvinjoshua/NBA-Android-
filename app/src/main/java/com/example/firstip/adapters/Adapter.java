package com.example.firstip.adapters;

import android.content.Context;
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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull teamViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class teamViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.city) TextView City;
        @BindView(R.id.fullName) TextView teamName;
        @BindView(R.id.logo) ImageView logo;
        private Context context;
        public teamViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindTeam(Team team){
            City.setText(team.getCity());
            teamName.setText(team.getFullName());

        }
    }

}
