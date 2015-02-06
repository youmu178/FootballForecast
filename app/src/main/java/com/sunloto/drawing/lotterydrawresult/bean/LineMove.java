package com.sunloto.drawing.lotterydrawresult.bean;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class LineMove implements Parcelable{

    private static final String FIELD_BOOKMAKER_NAME = "bookmaker_name";
    private static final String FIELD_BOOKMAKER_ID = "bookmaker_id";
    private static final String FIELD_ODDS_HISTORY_BTTS = "oddsHistoryBtts";
    private static final String FIELD_ODDS_HISTORY_AWAY = "oddsHistoryAway";
    private static final String FIELD_ODDS_HISTORY_DRAW = "oddsHistoryDraw";
    private static final String FIELD_ODDS_HISTORY_UNDER = "oddsHistoryUnder";
    private static final String FIELD_GAMEID = "gameid";
    private static final String FIELD_ODDS_HISTORY_HOME = "oddsHistoryHome";
    private static final String FIELD_ODDS_HISTORY_OVER = "oddsHistoryOver";


    @SerializedName(FIELD_BOOKMAKER_NAME)
    private String mBookmakerName;
    @SerializedName(FIELD_BOOKMAKER_ID)
    private int mBookmakerId;
    @SerializedName(FIELD_ODDS_HISTORY_BTTS)
    private List<OddsHistoryBtt> mOddsHistoryBtts;
    @SerializedName(FIELD_ODDS_HISTORY_AWAY)
    private List<OddsHistoryAway> mOddsHistoryAways;
    @SerializedName(FIELD_ODDS_HISTORY_DRAW)
    private List<OddsHistoryDraw> mOddsHistoryDraws;
    @SerializedName(FIELD_ODDS_HISTORY_UNDER)
    private List<OddsHistoryUnder> mOddsHistoryUnders;
    @SerializedName(FIELD_GAMEID)
    private int mGameid;
    @SerializedName(FIELD_ODDS_HISTORY_HOME)
    private List<OddsHistoryHome> mOddsHistoryHomes;
    @SerializedName(FIELD_ODDS_HISTORY_OVER)
    private List<OddsHistoryOver> mOddsHistoryOvers;


    public LineMove(){

    }

    public void setBookmakerName(String bookmakerName) {
        mBookmakerName = bookmakerName;
    }

    public String getBookmakerName() {
        return mBookmakerName;
    }

    public void setBookmakerId(int bookmakerId) {
        mBookmakerId = bookmakerId;
    }

    public int getBookmakerId() {
        return mBookmakerId;
    }

    public void setOddsHistoryBtts(List<OddsHistoryBtt> oddsHistoryBtts) {
        mOddsHistoryBtts = oddsHistoryBtts;
    }

    public List<OddsHistoryBtt> getOddsHistoryBtts() {
        return mOddsHistoryBtts;
    }

    public void setOddsHistoryAways(List<OddsHistoryAway> oddsHistoryAways) {
        mOddsHistoryAways = oddsHistoryAways;
    }

    public List<OddsHistoryAway> getOddsHistoryAways() {
        return mOddsHistoryAways;
    }

    public void setOddsHistoryDraws(List<OddsHistoryDraw> oddsHistoryDraws) {
        mOddsHistoryDraws = oddsHistoryDraws;
    }

    public List<OddsHistoryDraw> getOddsHistoryDraws() {
        return mOddsHistoryDraws;
    }

    public void setOddsHistoryUnders(List<OddsHistoryUnder> oddsHistoryUnders) {
        mOddsHistoryUnders = oddsHistoryUnders;
    }

    public List<OddsHistoryUnder> getOddsHistoryUnders() {
        return mOddsHistoryUnders;
    }

    public void setGameid(int gameid) {
        mGameid = gameid;
    }

    public int getGameid() {
        return mGameid;
    }

    public void setOddsHistoryHomes(List<OddsHistoryHome> oddsHistoryHomes) {
        mOddsHistoryHomes = oddsHistoryHomes;
    }

    public List<OddsHistoryHome> getOddsHistoryHomes() {
        return mOddsHistoryHomes;
    }

    public void setOddsHistoryOvers(List<OddsHistoryOver> oddsHistoryOvers) {
        mOddsHistoryOvers = oddsHistoryOvers;
    }

    public List<OddsHistoryOver> getOddsHistoryOvers() {
        return mOddsHistoryOvers;
    }

    public LineMove(Parcel in) {
        mBookmakerName = in.readString();
        mBookmakerId = in.readInt();
        mOddsHistoryBtts = new ArrayList<OddsHistoryBtt>();
        in.readTypedList(mOddsHistoryBtts, OddsHistoryBtt.CREATOR);
        mOddsHistoryAways = new ArrayList<OddsHistoryAway>();
        in.readTypedList(mOddsHistoryAways, OddsHistoryAway.CREATOR);
        mOddsHistoryDraws = new ArrayList<OddsHistoryDraw>();
        in.readTypedList(mOddsHistoryDraws, OddsHistoryDraw.CREATOR);
        mOddsHistoryUnders = new ArrayList<OddsHistoryUnder>();
        in.readTypedList(mOddsHistoryUnders, OddsHistoryUnder.CREATOR);
        mGameid = in.readInt();
        mOddsHistoryHomes = new ArrayList<OddsHistoryHome>();
        in.readTypedList(mOddsHistoryHomes, OddsHistoryHome.CREATOR);
        mOddsHistoryOvers = new ArrayList<OddsHistoryOver>();
        in.readTypedList(mOddsHistoryOvers, OddsHistoryOver.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LineMove> CREATOR = new Creator<LineMove>() {
        public LineMove createFromParcel(Parcel in) {
            return new LineMove(in);
        }

        public LineMove[] newArray(int size) {
        return new LineMove[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mBookmakerName);
        dest.writeInt(mBookmakerId);
        dest.writeTypedList(mOddsHistoryBtts);
        dest.writeTypedList(mOddsHistoryAways);
        dest.writeTypedList(mOddsHistoryDraws);
        dest.writeTypedList(mOddsHistoryUnders);
        dest.writeInt(mGameid);
        dest.writeTypedList(mOddsHistoryHomes);
        dest.writeTypedList(mOddsHistoryOvers);
    }


}