package com.example.firstip.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstip.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class login extends AppCompatActivity  implements View.OnClickListener {

    @BindView(R.id.registerTextView)
    TextView registerHere;
    @BindView(R.id.passwordLoginButton)
    Button loginButton;
    @BindView(R.id.emailEditText)
    EditText emailText;
    @BindView(R.id.passwordEditText)
    EditText password;
    private FirebaseAuth Auth;
    public FirebaseAuth.AuthStateListener AuthListener;
    private static final String TAG = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        registerHere.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        //createAuthListener();
        Auth = FirebaseAuth.getInstance();

        AuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(login.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }


    @Override
    public void onClick(View v) {
        if (v == registerHere) {
            //Intent to start create account activity
            Intent intent = new Intent(login.this, CreateAccount.class);
            startActivity(intent);
            finish();//destroy this activity due to stack to prevent unnecessary back visits
        }

        if (v == loginButton) {
            //login with credentials
            loginWithPass();
        }
    }

    private void loginWithPass() {
        String email = emailText.getText().toString().trim();
        String userPass = password.getText().toString().trim();
        //assert not blank fields
        if (email.equals("")) {
            emailText.setError("Please enter your email");
            return;
        }
        if (userPass.equals("")) {
            password.setError("Password cannot be blank");
            return;
        }
        //similar to creating user we need to use Auth object to sign in
        Auth.signInWithEmailAndPassword(email, userPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                        Toast.makeText(login.this, "Authentication complete.", Toast.LENGTH_SHORT).show();
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //attach listener on Auth object
    @Override
    public void onStart() {
        super.onStart();
        Auth.addAuthStateListener(AuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (AuthListener != null) {
            Auth.removeAuthStateListener(AuthListener);
        }
    }
}
