package com.example.firstip.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstip.models.Team;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.teamViewHolder>{
//Adapter populates,view stores
    private Context Context;
    private List<Team> teams;

    public Adapter(Context Context ,List <Team> teams){
            Context= Context;
            teams = teams;

    }
    public class teamViewHolder extends RecyclerView.ViewHolder{

    }

    @Override
    public int getCount() {
        return mTeams.length;
    }

    @Override
    public Object getItem(int position) {
        String singleTeam = mTeams[position];
        String record = mseed[position];
        //format specifiers for strings %s
        return String.format(" %s  current seed is  %s ", singleTeam,record);
    }
}
