package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class ToWinToNil implements Parcelable{

    private static final String FIELD_TEAM = "team";
    private static final String FIELD_ODDS = "odds";
    private static final String FIELD_TITLE = "title";


    @SerializedName(FIELD_TEAM)
    private String mTeam;
    @SerializedName(FIELD_ODDS)
    private double mOdd;
    @SerializedName(FIELD_TITLE)
    private String mTitle;


    public ToWinToNil(){

    }

    public void setTeam(String team) {
        mTeam = team;
    }

    public String getTeam() {
        return mTeam;
    }

    public void setOdd(double odd) {
        mOdd = odd;
    }

    public double getOdd() {
        return mOdd;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public ToWinToNil(Parcel in) {
        mTeam = in.readString();
        mOdd = in.readDouble();
        mTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ToWinToNil> CREATOR = new Creator<ToWinToNil>() {
        public ToWinToNil createFromParcel(Parcel in) {
            return new ToWinToNil(in);
        }

        public ToWinToNil[] newArray(int size) {
        return new ToWinToNil[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTeam);
        dest.writeDouble(mOdd);
        dest.writeString(mTitle);
    }


}