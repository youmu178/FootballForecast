package com.sunloto.drawing.lotterydrawresult.bean;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class HistoricalRecordsDatum implements Parcelable{

    private static final String FIELD_SEASONS = "seasons";
    private static final String FIELD_MATCHES_ON_STADIUM_HOME_TEAM = "matches_on_stadium_home_team";
    private static final String FIELD_ALL_MATCHES = "all_matches";


    @SerializedName(FIELD_SEASONS)
    private String mSeason;
    @SerializedName(FIELD_MATCHES_ON_STADIUM_HOME_TEAM)
    private List<MatchesOnStadiumHomeTeam> mMatchesOnStadiumHomeTeams;
    @SerializedName(FIELD_ALL_MATCHES)
    private List<AllMatch> mAllMatches;


    public HistoricalRecordsDatum(){

    }

    public void setSeason(String season) {
        mSeason = season;
    }

    public String getSeason() {
        return mSeason;
    }

    public void setMatchesOnStadiumHomeTeams(List<MatchesOnStadiumHomeTeam> matchesOnStadiumHomeTeams) {
        mMatchesOnStadiumHomeTeams = matchesOnStadiumHomeTeams;
    }

    public List<MatchesOnStadiumHomeTeam> getMatchesOnStadiumHomeTeams() {
        return mMatchesOnStadiumHomeTeams;
    }

    public void setAllMatches(List<AllMatch> allMatches) {
        mAllMatches = allMatches;
    }

    public List<AllMatch> getAllMatches() {
        return mAllMatches;
    }

    public HistoricalRecordsDatum(Parcel in) {
        mSeason = in.readString();
        mMatchesOnStadiumHomeTeams = new ArrayList<MatchesOnStadiumHomeTeam>();
        in.readTypedList(mMatchesOnStadiumHomeTeams, MatchesOnStadiumHomeTeam.CREATOR);
        mAllMatches = new ArrayList<AllMatch>();
        in.readTypedList(mAllMatches, AllMatch.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HistoricalRecordsDatum> CREATOR = new Creator<HistoricalRecordsDatum>() {
        public HistoricalRecordsDatum createFromParcel(Parcel in) {
            return new HistoricalRecordsDatum(in);
        }

        public HistoricalRecordsDatum[] newArray(int size) {
        return new HistoricalRecordsDatum[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSeason);
        dest.writeTypedList(mMatchesOnStadiumHomeTeams);
        dest.writeTypedList(mAllMatches);
    }


}