package com.saravana.finance.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by THENNA on 6/12/2017.
 */
public class PartyModel implements Parcelable {

    private String LoanNumber;
    private String Name;
    private String Amount;
    private String interestPercent;
    private String dueDate;
    private String numberOfDues;
    private String PhoneNumber;
    private String Address;



    public PartyModel() {
    }


    public PartyModel(String partiesLoanNumber_str, String partiesName_str, String partiesAmount_str, String interestPercent_str, String dueDate_str, String numberOfDues_str, String partiesPhone_str, String partiesAddress_str) {

        LoanNumber = partiesLoanNumber_str;
        Name = partiesName_str;
        Amount = partiesAmount_str;
        interestPercent = interestPercent_str;
        dueDate = dueDate_str;
        numberOfDues = numberOfDues_str;
        PhoneNumber = partiesPhone_str;
        Address = partiesAddress_str;

    }

    protected PartyModel(Parcel in) {
        LoanNumber = in.readString();
        Name = in.readString();
        Amount = in.readString();
        interestPercent = in.readString();
        dueDate = in.readString();
        numberOfDues = in.readString();
        PhoneNumber = in.readString();
        Address = in.readString();
    }

    public static final Creator<PartyModel> CREATOR = new Creator<PartyModel>() {
        @Override
        public PartyModel createFromParcel(Parcel in) {
            return new PartyModel(in);
        }

        @Override
        public PartyModel[] newArray(int size) {
            return new PartyModel[size];
        }
    };

    public String getLoanNumber() {
        return LoanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        LoanNumber = loanNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(String interestPercent) {
        this.interestPercent = interestPercent;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getNumberOfDues() {
        return numberOfDues;
    }

    public void setNumberOfDues(String numberOfDues) {
        this.numberOfDues = numberOfDues;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(LoanNumber);
        parcel.writeString(Name);
        parcel.writeString(Amount);
        parcel.writeString(interestPercent);
        parcel.writeString(dueDate);
        parcel.writeString(numberOfDues);
        parcel.writeString(PhoneNumber);
        parcel.writeString(Address);
    }
}
