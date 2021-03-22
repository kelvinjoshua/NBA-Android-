package com.example.firstip;

import android.content.Context;
import android.widget.ArrayAdapter;

public class Adapter extends ArrayAdapter {
    private Context mContext;
    private String[] mTeams;
    private String[] mPlayers;
    //resource here is our layout
    public Adapter(Context mContext,int resource,String[] mTeams,String[] mPlayers){
            //as subclasss,access to overriden methods and private properties
        super(mContext,resource);
        this.mContext =mContext;
        this.mPlayers =mPlayers;
        this.mTeams =mTeams;
    }


}
