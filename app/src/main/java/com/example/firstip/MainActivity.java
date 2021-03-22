package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTeamBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTeamBut = (Button) findViewById(R.id.findTeamButton);
        mTeamBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //test whether a toast will appear on submit
                Toast.makeText(MainActivity.this, "Retrieving team detail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}