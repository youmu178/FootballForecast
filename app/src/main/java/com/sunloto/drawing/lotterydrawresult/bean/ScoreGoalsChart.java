package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class ScoreGoalsChart implements Parcelable{

    private static final String FIELD_PCTG = "pctg";
    private static final String FIELD_GOALS = "goals";


    @SerializedName(FIELD_PCTG)
    private int mPctg;
    @SerializedName(FIELD_GOALS)
    private String mGoal;


    public ScoreGoalsChart(){

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

    public ScoreGoalsChart(Parcel in) {
        mPctg = in.readInt();
        mGoal = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ScoreGoalsChart> CREATOR = new Creator<ScoreGoalsChart>() {
        public ScoreGoalsChart createFromParcel(Parcel in) {
            return new ScoreGoalsChart(in);
        }

        public ScoreGoalsChart[] newArray(int size) {
        return new ScoreGoalsChart[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPctg);
        dest.writeString(mGoal);
    }


}