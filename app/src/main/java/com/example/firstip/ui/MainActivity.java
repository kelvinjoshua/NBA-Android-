package com.example.firstip.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstip.Constants;
import com.example.firstip.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findTeamButton) Button mTeamBut;
    @BindView(R.id.editTextTextPersonName) EditText mTeamEdit;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private DatabaseReference textEntry;//key
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FirebaseObject and DB reference
        textEntry = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_ENTRY);
        ButterKnife.bind(this);
        mTeamBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //test whether a toast will appear on submit
                Intent intent = new Intent(MainActivity.this, Teams.class);
                String eConference = mTeamEdit.getText().toString();
               // Log.d(TAG,teamName);
                intent.putExtra("East", eConference);
                startActivity(intent);

                //Toast.makeText(MainActivity.this, "Retrieving team detail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}