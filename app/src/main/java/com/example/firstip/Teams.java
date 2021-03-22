package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Teams extends AppCompatActivity {
    //EASTERN CONFERENCE
    @BindView(R.id.intentTextView) TextView showText;
    @BindView(R.id.listView) ListView mlist;

    private  String[] mteams = new String []{"Lakers","Spurs","Rockets","Golden State","Phoenix-suns","Utah-Jazz",
    "Clippers","Nuggets","Portland-Blazers","Spurs","Mavericks"};
    private String [] mSeed = new String[]{"28-15","22-17","11-30","22-21","28-13","30-11","27-16","25-17","22-17","22-19"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        //showText = (TextView) findViewById(R.id.intentTextView);
        ButterKnife.bind(this);

        /*Custom adapter*/
        Adapter adapter = new Adapter(this, android.R.layout.simple_list_item_1,mteams,mSeed);
        //attach adapter to list view
        mlist.setAdapter(adapter);

        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Teams.this,"Clinched Playoff position",Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String Retrieved = intent.getStringExtra("Team");
        //we get text and set it to the display value//
        showText.setText("Here are the Standings for " + " " +Retrieved + " "+"Western-Conference");
    }
}