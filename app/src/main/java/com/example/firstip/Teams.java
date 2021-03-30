package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstip.adapters.Adapter;
import com.example.firstip.models.Team;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Teams extends AppCompatActivity {
    @BindView(R.id.errorTextView) TextView errorText;
    @BindView(R.id.recyclerView) RecyclerView recycler;
    @BindView(R.id.westButton) Button West;
    @BindView(R.id.editConferenceName) EditText western;

    public List<Team> eastTeams;
    public Adapter teamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        Intent intent = getIntent();
        String Retrieved = intent.getStringExtra("East");

        ButterKnife.bind(this);
        /*Custom adapter*/
        Adapter adapter = new Adapter(this, android.R.layout.simple_list_item_1,teams,Seed);
        //attach adapter to list view
            /*
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start another activity
                Intent intent = new Intent(Teams.this,last.class);
                //String conferenceName = eastern.getText().toString();
                //intent.putExtra("EasternConf",conferenceName); //key-value
                startActivity(intent);
            }
        });
       // mlist.setAdapter(adapter);
       /* mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Teams.this,"Clinched Playoff position",Toast.LENGTH_LONG).show();
            }
        });

        */
           
        Intent intent = getIntent();
        String Retrieved = intent.getStringExtra("Team");
        //we get text and set it to the display value//
        //showText.setText("Here are the Standings for " + " " + Retrieved + " "+"Western-Conference");
    }
}