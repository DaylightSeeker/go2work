package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.daffatahta.go2workapp.MainActivity;
import com.daffatahta.go2workapp.R;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                //.withFullScreen().withTargetActivity(Register.class)
                .withFullScreen().withTargetActivity(UserHome.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(Color.parseColor("#000000"))
                .withFooterText("Copyright DaylightSeeker 2019")
                .withLogo(R.mipmap.logo_splash);
        config.getFooterTextView().setTextColor(Color.WHITE);
        View ess = config.create();
        setContentView(ess);
    }
}
