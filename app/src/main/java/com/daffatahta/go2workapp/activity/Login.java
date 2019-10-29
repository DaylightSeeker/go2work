package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daffatahta.go2workapp.MainActivity;
import com.daffatahta.go2workapp.R;
import com.r0adkll.slidr.Slidr;

public class Login extends AppCompatActivity {
    private TextView toRegister;
    private TextView toForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
    }
    public void toRegister (){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void forgotPassword(){
        //Todo: make forgot password layout and class!
        //Intent i = new Intent((this, ))
    }
}
