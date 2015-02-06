package com.sunloto.drawing.lotterydrawresult.bean;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class CurrentForm implements Parcelable{

    private static final String FIELD_HOME_TEAM = "home_team";
    private static final String FIELD_AWAY_TEAM = "away_team";


    @SerializedName(FIELD_HOME_TEAM)
    private List<HomeTeam> mHomeTeams;
    @SerializedName(FIELD_AWAY_TEAM)
    private List<AwayTeam> mAwayTeams;


    public CurrentForm(){

    }

    public void setHomeTeams(List<HomeTeam> homeTeams) {
        mHomeTeams = homeTeams;
    }

    public List<HomeTeam> getHomeTeams() {
        return mHomeTeams;
    }

    public void setAwayTeams(List<AwayTeam> awayTeams) {
        mAwayTeams = awayTeams;
    }

    public List<AwayTeam> getAwayTeams() {
        return mAwayTeams;
    }

    public CurrentForm(Parcel in) {
        mHomeTeams = new ArrayList<HomeTeam>();
        in.readTypedList(mHomeTeams, HomeTeam.CREATOR);
        mAwayTeams = new ArrayList<AwayTeam>();
        in.readTypedList(mAwayTeams, AwayTeam.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CurrentForm> CREATOR = new Creator<CurrentForm>() {
        public CurrentForm createFromParcel(Parcel in) {
            return new CurrentForm(in);
        }

        public CurrentForm[] newArray(int size) {
        return new CurrentForm[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mHomeTeams);
        dest.writeTypedList(mAwayTeams);
    }


}