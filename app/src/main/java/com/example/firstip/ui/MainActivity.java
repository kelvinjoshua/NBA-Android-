package com.example.firstip.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstip.Constants;
import com.example.firstip.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findTeamButton) Button mTeamBut;
    @BindView(R.id.editTextTextPersonName) EditText mTeamEdit;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ValueEventListener textListener;
    private DatabaseReference textEntry;//key
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FirebaseObject and DB reference
        textEntry = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_ENTRY);

        //preferences
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor= sharedPreferences.edit();

        ButterKnife.bind(this);
        //mTeamBut.setOnClickListener(this);//setClick listener here
        mTeamBut.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mTeamBut) {
            //test whether a toast will appear on submit
            Intent intent = new Intent(MainActivity.this, Teams.class);
            String eConference = mTeamEdit.getText().toString();

            //FIIRE BASE
            saveLocationToFirebase(eConference);

            //SHARED PREFERENCE
            if(!(eConference).equals("")) {
              // addToSharedPreferences(eConference);
          }
            // Log.d(TAG,teamName);
            intent.putExtra("East", eConference);
            startActivity(intent);
            //Toast.makeText(MainActivity.this, "Retrieving team detail", Toast.LENGTH_SHORT).show();
        }
    }
    //reference fb.getInstance().getRef().child("key").push().setValue(value)
    public void saveLocationToFirebase(String conference){
        textEntry.push().setValue(conference);
    }
    public void addToSharedPreferences(String conference){
       //editor.putString(Constants.PREFERENCE_TEXT,conference).apply();
    }
}