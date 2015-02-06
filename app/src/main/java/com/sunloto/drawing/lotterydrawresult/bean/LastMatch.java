package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class LastMatch implements Parcelable{

    private static final String FIELD_AWAY_TEAM_NAME = "away_team_name";
    private static final String FIELD_STADIUM = "stadium";
    private static final String FIELD_HOME_TEAM_ID = "home_team_id";
    private static final String FIELD_HOME_GOALS = "home_goals";
    private static final String FIELD_HOME_TEAM_NAME = "home_team_name";
    private static final String FIELD_QUEST_GOALS = "quest_goals";
    private static final String FIELD_AWAY_TEAM_ID = "away_team_id";
    private static final String FIELD_DATE = "date";


    @SerializedName(FIELD_AWAY_TEAM_NAME)
    private String mAwayTeamName;
    @SerializedName(FIELD_STADIUM)
    private String mStadium;
    @SerializedName(FIELD_HOME_TEAM_ID)
    private int mHomeTeamId;
    @SerializedName(FIELD_HOME_GOALS)
    private int mHomeGoal;
    @SerializedName(FIELD_HOME_TEAM_NAME)
    private String mHomeTeamName;
    @SerializedName(FIELD_QUEST_GOALS)
    private int mQuestGoal;
    @SerializedName(FIELD_AWAY_TEAM_ID)
    private int mAwayTeamId;
    @SerializedName(FIELD_DATE)
    private Long mDate;


    public LastMatch(){

    }

    public void setAwayTeamName(String awayTeamName) {
        mAwayTeamName = awayTeamName;
    }

    public String getAwayTeamName() {
        return mAwayTeamName;
    }

    public void setStadium(String stadium) {
        mStadium = stadium;
    }

    public String getStadium() {
        return mStadium;
    }

    public void setHomeTeamId(int homeTeamId) {
        mHomeTeamId = homeTeamId;
    }

    public int getHomeTeamId() {
        return mHomeTeamId;
    }

    public void setHomeGoal(int homeGoal) {
        mHomeGoal = homeGoal;
    }

    public int getHomeGoal() {
        return mHomeGoal;
    }

    public void setHomeTeamName(String homeTeamName) {
        mHomeTeamName = homeTeamName;
    }

    public String getHomeTeamName() {
        return mHomeTeamName;
    }

    public void setQuestGoal(int questGoal) {
        mQuestGoal = questGoal;
    }

    public int getQuestGoal() {
        return mQuestGoal;
    }

    public void setAwayTeamId(int awayTeamId) {
        mAwayTeamId = awayTeamId;
    }

    public int getAwayTeamId() {
        return mAwayTeamId;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public Long getDate() {
        return mDate;
    }

    public LastMatch(Parcel in) {
        mAwayTeamName = in.readString();
        mStadium = in.readString();
        mHomeTeamId = in.readInt();
        mHomeGoal = in.readInt();
        mHomeTeamName = in.readString();
        mQuestGoal = in.readInt();
        mAwayTeamId = in.readInt();
        mDate = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LastMatch> CREATOR = new Creator<LastMatch>() {
        public LastMatch createFromParcel(Parcel in) {
            return new LastMatch(in);
        }

        public LastMatch[] newArray(int size) {
        return new LastMatch[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAwayTeamName);
        dest.writeString(mStadium);
        dest.writeInt(mHomeTeamId);
        dest.writeInt(mHomeGoal);
        dest.writeString(mHomeTeamName);
        dest.writeInt(mQuestGoal);
        dest.writeInt(mAwayTeamId);
        dest.writeLong(mDate);
    }


}