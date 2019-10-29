package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daffatahta.go2workapp.R;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {

    private Button buttonUser;
    private Button buttonCompany;
    private TextView goToLoginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register);
        buttonUser = (Button) findViewById(R.id.userRegister);
        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserRegister();
            }
        });
    }
    public void openUserRegister (){
        Intent i = new Intent(this, UserRegister.class);
        startActivity(i);
    }
}
