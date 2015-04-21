package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class TeamsLeaguePosition implements Parcelable{

    private static final String FIELD_TEAM = "team";
    private static final String FIELD_TABLE = "table";
    private static final String FIELD_POINTS = "points";
    private static final String FIELD_PLACE = "place";
    private static final String FIELD_GOAL_DIFFERENCE = "goal_difference";
    private static final String FIELD_GOALS_AGAINST = "goals_against";
    private static final String FIELD_GOALS_FOR = "goals_for";
    private static final String FIELD_WINS = "wins";
    private static final String FIELD_PLAYED = "played";
    private static final String FIELD_DRAWS = "draws";
    private static final String FIELD_LOST = "lost";


    @SerializedName(FIELD_TEAM)
    private int mTeam;
    @SerializedName(FIELD_TABLE)
    private String mTable;
    @SerializedName(FIELD_POINTS)
    private int mPoint;
    @SerializedName(FIELD_PLACE)
    private int mPlace;
    @SerializedName(FIELD_GOAL_DIFFERENCE)
    private int mGoalDifference;
    @SerializedName(FIELD_GOALS_AGAINST)
    private int mGoalsAgainst;
    @SerializedName(FIELD_GOALS_FOR)
    private int mGoalsFor;
    @SerializedName(FIELD_WINS)
    private int mWin;
    @SerializedName(FIELD_PLAYED)
    private int mPlayed;
    @SerializedName(FIELD_DRAWS)
    private int mDraw;
    @SerializedName(FIELD_LOST)
    private int mLost;


    public TeamsLeaguePosition(){

    }

    public void setTeam(int team) {
        mTeam = team;
    }

    public int getTeam() {
        return mTeam;
    }

    public void setTable(String table) {
        mTable = table;
    }

    public String getTable() {
        return mTable;
    }

    public void setPoint(int point) {
        mPoint = point;
    }

    public int getPoint() {
        return mPoint;
    }

    public void setPlace(int place) {
        mPlace = place;
    }

    public int getPlace() {
        return mPlace;
    }

    public void setGoalDifference(int goalDifference) {
        mGoalDifference = goalDifference;
    }

    public int getGoalDifference() {
        return mGoalDifference;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        mGoalsAgainst = goalsAgainst;
    }

    public int getGoalsAgainst() {
        return mGoalsAgainst;
    }

    public void setGoalsFor(int goalsFor) {
        mGoalsFor = goalsFor;
    }

    public int getGoalsFor() {
        return mGoalsFor;
    }

    public void setWin(int win) {
        mWin = win;
    }

    public int getWin() {
        return mWin;
    }

    public void setPlayed(int played) {
        mPlayed = played;
    }

    public int getPlayed() {
        return mPlayed;
    }

    public void setDraw(int draw) {
        mDraw = draw;
    }

    public int getDraw() {
        return mDraw;
    }

    public void setLost(int lost) {
        mLost = lost;
    }

    public int getLost() {
        return mLost;
    }

    public TeamsLeaguePosition(Parcel in) {
        mTeam = in.readInt();
        mTable = in.readString();
        mPoint = in.readInt();
        mPlace = in.readInt();
        mGoalDifference = in.readInt();
        mGoalsAgainst = in.readInt();
        mGoalsFor = in.readInt();
        mWin = in.readInt();
        mPlayed = in.readInt();
        mDraw = in.readInt();
        mLost = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TeamsLeaguePosition> CREATOR = new Creator<TeamsLeaguePosition>() {
        public TeamsLeaguePosition createFromParcel(Parcel in) {
            return new TeamsLeaguePosition(in);
        }

        public TeamsLeaguePosition[] newArray(int size) {
        return new TeamsLeaguePosition[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTeam);
        dest.writeString(mTable);
        dest.writeInt(mPoint);
        dest.writeInt(mPlace);
        dest.writeInt(mGoalDifference);
        dest.writeInt(mGoalsAgainst);
        dest.writeInt(mGoalsFor);
        dest.writeInt(mWin);
        dest.writeInt(mPlayed);
        dest.writeInt(mDraw);
        dest.writeInt(mLost);
    }


}