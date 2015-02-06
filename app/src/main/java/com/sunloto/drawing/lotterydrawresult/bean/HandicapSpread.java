package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class HandicapSpread implements Parcelable{

    private static final String FIELD_VALUE = "value";
    private static final String FIELD_TEAM = "team";
    private static final String FIELD_ODDS = "odds";


    @SerializedName(FIELD_VALUE)
    private String mValue;
    @SerializedName(FIELD_TEAM)
    private String mTeam;
    @SerializedName(FIELD_ODDS)
    private int mOdd;


    public HandicapSpread(){

    }

    public void setValue(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    public void setTeam(String team) {
        mTeam = team;
    }

    public String getTeam() {
        return mTeam;
    }

    public void setOdd(int odd) {
        mOdd = odd;
    }

    public int getOdd() {
        return mOdd;
    }

    public HandicapSpread(Parcel in) {
        mValue = in.readString();
        mTeam = in.readString();
        mOdd = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HandicapSpread> CREATOR = new Creator<HandicapSpread>() {
        public HandicapSpread createFromParcel(Parcel in) {
            return new HandicapSpread(in);
        }

        public HandicapSpread[] newArray(int size) {
        return new HandicapSpread[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mValue);
        dest.writeString(mTeam);
        dest.writeInt(mOdd);
    }


}