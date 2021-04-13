package com.example.firstip.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.firstip.R;
import com.example.firstip.models.Team;
import com.example.firstip.ui.TeamActivty;
import com.example.firstip.util.ItemTouchHelperAdapter;
import com.example.firstip.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//inherits our interfaces
public class FireBaseListAdapter extends FirebaseRecyclerAdapter<Team, FirebaseTeamViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference ref;
    private OnStartDragListener OnStartDragListener;
    private Context context;

    private ChildEventListener ChildEventListener;//listen for any children and store them
    private List<Team>  teamsGet = new ArrayList<>();

    public FireBaseListAdapter(FirebaseRecyclerOptions<Team> options, Query reference, OnStartDragListener dragListener, Context Context){
        super(options);
        ref = reference.getRef();
        OnStartDragListener = dragListener;
        context = Context;

        ChildEventListener = ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                teamsGet.add(snapshot.getValue(Team.class));//get and add children to the array
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //make sure array reflects changes tracked by adapter
        Collections.swap(teamsGet,fromPosition,toPosition);//update order
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFirebase();
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        teamsGet.remove(position);
        getRef(position).removeValue();
    }

    //once user has interacted
    @Override
    public void stopListening() {
        super.stopListening();
    ref.removeEventListener(ChildEventListener);
    }


    @Override
    protected void onBindViewHolder(@NonNull FirebaseTeamViewHolder holder, int position, @NonNull Team team) {
        holder.bindTeam(team);
        holder.logo.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    OnStartDragListener.onStartDrag(holder);
                }
                return false;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TeamActivty.class);
                intent.putExtra("position", holder.getAdapterPosition());
                intent.putExtra("Teams", Parcels.wrap(teamsGet));

                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public FirebaseTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item_drag, parent, false);
        return new FirebaseTeamViewHolder(view);
    }
    private void setIndexInFirebase() {
        //reassign indexes and save to database
        for (Team team : teamsGet) {
            int index = teamsGet.indexOf(team);
            DatabaseReference ref = getRef(index);
            team.setIndex(Integer.toString(index));
            ref.setValue(team);
        }
    }
}
