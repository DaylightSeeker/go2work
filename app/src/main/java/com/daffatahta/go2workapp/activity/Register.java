package com.daffatahta.go2workapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.daffatahta.go2workapp.R;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {

    private Button buttonUser;
    private Button buttonCompany;
    private TextView goToLoginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonUser = (Button) findViewById(R.id.userRegister);
        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserRegister();
            }
        });

        goToLoginText = (TextView) findViewById(R.id.redirectToLogin);
        goToLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });
        buttonCompany = (Button) findViewById(R.id.companyRegister);
        buttonCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCompanyRegister();
            }
        });
    }
    public void openUserRegister (){
        Intent i = new Intent(this, UserRegister.class);
        startActivity(i);
    }
    public void openLoginActivity (){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
    public void openCompanyRegister (){
        Intent i = new Intent(this, CompanyRegister.class);
        startActivity(i);
    }



}
