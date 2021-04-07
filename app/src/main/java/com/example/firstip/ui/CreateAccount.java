package com.example.firstip.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstip.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView) TextView mLoginTextView;
    private FirebaseAuth Auth;
    //listener to ensure user is saved
    public FirebaseAuth.AuthStateListener AuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        //authentication object
        Auth = FirebaseAuth.getInstance();
        //authentication object listener
        createAuthListener();

        mLoginTextView.setOnClickListener(this);
        mCreateUserButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //flags here will be stack signals preventing going back to last activity referenced
        if (v== mLoginTextView) {
            Intent intent = new Intent(CreateAccount.this, login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if (v == mCreateUserButton) {
            createNewUser();
        }
    }
    private void createNewUser(){
        //get data from our attributes
        final String name = mNameEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        //create user with email and password
        Auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this,task -> {
            if (task.isSuccessful()) {
                Toast.makeText(CreateAccount.this, "Successful!.",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CreateAccount.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createAuthListener() {
        AuthListener = firebaseAuth ->  {

                final FirebaseUser user = firebaseAuth.getCurrentUser();
                //start main activity on login if user exists in our database
                if (user != null) {
                    Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }


        };
    }
    //we need to actually attach our auth object to our listener,to make our main activity foregrounded/visible to us
    @Override
    public void onStart() {
        super.onStart();
        Auth.addAuthStateListener(AuthListener);
    }

    //kill activity
    @Override
    public void onStop() {
        super.onStop();
        if (AuthListener != null) {
            Auth.removeAuthStateListener(AuthListener);
        }
    }
}