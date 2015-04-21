package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class TotalGoalsPrediction implements Parcelable{

    private static final String FIELD_PCTG = "pctg";
    private static final String FIELD_GOALS = "goals";


    @SerializedName(FIELD_PCTG)
    private int mPctg;
    @SerializedName(FIELD_GOALS)
    private String mGoal;


    public TotalGoalsPrediction(){

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

    public TotalGoalsPrediction(Parcel in) {
        mPctg = in.readInt();
        mGoal = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TotalGoalsPrediction> CREATOR = new Creator<TotalGoalsPrediction>() {
        public TotalGoalsPrediction createFromParcel(Parcel in) {
            return new TotalGoalsPrediction(in);
        }

        public TotalGoalsPrediction[] newArray(int size) {
        return new TotalGoalsPrediction[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPctg);
        dest.writeString(mGoal);
    }


}