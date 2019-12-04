package com.daffatahta.go2workapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.daffatahta.go2workapp.CompanyHome;
import com.daffatahta.go2workapp.Job;
import com.daffatahta.go2workapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.r0adkll.slidr.Slidr;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

public class FormLowongan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText namaPekerjaan, lokasiPekerjaan, gajiPekerjaan, fasilitasPekerjaan, waktuPekerjaan;
    private Button submitButton;
    private Spinner jenisPekerjaan;

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();

    private static final String TAG="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_lowongan);

        Slidr.attach(this);

        namaPekerjaan = findViewById(R.id.editTextNamaPekerjaan);
        jenisPekerjaan = findViewById(R.id.spinnerJenisPekerjaan);
        lokasiPekerjaan = findViewById(R.id.editTextLokasi);
        gajiPekerjaan = findViewById(R.id.editTextGaji);
        fasilitasPekerjaan = findViewById(R.id.editTextFasilitas);
        waktuPekerjaan = findViewById(R.id.editTextWaktukerja);
        submitButton = findViewById(R.id.submitButtonFormLowongan);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.job_type ,R.layout.spinner);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenisPekerjaan.setAdapter(adapter1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = namaPekerjaan.getText().toString();
                //String jenis = jenisPekerjaan.getText().toString();
                String lokasi = lokasiPekerjaan.getText().toString();
                String gaji = gajiPekerjaan.getText().toString();
                String fasilitas = fasilitasPekerjaan.getText().toString();
                String waktu = waktuPekerjaan.getText().toString();

                if (!TextUtils.isEmpty(nama) && !TextUtils.isEmpty(lokasi) && !TextUtils.isEmpty(fasilitas) && !TextUtils.isEmpty(waktu) && !TextUtils.isEmpty(gaji)){
                    Add();
                    Intent i = new Intent(FormLowongan.this, CompanyHome.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                }
                else if (TextUtils.isEmpty(nama)){
                    namaPekerjaan.setError("Harus di isi!");
                    namaPekerjaan.requestFocus();
                    return;
                }else if (TextUtils.isEmpty(lokasi)){
                    lokasiPekerjaan.setError("Harus di isi!");
                    lokasiPekerjaan.requestFocus();
                    return;
                }else if (TextUtils.isEmpty(fasilitas)){
                    fasilitasPekerjaan.setError("Harus di isi!");
                    fasilitasPekerjaan.requestFocus();
                    return;
                }else if (TextUtils.isEmpty(gaji)){
                    gajiPekerjaan.setError("Harus di isi!");
                    gajiPekerjaan.requestFocus();
                    return;
                }else if (TextUtils.isEmpty(waktu)){
                    waktuPekerjaan.setError("Harus di isi!");
                    waktuPekerjaan.requestFocus();
                    return;
                }
            }
        });
    }

    private void Add(){
        mDatabaseReference = mDatabase.getReference();


        String n = namaPekerjaan.getText().toString();
        String j = jenisPekerjaan.getSelectedItem().toString();
        String l = lokasiPekerjaan.getText().toString();
        String g = gajiPekerjaan.getText().toString();
        String f = fasilitasPekerjaan.getText().toString();
        String w = waktuPekerjaan.getText().toString();

        Job jobs = new Job(n, j, l, g, f, w);

        mDatabaseReference.child("JobList").push().setValue(jobs);


        Toast.makeText(this, "Job added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
