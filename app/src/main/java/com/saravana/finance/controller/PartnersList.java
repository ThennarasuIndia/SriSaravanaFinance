package com.saravana.finance.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saravana.finance.adapter.PartnerAdapter;
import com.saravana.finance.R;
import com.saravana.finance.utils.RecyclerItemClickListener;
import com.saravana.finance.model.PartnersModel;

import java.util.ArrayList;
import java.util.List;

public class PartnersList extends AppCompatActivity {

    RecyclerView partnersRecyclerView;
    FloatingActionButton fab;
    private List<PartnersModel> partnersModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners_list);
        initialization();
        readAllPartners();
        onClickListners();
    }

    private void onClickListners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PartnersList.this, AddPartner.class);
                startActivity(intent);
            }
        });


    }

    private void readAllPartners() {


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("partners");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                partnersModelList.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    PartnersModel partnersModel = dataSnapshot1.getValue(PartnersModel.class);

                    partnersModelList.add(partnersModel);

                }

                partnersRecyclerView.setLayoutManager(new LinearLayoutManager(PartnersList.this));
                partnersRecyclerView.setItemAnimator(new DefaultItemAnimator());
                PartnerAdapter adapter = new PartnerAdapter(PartnersList.this, partnersModelList);
                partnersRecyclerView.setAdapter(adapter);

                partnersRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(PartnersList.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                PartnersModel partner = partnersModelList.get(position);
                        String parner_Phone = partner.getPartnerphone();
                        Intent intent = new Intent(PartnersList.this, PartiesList.class);
                        intent.putExtra("PHONE", parner_Phone);
                        intent.putExtra("NAME", partner.getPartnername());
                        startActivity(intent);
                    }
                }));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initialization() {
        partnersRecyclerView = (RecyclerView) findViewById(R.id.partnersRecyclerView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        partnersModelList = new ArrayList<>();
    }

}
