package com.daffatahta.go2workapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daffatahta.go2workapp.Apply;
import com.daffatahta.go2workapp.Job;
import com.daffatahta.go2workapp.R;
import com.daffatahta.go2workapp.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserHome extends AppCompatActivity {
    private RecyclerView rvView;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        dbRef = FirebaseDatabase.getInstance().getReference().child("JobList");
        dbRef.keepSynced(true);

        rvView = findViewById(R.id.rview);
        rvView.setHasFixedSize(true);
        rvView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Job,JobViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Job, JobViewHolder>
                (Job.class,R.layout.cardview,JobViewHolder.class, dbRef) {

            @Override
            protected void populateViewHolder(JobViewHolder jobViewHolder, Job job, int i) {
                jobViewHolder.setTitle(job.getNama());
                jobViewHolder.setJenis(job.getJenis());
                jobViewHolder.setLokasi(job.getLokasi());
                jobViewHolder.setGaji(job.getGaji());
                jobViewHolder.setFasilitas(job.getFasilitas());
                jobViewHolder.setWaktuKerja(job.getWaktu());
            }


        };
        rvView.setAdapter(firebaseRecyclerAdapter);
    }


    public static class JobViewHolder extends RecyclerView.ViewHolder {
        public FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        public DatabaseReference dbref = firebaseDatabase.getReference();
        public FirebaseAuth mAuth;
        public FirebaseDatabase fDatabase;
        private User u;
        private Job j;

        private int currentPage;
        View mView;

        public int getCurrentPage() {
            return currentPage;
        }

        //public void write (String userId, String nama,String namaPekerjaan, String idCompany, String emailUser, String hpUser){
        //    Apply apply = new Apply(nama,namaPekerjaan, idCompany, emailUser,hpUser);
        //    dbref.child("Applied").child(userId).push().setValue(apply);
        //}

        //public void lamar (){
        //    FirebaseUser user = null;
        //    ValueEventListener postListener = new ValueEventListener() {
        //        @Override
        //        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //            try {
        //                u = dataSnapshot.getChildren().iterator().next().getValue(User.class);
        //                j = dataSnapshot.getChildren().iterator().next().getValue(Job.class);
        //            }catch (Throwable e){

        //            }
        //        }

        //        @Override
        //        public void onCancelled(@NonNull DatabaseError databaseError) {

        //        }
        //    };
        //    write(user.getUid(),u.username,j.nama,"0",u.email,u.contact);
        //}

        public JobViewHolder(final View itemView){
            super(itemView);
            mView = itemView;

            //new
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),"Applied!",Toast.LENGTH_SHORT).show();
                    //dbref.child("Beta-test").push().setValue("Clicked");

                    try {

                        itemView.setOnClickListener((View.OnClickListener) dbref.child("Applied").child("Data").child("id_page").setValue(getCurrentPage()));
                        //itemView.setOnClickListener((View.OnClickListener) dbref.child("Applied").child("Data").setValue());
                        //itemView.setOnClickListener((View.OnClickListener) dbref.child("Beta").setValue("Clicked"));

                    }catch (Exception e){

                    }
                }
            });

        }
        public void setTitle(String title){
            TextView postTitle = mView.findViewById(R.id.titleText);
            postTitle.setText(title);
        }
        public void setJenis (String jenis){
            TextView postJenis = mView.findViewById(R.id.descjenis);
            postJenis.setText(jenis);
        }
        public void setLokasi (String lokasi){
            TextView postLokasi = mView.findViewById(R.id.lokasidesc);
            postLokasi.setText(lokasi);
        }
        public void setGaji (String gaji){
            TextView postGaji = mView.findViewById(R.id.gajidesc);
            postGaji.setText(gaji);
        }
        public void setFasilitas (String fasilitas){
            TextView postFasilitas = mView.findViewById(R.id.fasilitasdesc);
            postFasilitas.setText(fasilitas);
        }
        public void setWaktuKerja (String waktu){
            TextView postWaktu = mView.findViewById(R.id.waktudesc);
            postWaktu.setText(waktu);
        }
        public void getTtitle(int id){
            TextView postTitle = mView.findViewById(R.id.titleText);
            postTitle.getText();

        }

    }
}
