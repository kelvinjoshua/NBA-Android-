package com.example.firstip.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.firstip.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class login extends AppCompatActivity  implements View.OnClickListener{

    @BindView(R.id.registerTextView) TextView registerHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        registerHere.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == registerHere){
            //Intent to start create account activity
            Intent intent = new Intent(this,CreateAccount.class);
            startActivity(intent);
            finish();//destroy this activity due to stack to prevent unnecessary back visits
        }
    }
}