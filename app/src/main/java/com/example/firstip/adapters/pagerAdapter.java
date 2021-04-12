package com.example.firstip.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.firstip.model2.Team;
import com.example.firstip.ui.teamFragment;

import java.util.List;

public class pagerAdapter extends FragmentPagerAdapter {
    private List<Team> mTeams;

    public pagerAdapter(@NonNull FragmentManager fm, int behavior, List<Team> teams){
        super(fm,behavior);
        mTeams = teams;

    }
    @Override
    public Fragment getItem(int position) {
        return teamFragment.newInstance(mTeams.get(position));
    }

    @Override
    public int getCount() {
        return mTeams.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTeams.get(position).getShortName();
    }

}
