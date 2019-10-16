package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.daffatahta.go2workapp.MainActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //TODO set logo set header footer text
        EasySplashScreen config = new EasySplashScreen(SplashScreen.this).withFullScreen().withTargetActivity(MainActivity.class).withSplashTimeOut(5000).withBackgroundColor(Color.parseColor("#FFFFFF"));
    }
}
