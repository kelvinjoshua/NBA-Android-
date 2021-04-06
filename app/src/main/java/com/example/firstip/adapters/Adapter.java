package com.example.firstip.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstip.R;
import com.example.firstip.models.Team;
import com.example.firstip.ui.TeamActivty;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//adapter needs viewholder
public class Adapter extends RecyclerView.Adapter<Adapter.teamViewHolder>{
//Adapter populates,view stores
    private Context mContext;
    private List<Team> mteams = new ArrayList();

    public Adapter(Context context,List<Team> teams){
        context = mContext;
        teams = mteams;
    }

    @Override
    public teamViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        //inflate layout return viewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_team_item, parent, false);
        teamViewHolder viewHolder = new teamViewHolder(view);//hold /store our view
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( teamViewHolder holder, int position) {
        //create an instance of viewHolder to use its method, team in teams array
        holder.bindTeam(mteams.get(position));
    }

    @Override
    public int getItemCount() {
        return mteams.size();
    }

    public class teamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //bind views specific to our individual team item
        @BindView(R.id.city) TextView City;
        @BindView(R.id.fullName) TextView teamName;
        @BindView(R.id.logo) ImageView logo;
        private Context mContext;
        public teamViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener((View.OnClickListener) this);
        }

        //set data for our attributes ,called by onBind()
        public void bindTeam(Team team){
            City.setText(team.getCity());
            teamName.setText(team.getFullName());
            Picasso.get().load(team.getLogo()).into(logo);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, TeamActivty.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("Teams", Parcels.wrap(mteams));
            mContext.startActivity(intent);
        }
    }

}
