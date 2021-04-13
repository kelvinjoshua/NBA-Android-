package com.example.firstip.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstip.Constants;
import com.example.firstip.R;
import com.example.firstip.adapters.FireBaseListAdapter;
import com.example.firstip.adapters.FirebaseTeamViewHolder;
import com.example.firstip.models.Team;
import com.example.firstip.util.ItemTouchCallback;
import com.example.firstip.util.ItemTouchHelperAdapter;
import com.example.firstip.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

//LAYOUT FOR SAVED TEAMS
public class SavedTeamList extends AppCompatActivity implements OnStartDragListener {
    @BindView(R.id.recyclerView) RecyclerView recycler;
    //public ItemTouchHelperAdapter itemTouchHelper;
    private ItemTouchHelper itemTouchHelper;
    private DatabaseReference teamRef;
    private FireBaseListAdapter FireBaseAdap;
    //private FirebaseRecyclerAdapter<Team, FirebaseTeamViewHolder> FireBaseAdap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);
        teamRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TEAM);
        setUpFirebaseAdapter();//declare logic for this method outside oncreate
    }

    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String uid = user.getUid();
        Query query = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TEAM).child(uid).orderByChild(Constants.FIREBASE_QUERY_INDEX);

        //build object
        FirebaseRecyclerOptions<Team> options = new FirebaseRecyclerOptions.Builder<Team>().setQuery(teamRef, Team.class).build();
        FireBaseAdap = new FireBaseListAdapter(options, query, this, this);
       /*
        FirebaseAdapter = new FirebaseRecyclerAdapter<Team, FirebaseTeamViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseTeamViewHolder holder, int position, @NonNull Team team) {
                    holder.bindTeam(team);
            }

            @NonNull
            @Override
            public FirebaseTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item_drag,parent,false);
                return new FirebaseTeamViewHolder(view);
            }
        }; */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(FireBaseAdap);

        ItemTouchHelper.Callback callback = new ItemTouchCallback(FireBaseAdap);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recycler);

    }
    @Override
    protected void onStart() {
        super.onStart();
        FireBaseAdap.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(FireBaseAdap!= null) {
            FireBaseAdap.stopListening();
        }
    }
    //once user action is done
    @Override
    protected void onDestroy() {
        super.onDestroy();
        FireBaseAdap.stopListening();
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        //itemTouchHelper.startDrag(viewHolder);
    }
}