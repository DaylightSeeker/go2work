package com.daffatahta.go2workapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daffatahta.go2workapp.activity.CompanyRegister;
import com.daffatahta.go2workapp.activity.Login;
import com.daffatahta.go2workapp.activity.UserRegister;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
