package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class BothTeamsToScore implements Parcelable{

    private static final String FIELD_PCTG = "pctg";
    private static final String FIELD_TITLE = "title";


    @SerializedName(FIELD_PCTG)
    private int mPctg;
    @SerializedName(FIELD_TITLE)
    private String mTitle;


    public BothTeamsToScore(){

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

    public BothTeamsToScore(Parcel in) {
        mPctg = in.readInt();
        mTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BothTeamsToScore> CREATOR = new Creator<BothTeamsToScore>() {
        public BothTeamsToScore createFromParcel(Parcel in) {
            return new BothTeamsToScore(in);
        }

        public BothTeamsToScore[] newArray(int size) {
        return new BothTeamsToScore[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPctg);
        dest.writeString(mTitle);
    }


}