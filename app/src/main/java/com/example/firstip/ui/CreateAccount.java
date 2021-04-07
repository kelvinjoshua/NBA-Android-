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

    //Data validation
    private boolean isValidEmail(String email) {
        boolean isGoodEmail =
                (email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mEmailEditText.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    private boolean isValidName(String name) {
        if (name.equals("")) {
            mNameEditText.setError("Please enter your name");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.length() < 6) {
            mPasswordEditText.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)) {
            mPasswordEditText.setError("Passwords do not match");
            return false;
        }
        return true;
    }

    //Saving user data into Firebase
    private void createNewUser(){
        //get data from our attributes
        final String name = mNameEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        //validation before Account creation
        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);
        if (!validEmail || !validName || !validPassword) return;

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