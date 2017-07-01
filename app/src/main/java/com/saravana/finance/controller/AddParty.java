package com.saravana.finance.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saravana.finance.R;
import com.saravana.finance.Utils.Utility;
import com.saravana.finance.model.PartnersModel;
import com.saravana.finance.model.PartyModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddParty extends AppCompatActivity {

    private Button saveButton;
    private Button cancelButton;
    EditText partiesLoanNumber, partiesName, partiesAmount, interestPercent, dueDate, numberOfDues, partiesPhone, partiesAddress;
    private String partiesAddress_str;
    private String partiesLoanNumber_str;
    private String partiesName_str;
    private String partiesAmount_str;
    private String interestPercent_str;
    private String dueDate_str;
    private String numberOfDues_str;
    private String partiesPhone_str;
    private boolean isValidParty;
    private String partnersPhoneNo, partnersName;
    private DatabaseReference mFirebaseDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_party);
        initialization();
        onClickListners();
    }

    private void onClickListners() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidPerson()){

                    PartyModel partyModel = new PartyModel(partiesLoanNumber_str, partiesName_str, partiesAmount_str, interestPercent_str, dueDate_str, numberOfDues_str, partiesPhone_str, partiesAddress_str);
                    mFirebaseDatabaseReference.child("parties").child(partnersPhoneNo).child(partiesPhone_str).setValue(partyModel);
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

    private boolean isValidPerson() {
        if(Utility.isValidString(partiesLoanNumber.getText().toString())){
            isValidParty = true;
            partiesLoanNumber_str = partiesLoanNumber.getText().toString();
        }else {
            isValidParty = false;
            partiesLoanNumber.setError(getResources().getString(R.string.partiesLoanNumber_error));
        }
        if(Utility.isValidString(partiesName.getText().toString())){
            isValidParty = true;
            partiesName_str = partiesName.getText().toString();
        }else {
            isValidParty = false;
            partiesName.setError(getResources().getString(R.string.partiesName_error));
        }
        if(Utility.isValidString(partiesAmount.getText().toString())){
            isValidParty = true;
            partiesAmount_str = partiesAmount.getText().toString();
        }else {
            isValidParty = false;
            partiesAmount.setError(getResources().getString(R.string.partiesAmount_error));
        }

        if(Utility.isValidString(interestPercent.getText().toString())){
            isValidParty = true;
            interestPercent_str = interestPercent.getText().toString();
        }else {
            isValidParty = false;
            interestPercent.setError(getResources().getString(R.string.interestPercent_error));
        }
        if(Utility.isValidString(dueDate.getText().toString())){
            isValidParty = true;
            dueDate_str = dueDate.getText().toString();
        }else {
            isValidParty = false;
            dueDate.setError(getResources().getString(R.string.dueDate_error));
        }
        if(Utility.isValidString(numberOfDues.getText().toString())){
            isValidParty = true;
            numberOfDues_str = numberOfDues.getText().toString();
        }else {
            isValidParty = false;
            numberOfDues.setError(getResources().getString(R.string.numberOfDues_error));
        }
        if(Utility.isValidString(partiesPhone.getText().toString())){
            isValidParty = true;
            partiesPhone_str = partiesPhone.getText().toString();
        }else {
            isValidParty = false;
            partiesPhone.setError(getResources().getString(R.string.partiesPhone_error));
        }
        if(Utility.isValidString(partiesAddress.getText().toString())){
            isValidParty = true;
            partiesAddress_str = partiesAddress.getText().toString();
        }else {
            isValidParty = false;
            partiesAddress.setError(getResources().getString(R.string.partiesAddress_error));
        }

        return isValidParty;
    }

    private void initialization() {
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        partnersPhoneNo = getIntent().getStringExtra("PHONE");
        partnersName = getIntent().getStringExtra("NAME");
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        partiesLoanNumber = (EditText) findViewById(R.id.partiesLoanNumber);
        partiesLoanNumber.setEnabled(false);


        String text = partnersName;
        char first_char = text.charAt(0);
        char third_char = text.charAt(2);

        String fc = Character.toString(first_char);
        String tc = Character.toString(third_char).toUpperCase();
        String partnerCode = fc + tc;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDateandTime = sdf.format(new Date());
        partiesLoanNumber.setText("SSF-"+partnerCode+"-"+currentDateandTime);
        partiesName = (EditText) findViewById(R.id.partiesName);
        partiesAmount = (EditText) findViewById(R.id.patiesAmount);
        interestPercent = (EditText) findViewById(R.id.interestPercent);
        dueDate = (EditText) findViewById(R.id.dueDate);
        numberOfDues = (EditText) findViewById(R.id.numberOfDues);
        partiesPhone = (EditText) findViewById(R.id.partiesPhone);
        partiesAddress = (EditText) findViewById(R.id.partiesAddress);

    }
}
