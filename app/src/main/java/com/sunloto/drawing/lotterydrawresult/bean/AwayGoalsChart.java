package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class AwayGoalsChart implements Parcelable{

    private static final String FIELD_PCTG = "pctg";
    private static final String FIELD_GOALS = "goals";


    @SerializedName(FIELD_PCTG)
    private int mPctg;
    @SerializedName(FIELD_GOALS)
    private String mGoal;


    public AwayGoalsChart(){

    }

    public void setPctg(int pctg) {
        mPctg = pctg;
    }

    public int getPctg() {
        return mPctg;
    }

    public void setGoal(String goal) {
        mGoal = goal;
    }

    public String getGoal() {
        return mGoal;
    }

    public AwayGoalsChart(Parcel in) {
        mPctg = in.readInt();
        mGoal = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AwayGoalsChart> CREATOR = new Creator<AwayGoalsChart>() {
        public AwayGoalsChart createFromParcel(Parcel in) {
            return new AwayGoalsChart(in);
        }

        public AwayGoalsChart[] newArray(int size) {
        return new AwayGoalsChart[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPctg);
        dest.writeString(mGoal);
    }


}