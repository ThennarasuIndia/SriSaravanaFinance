package com.saravana.finance.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saravana.finance.Adapter.PartnerAdapter;
import com.saravana.finance.Adapter.PartyAdapter;
import com.saravana.finance.R;
import com.saravana.finance.Utils.RecyclerItemClickListener;
import com.saravana.finance.model.PartnersModel;
import com.saravana.finance.model.PartyModel;

import java.util.ArrayList;
import java.util.List;

public class PartiesList extends AppCompatActivity {

    private FloatingActionButton fab;
    private String partnersPhoneNo;
    private List<PartyModel> partiesModelList;
    private RecyclerView partiesRecyclerView;
    private String partnersName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initialization();
        getSupportActionBar().setTitle("Parties List of "+partnersName);
        readAllPartiesOfPartners();
        onClickListners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        readAllPartiesOfPartners();
    }

    private void onClickListners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartiesList.this, AddParty.class);
                intent.putExtra("PHONE", partnersPhoneNo);
                intent.putExtra("NAME", partnersName);
                startActivity(intent);
            }
        });

        partiesRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(PartiesList.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PartyModel party = partiesModelList.get(position);
                Intent intent = new Intent(PartiesList.this, PartyDetail.class);
                intent.putExtra("MODEL", party);
                startActivity(intent);
            }
        }));

    }

    private void initialization() {
        partiesModelList = new ArrayList<>();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        partiesRecyclerView = (RecyclerView) findViewById(R.id.partiesRecyclerView);
        partnersPhoneNo = getIntent().getStringExtra("PHONE");
        partnersName = getIntent().getStringExtra("NAME");
    }

    private void readAllPartiesOfPartners() {


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("parties").child(partnersPhoneNo);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                partiesModelList.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    PartyModel partnersModel = dataSnapshot1.getValue(PartyModel.class);

                    partiesModelList.add(partnersModel);

                }

                partiesRecyclerView.setLayoutManager(new LinearLayoutManager(PartiesList.this));
                partiesRecyclerView.setItemAnimator(new DefaultItemAnimator());
                PartyAdapter adapter = new PartyAdapter(PartiesList.this, partiesModelList);
                partiesRecyclerView.setAdapter(adapter);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
