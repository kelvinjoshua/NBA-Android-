package com.example.firstip;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter {
    private Context mContext;
    private String[] mTeams;
    private String[] mPlayers;
    //resource here is our layout
    public Adapter(Context mContext,int resource,String[] mTeams,String[] mPlayers){
            //as subClass,access to overriden methods and private properties
        super(mContext,resource);
        this.mContext =mContext;
        this.mPlayers =mPlayers;
        this.mTeams =mTeams;
    }

    @Override
    public int getCount() {
        return mTeams.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String singleTeam = mTeams[position];
        String players = mPlayers[position];
        //format specifiers for strings %s
        return String.format("%s has % players", singleTeam,players);
    }
}
