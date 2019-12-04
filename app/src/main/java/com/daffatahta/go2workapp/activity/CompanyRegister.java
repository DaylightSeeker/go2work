package com.daffatahta.go2workapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daffatahta.go2workapp.R;
import com.daffatahta.go2workapp.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.r0adkll.slidr.Slidr;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyRegister extends AppCompatActivity {

    private Button buttonNext;
    private EditText usernameInput, emailInput, passwordInput, companyName, kota, websiteCompany, contact;

    private FirebaseAuth mAuth;
    private DatabaseReference mData;
    private static final String TAG= "";

    private Pattern pattern1= Pattern.compile("^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register);

        Slidr.attach(this);

        mData = FirebaseDatabase.getInstance().getReference();
        usernameInput = findViewById(R.id.usernameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passInput);
        companyName = findViewById(R.id.companyNameInput);
        kota = findViewById(R.id.kotaInput);
        websiteCompany = findViewById(R.id.websiteInput);
        contact = findViewById(R.id.editTextContactPerson);

        buttonNext = (Button) findViewById(R.id.registerNextButton);
        buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nextButton();
            }
        });

        mAuth = FirebaseAuth.getInstance();


    }

    public void nextButton(){
        String username = usernameInput.getText().toString();
        final String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String name = companyName.getText().toString();
        String k = kota.getText().toString();
        String web = websiteCompany.getText().toString();
        String nomer = contact.getText().toString();
        Matcher matcher = pattern1.matcher(email);

        if (TextUtils.isEmpty(username)){
            Toast.makeText(getApplicationContext(), "Username harus di isi!", Toast.LENGTH_SHORT).show();
            usernameInput.setError("Harus di isi!");
            //usernameInput.setError(Html.fromHtml("<font color = 'red'>test</font>"));
            usernameInput.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "Email harus di isi!", Toast.LENGTH_SHORT).show();
            emailInput.setError("Harus di isi!");
            emailInput.requestFocus();
            return;
        }else if(!matcher.matches()){
            Toast.makeText(getApplicationContext(),"Format email salah!",Toast.LENGTH_SHORT).show();
            emailInput.setError("Format email salah!");
            emailInput.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Password harus di isi!", Toast.LENGTH_SHORT).show();
            passwordInput.setError("Password harus di isi!");
            passwordInput.requestFocus();
            return;
        }else if(password.length() < 5 && password.length() > 20){
            Toast.makeText(getApplicationContext(),"Panjang password tidak memenuhi kriteria!", Toast.LENGTH_SHORT).show();
            passwordInput.requestFocus();
            passwordInput.setError("Password salah!");
            return;
        }
        if (TextUtils.isEmpty(name)){
            Toast.makeText(getApplicationContext(), "Nama perusahaan harus di isi!", Toast.LENGTH_SHORT).show();
            companyName.setError("Nama perusahaan harus di isi!");
            companyName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(k)){
            Toast.makeText(getApplicationContext(),"Kota perusahaan harus di isi!", Toast.LENGTH_SHORT).show();
            kota.requestFocus();
            kota.setError("Kota harus di isi!");
            return;
        }
        if (TextUtils.isEmpty(web)){
            Toast.makeText(getApplicationContext(),"Website perusahaan harus di isi!", Toast.LENGTH_SHORT).show();
            websiteCompany.setError("Website harus di isi!");
            websiteCompany.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(nomer)){
            Toast.makeText(getApplicationContext(), "Contact Person harus di isi!", Toast.LENGTH_SHORT).show();
            contact.setError("Harus di isi!");
            contact.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(CompanyRegister.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d(TAG, "Create user companyWithEmail.success");
                    authSuccess(task.getResult().getUser());
                    Intent intent = new Intent (CompanyRegister.this, Login.class);
                    startActivity(intent);
                }
                if (!task.isSuccessful()){
                    Log.w(TAG, "Create user fail!", task.getException());
                    Toast.makeText(getApplicationContext(), "Failed!" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(CompanyRegister.this, Register.class);
                    startActivity(i);
                }else if (task.getException() instanceof FirebaseAuthUserCollisionException){
                    emailInput.setError("Email Sudah terpakai!");
                    Toast.makeText(getApplicationContext(), "Email already used! Please login.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(web) && !TextUtils.isEmpty(nomer)){
        //    Intent intent = new Intent (CompanyRegister.this, FormLowongan.class);
        //    startActivity(intent);
        //}
    }

    public void writeToDatabase (String userId,String username, String email, String password, String namaPerusahaan, String kota, String websitePerusahaan, String contactPerson,String tipe){
        User user = new User(username,email,password,namaPerusahaan,kota,websitePerusahaan,contactPerson,tipe);
        mData.child("User").child(userId).setValue(user);
    }

    public void authSuccess (FirebaseUser user){
        String usernamee = usernameInput.getText().toString();
        String emaill= emailInput.getText().toString();
        String passwordd = passwordInput.getText().toString();
        String namee = companyName.getText().toString();
        String kotaa = kota.getText().toString();
        String webb = websiteCompany.getText().toString();
        String nomerr = contact.getText().toString();
        String tipe = "company";
        writeToDatabase(user.getUid(),usernamee, emaill, passwordd, namee, kotaa, webb, nomerr, tipe);
    }
}
