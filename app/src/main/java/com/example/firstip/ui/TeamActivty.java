package com.example.firstip.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.firstip.R;
import com.example.firstip.adapters.pagerAdapter;
import com.example.firstip.models.Team;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamActivty extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager viewPager;
    private pagerAdapter adapterViewPager;
    List<Team> mTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_activty);
        ButterKnife.bind(this);
        mTeams = Parcels.unwrap(getIntent().getParcelableExtra("Teams"));
        int startingPosition = getIntent().getIntExtra("position",0);
        adapterViewPager = new pagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTeams);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setCurrentItem(startingPosition);

    }
}