package com.daffatahta.go2workapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.r0adkll.slidr.Slidr;

import org.w3c.dom.Text;

public class UserRegister extends AppCompatActivity {

    private TextView textViewDate;
    private Button buttonDate, buttonNextUser;
    private EditText usernameI, emailI, passwordI, provinsiI, kotaI;

    private FirebaseAuth mAuth;
    private static final String TAG= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        Slidr.attach(this);

        usernameI = (EditText) findViewById(R.id.textViewUsernameUser);
        emailI = (EditText) findViewById(R.id.textViewEmailUser);
        passwordI = (EditText) findViewById(R.id.passwordUser);
        provinsiI = (EditText) findViewById(R.id.textViewProvinsiUser);
        kotaI = (EditText) findViewById(R.id.textViewKotaUser);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        buttonNextUser = (Button) findViewById(R.id.nextButtonUser);
        //show dialog date
        buttonDate = (Button) findViewById(R.id.buttonDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mAuth = FirebaseAuth.getInstance();
        buttonNextUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameI.getText().toString();
                String email = emailI.getText().toString();
                String password = passwordI.getText().toString();
                String kota = kotaI.getText().toString();
                String provinsi = provinsiI.getText().toString();

                if (TextUtils.isEmpty(username)){
                    Toast.makeText(getApplicationContext(), "Username harus di isi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Alamat Email harus di isi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Password harus di isi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(kota)){
                    Toast.makeText(getApplicationContext(), "Kota asal harus di isi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(provinsi)){
                    Toast.makeText(getApplicationContext(), "Provinis asal harus di isi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(UserRegister.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail.Success");
                            Intent intent = new Intent(UserRegister.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Log.w(TAG, "createUserWithEmail:fail", task.getException());
                            Toast.makeText(UserRegister.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}