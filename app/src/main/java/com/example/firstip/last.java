package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstip.adapters.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class last extends AppCompatActivity {
    //Eastern conference  ,intentTextView,listView
    @BindView(R.id.intentTextView) TextView lastView;
    @BindView(R.id.listView) ListView lastListView;

    private  String[] teams = new String []{"76ers","bucks","Nets","Hornets","Knicks","Hawks",
            "Heat","Celtics","Pacers","Cavaliers"};
    private String [] Seed = new String[]{"32-13","29-14","30-15","22-21","23-22","22-22","22-23","21-23","19-24","17-27"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        ButterKnife.bind(this);

        Adapter east = new Adapter(this,android.R.layout.simple_list_item_1,teams,Seed);
        lastListView.setAdapter(east);
        lastListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(last.this,"Clinched Playoff position",Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        //String Retrieved = intent.getStringExtra("EasternConf");
        //showText.setText("Here are the Standings for " + " " + Retrieved + " "+"Western-Conference");
    }
}