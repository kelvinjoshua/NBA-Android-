package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Teams extends AppCompatActivity {
    private String Retrieved;
    private TextView showText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        showText = (TextView) findViewById(R.id.intentTextView);
        Intent intent = getIntent();
        Retrieved = intent.getStringExtra("Team");
        //we get text and set it to the display value//
        showText.setText("Your team is : " + Retrieved);
    }
}