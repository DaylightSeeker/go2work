package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.daffatahta.go2workapp.R;
import com.r0adkll.slidr.Slidr;

public class UserRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        Slidr.attach(this);
    }
}
