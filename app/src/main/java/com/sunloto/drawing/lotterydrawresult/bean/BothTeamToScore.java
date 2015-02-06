package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class BothTeamToScore implements Parcelable{

    private static final String FIELD_ODDS = "odds";
    private static final String FIELD_TITLE = "title";


    @SerializedName(FIELD_ODDS)
    private int mOdd;
    @SerializedName(FIELD_TITLE)
    private String mTitle;


    public BothTeamToScore(){

    }

    public void setOdd(int odd) {
        mOdd = odd;
    }

    public int getOdd() {
        return mOdd;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public BothTeamToScore(Parcel in) {
        mOdd = in.readInt();
        mTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BothTeamToScore> CREATOR = new Creator<BothTeamToScore>() {
        public BothTeamToScore createFromParcel(Parcel in) {
            return new BothTeamToScore(in);
        }

        public BothTeamToScore[] newArray(int size) {
        return new BothTeamToScore[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mOdd);
        dest.writeString(mTitle);
    }


}