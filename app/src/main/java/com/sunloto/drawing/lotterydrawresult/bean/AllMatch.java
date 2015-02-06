package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class AllMatch implements Parcelable{

    private static final String FIELD_TOTAL_HOME_WINS = "total_home_wins";
    private static final String FIELD_TOTAL_AWAY_WINS = "total_away_wins";
    private static final String FIELD_TOTAL_DRAWS = "total_draws";
    private static final String FIELD_TOTAL_AWAY_GOALS = "total_away_goals";
    private static final String FIELD_TOTAL_HOME_GOALS = "total_home_goals";


    @SerializedName(FIELD_TOTAL_HOME_WINS)
    private int mTotalHomeWin;
    @SerializedName(FIELD_TOTAL_AWAY_WINS)
    private int mTotalAwayWin;
    @SerializedName(FIELD_TOTAL_DRAWS)
    private int mTotalDraw;
    @SerializedName(FIELD_TOTAL_AWAY_GOALS)
    private int mTotalAwayGoal;
    @SerializedName(FIELD_TOTAL_HOME_GOALS)
    private int mTotalHomeGoal;


    public AllMatch(){

    }

    public void setTotalHomeWin(int totalHomeWin) {
        mTotalHomeWin = totalHomeWin;
    }

    public int getTotalHomeWin() {
        return mTotalHomeWin;
    }

    public void setTotalAwayWin(int totalAwayWin) {
        mTotalAwayWin = totalAwayWin;
    }

    public int getTotalAwayWin() {
        return mTotalAwayWin;
    }

    public void setTotalDraw(int totalDraw) {
        mTotalDraw = totalDraw;
    }

    public int getTotalDraw() {
        return mTotalDraw;
    }

    public void setTotalAwayGoal(int totalAwayGoal) {
        mTotalAwayGoal = totalAwayGoal;
    }

    public int getTotalAwayGoal() {
        return mTotalAwayGoal;
    }

    public void setTotalHomeGoal(int totalHomeGoal) {
        mTotalHomeGoal = totalHomeGoal;
    }

    public int getTotalHomeGoal() {
        return mTotalHomeGoal;
    }

    public AllMatch(Parcel in) {
        mTotalHomeWin = in.readInt();
        mTotalAwayWin = in.readInt();
        mTotalDraw = in.readInt();
        mTotalAwayGoal = in.readInt();
        mTotalHomeGoal = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AllMatch> CREATOR = new Creator<AllMatch>() {
        public AllMatch createFromParcel(Parcel in) {
            return new AllMatch(in);
        }

        public AllMatch[] newArray(int size) {
        return new AllMatch[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTotalHomeWin);
        dest.writeInt(mTotalAwayWin);
        dest.writeInt(mTotalDraw);
        dest.writeInt(mTotalAwayGoal);
        dest.writeInt(mTotalHomeGoal);
    }


}