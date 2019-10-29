package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daffatahta.go2workapp.R;
import com.r0adkll.slidr.Slidr;

public class UserRegister extends AppCompatActivity {

    private TextView textViewDate;
    private Button buttonDate;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText provinsi;
    private EditText kota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        Slidr.attach(this);

        textViewDate = (TextView) findViewById(R.id.textViewDate);
        buttonDate = (Button) findViewById(R.id.buttonDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
