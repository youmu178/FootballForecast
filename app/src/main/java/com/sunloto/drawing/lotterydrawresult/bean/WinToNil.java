package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class WinToNil implements Parcelable{

    private static final String FIELD_TEAM = "team";
    private static final String FIELD_PCTG = "pctg";
    private static final String FIELD_TITLE = "title";


    @SerializedName(FIELD_TEAM)
    private int mTeam;
    @SerializedName(FIELD_PCTG)
    private int mPctg;
    @SerializedName(FIELD_TITLE)
    private String mTitle;


    public WinToNil(){

    }

    public void setTeam(int team) {
        mTeam = team;
    }

    public int getTeam() {
        return mTeam;
    }

    public void setPctg(int pctg) {
        mPctg = pctg;
    }

    public int getPctg() {
        return mPctg;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public WinToNil(Parcel in) {
        mTeam = in.readInt();
        mPctg = in.readInt();
        mTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WinToNil> CREATOR = new Creator<WinToNil>() {
        public WinToNil createFromParcel(Parcel in) {
            return new WinToNil(in);
        }

        public WinToNil[] newArray(int size) {
        return new WinToNil[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTeam);
        dest.writeInt(mPctg);
        dest.writeString(mTitle);
    }


}