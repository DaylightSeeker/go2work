package com.daffatahta.go2workapp.activity;

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

import com.daffatahta.go2workapp.MainActivity;
import com.daffatahta.go2workapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.r0adkll.slidr.Slidr;

public class Login extends AppCompatActivity {

    private TextView toRegister;
    private TextView toForgotPassword;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private static final String TAG = "Login";
    private EditText username;
    private EditText password;
    private Button login;
    @Override
    protected void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Slidr.attach(this);

        toRegister = (TextView) findViewById(R.id.textViewRegisterRedirect);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRegister();
            }
        });

        toForgotPassword = (TextView) findViewById(R.id.textViewLupaPassword);
        toForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPassword();
            }
        });

        login = findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInput();
                login();

            }
        });
    }

    public void toRegister (){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void forgotPassword(){
        //Todo: make forgot password layout and class!
    }

    public boolean validateInput(){
        boolean bool = true;
        username = findViewById(R.id.editTextUsernameLogin);
        password = findViewById(R.id.editTextPasswordLogin);

        if (username.getText().equals(0)){
            username.setError("Username harus di isi!");
            username.requestFocus();
            return false;
        }
        if (password.getText().equals(0)){
            password.setError("Password harus di isi!");
            password.requestFocus();
            return false;
        }
        return bool;
    }

    private void login(){
        Log.d(TAG, "Login");
        if (!validateInput()){
            return;
        }
        String userN = username.getText().toString();
        String passN = password.getText().toString();

        mAuth.signInWithEmailAndPassword(userN, passN).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signin" + task.isSuccessful());
                if (task.isSuccessful()){
                    Intent i  = new Intent(Login.this, MainActivity.class);
                    finish();
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(Login.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //todo : here
    //nagmbil tipe user
    private void diff (final String tipe){
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(tipe).exists()){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
