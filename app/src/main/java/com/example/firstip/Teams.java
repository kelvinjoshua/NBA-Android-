package com.example.firstip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Teams extends AppCompatActivity {
    @BindView(R.id.intentTextView)
    private String Retrieved;
    private TextView showText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        //showText = (TextView) findViewById(R.id.intentTextView);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Retrieved = intent.getStringExtra("Team");
        //we get text and set it to the display value//
        showText.setText("Your team is : " + Retrieved);
    }
}