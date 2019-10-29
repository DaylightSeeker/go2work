package com.daffatahta.go2workapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daffatahta.go2workapp.MainActivity;
import com.daffatahta.go2workapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.r0adkll.slidr.Slidr;

import org.w3c.dom.Text;

import java.util.Calendar;

public class UserRegister extends AppCompatActivity {

    private TextView textViewDate;
    private Button buttonDate, buttonNextUser;
    private EditText usernameI, emailI, passwordI, provinsiI, kotaI;

    private FirebaseAuth mAuth;
    private static final String TAG= "";
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        Slidr.attach(this);

        usernameI = (EditText) findViewById(R.id.textViewUsernameUser);
        emailI = (EditText) findViewById(R.id.textViewEmailUser);
        passwordI = (EditText) findViewById(R.id.passwordUser);
        provinsiI = (EditText) findViewById(R.id.textViewProvinsiUser);
        kotaI = (EditText) findViewById(R.id.textViewKotaUser);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        buttonNextUser = (Button) findViewById(R.id.nextButtonUser);
        //show dialog date
        //buttonDate = (Button) findViewById(R.id.buttonDate);
        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog d = new DatePickerDialog(UserRegister.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,year,month,day);
                d.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                d.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                textViewDate.setText(date);
            }
        };
        //buttonDate.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {

           // }
        //});
        mAuth = FirebaseAuth.getInstance();
        buttonNextUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRegister();
            }
        });
    }

    public void UserRegister(){
        String username = usernameI.getText().toString();
        String email = emailI.getText().toString();
        String password = passwordI.getText().toString();
        String kota = kotaI.getText().toString();
        String provinsi = provinsiI.getText().toString();

        if (TextUtils.isEmpty(username)){
            Toast.makeText(getApplicationContext(), "Username harus di isi!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "Alamat Email harus di isi!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(), "Password harus di isi!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(kota)){
            Toast.makeText(getApplicationContext(), "Kota asal harus di isi!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(provinsi)){
            Toast.makeText(getApplicationContext(), "Provinis asal harus di isi!", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(UserRegister.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d(TAG, "createUserWithEmail.Success");
                    Intent intent = new Intent(UserRegister.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Log.w(TAG, "createUserWithEmail:fail", task.getException());
                    Toast.makeText(UserRegister.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}