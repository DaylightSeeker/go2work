package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daffatahta.go2workapp.R;

public class Login extends AppCompatActivity {
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void redirectToRegister(View view) {
        Intent toRegister = new Intent(this, Register.class);
        startActivity(toRegister);
        finish();
    }
}
