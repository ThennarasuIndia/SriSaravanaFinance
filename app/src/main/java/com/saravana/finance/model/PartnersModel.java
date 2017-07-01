package com.saravana.finance.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by THENNA on 3/15/2017.
 */
public class PartnersModel implements Parcelable{

    String partnername;
    String partnerphone;
    String partneraddress;

    public PartnersModel() {
    }

    public PartnersModel(String partner_name_str, String partner_phone_str, String partner_address_str) {
        this.partnername = partner_name_str;
        this.partnerphone = partner_phone_str;
        this.partneraddress = partner_address_str;
    }

    protected PartnersModel(Parcel in) {
        partnername = in.readString();
        partnerphone = in.readString();
        partneraddress = in.readString();
    }

    public static final Creator<PartnersModel> CREATOR = new Creator<PartnersModel>() {
        @Override
        public PartnersModel createFromParcel(Parcel in) {
            return new PartnersModel(in);
        }

        @Override
        public PartnersModel[] newArray(int size) {
            return new PartnersModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(partnername);
        parcel.writeString(partnerphone);
        parcel.writeString(partneraddress);
    }

    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }

    public String getPartnerphone() {
        return partnerphone;
    }

    public void setPartnerphone(String partnerphone) {
        this.partnerphone = partnerphone;
    }

    public String getPartneraddress() {
        return partneraddress;
    }

    public void setPartneraddress(String partneraddress) {
        this.partneraddress = partneraddress;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
