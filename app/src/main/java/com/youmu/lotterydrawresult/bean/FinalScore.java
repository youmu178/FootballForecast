package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class FinalScore implements Parcelable{

    private static final String FIELD_HOME = "home";
    private static final String FIELD_AWAY = "away";


    @SerializedName(FIELD_HOME)
    private int mHome;
    @SerializedName(FIELD_AWAY)
    private int mAway;


    public FinalScore(){

    }

    public void setHome(int home) {
        mHome = home;
    }

    public int getHome() {
        return mHome;
    }

    public void setAway(int away) {
        mAway = away;
    }

    public int getAway() {
        return mAway;
    }

    public FinalScore(Parcel in) {
        mHome = in.readInt();
        mAway = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FinalScore> CREATOR = new Creator<FinalScore>() {
        public FinalScore createFromParcel(Parcel in) {
            return new FinalScore(in);
        }

        public FinalScore[] newArray(int size) {
        return new FinalScore[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mHome);
        dest.writeInt(mAway);
    }


}