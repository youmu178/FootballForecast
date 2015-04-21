package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class MatchesOnStadiumHomeTeam implements Parcelable{

    private static final String FIELD_HOME_TEAM_WINS = "home_team_wins";
    private static final String FIELD_AWAY_TEAM_WINS = "away_team_wins";
    private static final String FIELD_HOME_TEAM_GOALS = "home_team_goals";
    private static final String FIELD_AWAY_TEAM_GOALS = "away_team_goals";
    private static final String FIELD_HOME_DRAWS = "home_draws";


    @SerializedName(FIELD_HOME_TEAM_WINS)
    private int mHomeTeamWin;
    @SerializedName(FIELD_AWAY_TEAM_WINS)
    private int mAwayTeamWin;
    @SerializedName(FIELD_HOME_TEAM_GOALS)
    private int mHomeTeamGoal;
    @SerializedName(FIELD_AWAY_TEAM_GOALS)
    private int mAwayTeamGoal;
    @SerializedName(FIELD_HOME_DRAWS)
    private int mHomeDraw;


    public MatchesOnStadiumHomeTeam(){

    }

    public void setHomeTeamWin(int homeTeamWin) {
        mHomeTeamWin = homeTeamWin;
    }

    public int getHomeTeamWin() {
        return mHomeTeamWin;
    }

    public void setAwayTeamWin(int awayTeamWin) {
        mAwayTeamWin = awayTeamWin;
    }

    public int getAwayTeamWin() {
        return mAwayTeamWin;
    }

    public void setHomeTeamGoal(int homeTeamGoal) {
        mHomeTeamGoal = homeTeamGoal;
    }

    public int getHomeTeamGoal() {
        return mHomeTeamGoal;
    }

    public void setAwayTeamGoal(int awayTeamGoal) {
        mAwayTeamGoal = awayTeamGoal;
    }

    public int getAwayTeamGoal() {
        return mAwayTeamGoal;
    }

    public void setHomeDraw(int homeDraw) {
        mHomeDraw = homeDraw;
    }

    public int getHomeDraw() {
        return mHomeDraw;
    }

    public MatchesOnStadiumHomeTeam(Parcel in) {
        mHomeTeamWin = in.readInt();
        mAwayTeamWin = in.readInt();
        mHomeTeamGoal = in.readInt();
        mAwayTeamGoal = in.readInt();
        mHomeDraw = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MatchesOnStadiumHomeTeam> CREATOR = new Creator<MatchesOnStadiumHomeTeam>() {
        public MatchesOnStadiumHomeTeam createFromParcel(Parcel in) {
            return new MatchesOnStadiumHomeTeam(in);
        }

        public MatchesOnStadiumHomeTeam[] newArray(int size) {
        return new MatchesOnStadiumHomeTeam[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mHomeTeamWin);
        dest.writeInt(mAwayTeamWin);
        dest.writeInt(mHomeTeamGoal);
        dest.writeInt(mAwayTeamGoal);
        dest.writeInt(mHomeDraw);
    }


}