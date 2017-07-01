package com.saravana.finance.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.saravana.finance.R;
import com.saravana.finance.model.PartyModel;

public class PartyDetail extends AppCompatActivity {

    private TextView partyLoanNumber;
    private TextView partyName;
    private TextView partyAddress;
    private TextView partyPhone;
    private TextView partyAmount, partyInterest, partyDues, partyDueDate;
    private PartyModel partyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_detail);
        initialization();
        onClickListeners();
        setValues();
    }

    private void setValues() {

        partyLoanNumber.setText("L.No : "+partyModel.getLoanNumber());
        partyName.setText("Name : "+partyModel.getName());
        partyAddress.setText("Address : "+partyModel.getAddress());
        partyPhone.setText("Mobile : "+partyModel.getPhoneNumber());
        partyAmount.setText("Amount : "+partyModel.getAmount());
        partyInterest.setText("Interst : "+partyModel.getInterestPercent());
        partyDues.setText("N.O.D : "+partyModel.getNumberOfDues());
        partyDueDate.setText("Due Date : "+partyModel.getDueDate());
    }

    private void initialization() {

        partyLoanNumber = (TextView) findViewById(R.id.partyLoanNumber);
        partyName = (TextView) findViewById(R.id.partyName);
        partyAddress = (TextView) findViewById(R.id.partyAddress);
        partyPhone = (TextView) findViewById(R.id.partyPhone);
        partyAmount = (TextView) findViewById(R.id.partyAmount);
        partyInterest = (TextView) findViewById(R.id.partyInterest);
        partyDues = (TextView) findViewById(R.id.partyDues);
        partyDueDate = (TextView) findViewById(R.id.partyDueDate);
        partyModel = getIntent().getParcelableExtra("MODEL");

    }

    private void onClickListeners() {

    }
}
