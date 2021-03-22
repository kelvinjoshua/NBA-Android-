package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Teams extends AppCompatActivity {
    private String Retrieved;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        Intent intent = getIntent();
        Retrieved = intent.getStringExtra("Team");
    }
}