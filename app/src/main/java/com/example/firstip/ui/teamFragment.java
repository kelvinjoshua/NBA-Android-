package com.example.firstip.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstip.R;
import com.example.firstip.models.Team;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class teamFragment extends Fragment {
    @BindView(R.id.cityView) TextView cityIcon;
    @BindView(R.id.basketPng) TextView ballIcon;
    @BindView(R.id.logo) ImageView logo;

private Team mteam;

    public teamFragment() {
        // Required empty public constructor
    }

    public static teamFragment newInstance(Team team) {
        teamFragment fragment = new teamFragment();
        Bundle args = new Bundle();
        args.putParcelable("TeamName", Parcels.wrap(team));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
         mteam= Parcels.unwrap(getArguments().getParcelable("TeamName"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_team, container, false);
        ButterKnife.bind(this, view);
        cityIcon.setText(mteam.getCity());
        ballIcon.setText(mteam.getNickname());
        Picasso.get().load(mteam.getLogo()).into(logo);
        return view;
    }

}
