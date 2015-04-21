package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class SpreadOdd implements Parcelable{

    private static final String FIELD_HOME = "home";
    private static final String FIELD_AWAY = "away";
    private static final String FIELD_TIME = "time";


    @SerializedName(FIELD_HOME)
    private double mHome;
    @SerializedName(FIELD_AWAY)
    private double mAway;
    @SerializedName(FIELD_TIME)
    private Long mTime;


    public SpreadOdd(){

    }

    public void setHome(double home) {
        mHome = home;
    }

    public double getHome() {
        return mHome;
    }

    public void setAway(double away) {
        mAway = away;
    }

    public double getAway() {
        return mAway;
    }

    public void setTime(Long time) {
        mTime = time;
    }

    public Long getTime() {
        return mTime;
    }

    public SpreadOdd(Parcel in) {
        mHome = in.readDouble();
        mAway = in.readDouble();
        mTime = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SpreadOdd> CREATOR = new Creator<SpreadOdd>() {
        public SpreadOdd createFromParcel(Parcel in) {
            return new SpreadOdd(in);
        }

        public SpreadOdd[] newArray(int size) {
        return new SpreadOdd[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mHome);
        dest.writeDouble(mAway);
        dest.writeLong(mTime);
    }


}