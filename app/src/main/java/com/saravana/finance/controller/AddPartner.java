package com.saravana.finance.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saravana.finance.R;
import com.saravana.finance.utils.Utility;
import com.saravana.finance.model.PartnersModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPartner extends AppCompatActivity {

    EditText partner_name, partner_phone, partner_address;
    String partner_name_str, partner_phone_str, partner_address_str;
    Button saveButton, cancelButton;
    private DatabaseReference mFirebaseDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_partner);
        initialization();

        onClickListners();
    }



    private void initialization() {
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        partner_name = (EditText) findViewById(R.id.partnerName);
        partner_phone = (EditText) findViewById(R.id.partnerPhone);
        partner_address = (EditText) findViewById(R.id.partnerAddress);
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
    }

    private void onClickListners() {

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                timeStamp = timeStamp.replace(".","");
                if(Utility.isValidString(partner_name.getText().toString())){
                    partner_name_str = partner_name.getText().toString();
                }else {
                    partner_name.setError(getResources().getString(R.string.partner_name_error));
                }
                if(Utility.isValidString(partner_phone.getText().toString())){
                    partner_phone_str = partner_phone.getText().toString();
                }else {
                    partner_phone.setError(getResources().getString(R.string.partner_phone_error));
                }
                if(Utility.isValidString(partner_address.getText().toString())){
                    partner_address_str = partner_address.getText().toString();
                }else {
                    partner_address.setError(getResources().getString(R.string.partner_address_error));
                }

                if(Utility.isValidString(partner_name.getText().toString()) && Utility.isValidString(partner_phone.getText().toString()) &&Utility.isValidString(partner_address.getText().toString())){
                    PartnersModel  partnersModel = new PartnersModel(partner_name_str, partner_phone_str, partner_address_str);
                    mFirebaseDatabaseReference.child("partners").child(partner_phone_str).setValue(partnersModel);
                    finish();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
