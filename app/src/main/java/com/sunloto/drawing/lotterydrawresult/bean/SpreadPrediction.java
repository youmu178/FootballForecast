package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class SpreadPrediction implements Parcelable{

    private static final String FIELD_TEAM = "team";
    private static final String FIELD_HANDICAP = "handicap";
    private static final String FIELD_PROBABILITY = "probability";


    @SerializedName(FIELD_TEAM)
    private int mTeam;
    @SerializedName(FIELD_HANDICAP)
    private String mHandicap;
    @SerializedName(FIELD_PROBABILITY)
    private int mProbability;


    public SpreadPrediction(){

    }

    public void setTeam(int team) {
        mTeam = team;
    }

    public int getTeam() {
        return mTeam;
    }

    public void setHandicap(String handicap) {
        mHandicap = handicap;
    }

    public String getHandicap() {
        return mHandicap;
    }

    public void setProbability(int probability) {
        mProbability = probability;
    }

    public int getProbability() {
        return mProbability;
    }

    public SpreadPrediction(Parcel in) {
        mTeam = in.readInt();
        mHandicap = in.readString();
        mProbability = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SpreadPrediction> CREATOR = new Creator<SpreadPrediction>() {
        public SpreadPrediction createFromParcel(Parcel in) {
            return new SpreadPrediction(in);
        }

        public SpreadPrediction[] newArray(int size) {
        return new SpreadPrediction[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTeam);
        dest.writeString(mHandicap);
        dest.writeInt(mProbability);
    }


}