package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daffatahta.go2workapp.R;

public class Login extends AppCompatActivity {
    private TextView toRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toRegister = (TextView) findViewById(R.id.textViewRegisterRedirect);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRegister();
            }
        });
    }
    public void toRegister (){
        Intent i = new Intent(this, Register.class);
    }
}
