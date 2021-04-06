package com.example.firstip.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstip.Constants;
import com.example.firstip.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
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

        //FirebaseObject,DB reference,valueEventListener
        textEntry = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_ENTRY);
        textListener = textEntry.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot textSnap:snapshot.getChildren()){
                        //variable to store any change on the specified  node
                        String eConference = textSnap.getValue().toString();
                        //display the text retrieved
                        Log.d("TEXT UPDATED","CONFERENCE NAME: "+ eConference);
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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

    //Reference fb.getInstance().getRef().child("key").push().setValue(value)
    public void saveLocationToFirebase(String conference){
        textEntry.push().setValue(conference);
    }

    //destroy activity once listening is done
    @Override
    public void onDestroy() {
        super.onDestroy();
        textEntry.removeEventListener(textListener);
    }
    public void addToSharedPreferences(String conference){
       //editor.putString(Constants.PREFERENCE_TEXT,conference).apply();
    }
}