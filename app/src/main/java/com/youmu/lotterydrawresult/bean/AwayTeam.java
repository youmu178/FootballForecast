package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class AwayTeam implements Parcelable{

    private static final String FIELD_AWAY_TEAM_NAME = "away_team_name";
    private static final String FIELD_HOME_TEAM_ID = "home_team_id";
    private static final String FIELD_HOME_GOALS = "home_goals";
    private static final String FIELD_HOME_TEAM_NAME = "home_team_name";
    private static final String FIELD_QUEST_GOALS = "quest_goals";
    private static final String FIELD_LOCATION = "location";
    private static final String FIELD_AWAY_TEAM_ID = "away_team_id";
    private static final String FIELD_DATE = "date";


    @SerializedName(FIELD_AWAY_TEAM_NAME)
    private String mAwayTeamName;
    @SerializedName(FIELD_HOME_TEAM_ID)
    private int mHomeTeamId;
    @SerializedName(FIELD_HOME_GOALS)
    private int mHomeGoal;
    @SerializedName(FIELD_HOME_TEAM_NAME)
    private String mHomeTeamName;
    @SerializedName(FIELD_QUEST_GOALS)
    private int mQuestGoal;
    @SerializedName(FIELD_LOCATION)
    private String mLocation;
    @SerializedName(FIELD_AWAY_TEAM_ID)
    private int mAwayTeamId;
    @SerializedName(FIELD_DATE)
    private Long mDate;


    public AwayTeam(){

    }

    public void setAwayTeamName(String awayTeamName) {
        mAwayTeamName = awayTeamName;
    }

    public String getAwayTeamName() {
        return mAwayTeamName;
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

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getLocation() {
        return mLocation;
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

    public AwayTeam(Parcel in) {
        mAwayTeamName = in.readString();
        mHomeTeamId = in.readInt();
        mHomeGoal = in.readInt();
        mHomeTeamName = in.readString();
        mQuestGoal = in.readInt();
        mLocation = in.readString();
        mAwayTeamId = in.readInt();
        mDate = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AwayTeam> CREATOR = new Creator<AwayTeam>() {
        public AwayTeam createFromParcel(Parcel in) {
            return new AwayTeam(in);
        }

        public AwayTeam[] newArray(int size) {
        return new AwayTeam[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAwayTeamName);
        dest.writeInt(mHomeTeamId);
        dest.writeInt(mHomeGoal);
        dest.writeString(mHomeTeamName);
        dest.writeInt(mQuestGoal);
        dest.writeString(mLocation);
        dest.writeInt(mAwayTeamId);
        dest.writeLong(mDate);
    }


}