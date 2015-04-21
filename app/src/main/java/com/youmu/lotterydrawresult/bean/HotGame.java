package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class HotGame implements Parcelable{

    private static final String FIELD_HOME_TEAM_ID = "home_team_id";
    private static final String FIELD_HOME_GOALS = "home_goals";
    private static final String FIELD_RESULTS = "results";
    private static final String FIELD_AWAY_GOALS = "away_goals";
    private static final String FIELD_LOCATION = "location";
    private static final String FIELD_DRAW = "draw";
    private static final String FIELD_LEAGUE_ID = "league_id";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_AWAY_TEAM_NAME = "away_team_name";
    private static final String FIELD_HOME_WIN = "home_win";
    private static final String FIELD_ID = "id";
    private static final String FIELD_AWAY_WIN = "away_win";
    private static final String FIELD_LEAGUE_NAME = "league_name";
    private static final String FIELD_HOME_TEAM_NAME = "home_team_name";
    private static final String FIELD_HOT_GAME = "hotGame";
    private static final String FIELD_JC_GAME = "jcGame";
    private static final String FIELD_AWAY_TEAM_ID = "away_team_id";


    @SerializedName(FIELD_HOME_TEAM_ID)
    private int mHomeTeamId;
    @SerializedName(FIELD_HOME_GOALS)
    private int mHomeGoal;
    @SerializedName(FIELD_RESULTS)
    private Result mResult;
    @SerializedName(FIELD_AWAY_GOALS)
    private int mAwayGoal;
    @SerializedName(FIELD_LOCATION)
    private String mLocation;
    @SerializedName(FIELD_DRAW)
    private int mDraw;
    @SerializedName(FIELD_LEAGUE_ID)
    private int mLeagueId;
    @SerializedName(FIELD_DATE)
    private Long mDate;
    @SerializedName(FIELD_AWAY_TEAM_NAME)
    private String mAwayTeamName;
    @SerializedName(FIELD_HOME_WIN)
    private int mHomeWin;
    @SerializedName(FIELD_ID)
    private long mId;
    @SerializedName(FIELD_AWAY_WIN)
    private int mAwayWin;
    @SerializedName(FIELD_LEAGUE_NAME)
    private String mLeagueName;
    @SerializedName(FIELD_HOME_TEAM_NAME)
    private String mHomeTeamName;
    @SerializedName(FIELD_HOT_GAME)
    private int mHotGame;
    @SerializedName(FIELD_JC_GAME)
    private int mJcGame;
    @SerializedName(FIELD_AWAY_TEAM_ID)
    private int mAwayTeamId;


    public HotGame(){

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

    public void setResult(Result result) {
        mResult = result;
    }

    public Result getResult() {
        return mResult;
    }

    public void setAwayGoal(int awayGoal) {
        mAwayGoal = awayGoal;
    }

    public int getAwayGoal() {
        return mAwayGoal;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setDraw(int draw) {
        mDraw = draw;
    }

    public int getDraw() {
        return mDraw;
    }

    public void setLeagueId(int leagueId) {
        mLeagueId = leagueId;
    }

    public int getLeagueId() {
        return mLeagueId;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public Long getDate() {
        return mDate;
    }

    public void setAwayTeamName(String awayTeamName) {
        mAwayTeamName = awayTeamName;
    }

    public String getAwayTeamName() {
        return mAwayTeamName;
    }

    public void setHomeWin(int homeWin) {
        mHomeWin = homeWin;
    }

    public int getHomeWin() {
        return mHomeWin;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setAwayWin(int awayWin) {
        mAwayWin = awayWin;
    }

    public int getAwayWin() {
        return mAwayWin;
    }

    public void setLeagueName(String leagueName) {
        mLeagueName = leagueName;
    }

    public String getLeagueName() {
        return mLeagueName;
    }

    public void setHomeTeamName(String homeTeamName) {
        mHomeTeamName = homeTeamName;
    }

    public String getHomeTeamName() {
        return mHomeTeamName;
    }

    public void setHotGame(int hotGame) {
        mHotGame = hotGame;
    }

    public int getHotGame() {
        return mHotGame;
    }

    public void setJcGame(int jcGame) {
        mJcGame = jcGame;
    }

    public int getJcGame() {
        return mJcGame;
    }

    public void setAwayTeamId(int awayTeamId) {
        mAwayTeamId = awayTeamId;
    }

    public int getAwayTeamId() {
        return mAwayTeamId;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof HotGame){
            return ((HotGame) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return ((Long)mId).hashCode();
    }

    public HotGame(Parcel in) {
        mHomeTeamId = in.readInt();
        mHomeGoal = in.readInt();
        mResult = in.readParcelable(Result.class.getClassLoader());
        mAwayGoal = in.readInt();
        mLocation = in.readString();
        mDraw = in.readInt();
        mLeagueId = in.readInt();
        mDate = in.readLong();
        mAwayTeamName = in.readString();
        mHomeWin = in.readInt();
        mId = in.readLong();
        mAwayWin = in.readInt();
        mLeagueName = in.readString();
        mHomeTeamName = in.readString();
        mHotGame = in.readInt();
        mJcGame = in.readInt();
        mAwayTeamId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HotGame> CREATOR = new Creator<HotGame>() {
        public HotGame createFromParcel(Parcel in) {
            return new HotGame(in);
        }

        public HotGame[] newArray(int size) {
        return new HotGame[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mHomeTeamId);
        dest.writeInt(mHomeGoal);
        dest.writeParcelable(mResult, flags);
        dest.writeInt(mAwayGoal);
        dest.writeString(mLocation);
        dest.writeInt(mDraw);
        dest.writeInt(mLeagueId);
        dest.writeLong(mDate);
        dest.writeString(mAwayTeamName);
        dest.writeInt(mHomeWin);
        dest.writeLong(mId);
        dest.writeInt(mAwayWin);
        dest.writeString(mLeagueName);
        dest.writeString(mHomeTeamName);
        dest.writeInt(mHotGame);
        dest.writeInt(mJcGame);
        dest.writeInt(mAwayTeamId);
    }


}