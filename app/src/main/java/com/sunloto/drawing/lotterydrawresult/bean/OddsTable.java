package com.sunloto.drawing.lotterydrawresult.bean;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class OddsTable implements Parcelable{

    private static final String FIELD_TO_WIN_TO_NIL = "to_win_to_nil";
    private static final String FIELD_BOOKMAKER_NAME = "bookmaker_name";
    private static final String FIELD_BOOKMAKER_ID = "bookmaker_id";
    private static final String FIELD_HANDICAP_SPREAD = "handicap_spread";
    private static final String FIELD_SECOND_HALF = "second_half";
    private static final String FIELD_OVER_2_5 = "over_2_5";
    private static final String FIELD_UNDER_2_5 = "under_2_5";
    private static final String FIELD_BOTH_TEAM_TO_SCORE = "both_team_to_score";
    private static final String FIELD_MONEYLINE = "moneyline";
    private static final String FIELD_FIRST_HALF = "first_half";


    @SerializedName(FIELD_TO_WIN_TO_NIL)
    private List<ToWinToNil> mToWinToNils;
    @SerializedName(FIELD_BOOKMAKER_NAME)
    private String mBookmakerName;
    @SerializedName(FIELD_BOOKMAKER_ID)
    private int mBookmakerId;
    @SerializedName(FIELD_HANDICAP_SPREAD)
    private List<HandicapSpread> mHandicapSpreads;
    @SerializedName(FIELD_SECOND_HALF)
    private List<SecondHalf> mSecondHalves;
    @SerializedName(FIELD_OVER_2_5)
    private int mOver25;
    @SerializedName(FIELD_UNDER_2_5)
    private int mUnder25;
    @SerializedName(FIELD_BOTH_TEAM_TO_SCORE)
    private List<BothTeamToScore> mBothTeamToScores;
    @SerializedName(FIELD_MONEYLINE)
    private List<Moneyline> mMoneylines;
    @SerializedName(FIELD_FIRST_HALF)
    private List<FirstHalf> mFirstHalves;


    public OddsTable(){

    }

    public void setToWinToNils(List<ToWinToNil> toWinToNils) {
        mToWinToNils = toWinToNils;
    }

    public List<ToWinToNil> getToWinToNils() {
        return mToWinToNils;
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

    public void setHandicapSpreads(List<HandicapSpread> handicapSpreads) {
        mHandicapSpreads = handicapSpreads;
    }

    public List<HandicapSpread> getHandicapSpreads() {
        return mHandicapSpreads;
    }

    public void setSecondHalves(List<SecondHalf> secondHalves) {
        mSecondHalves = secondHalves;
    }

    public List<SecondHalf> getSecondHalves() {
        return mSecondHalves;
    }

    public void setOver25(int over25) {
        mOver25 = over25;
    }

    public int getOver25() {
        return mOver25;
    }

    public void setUnder25(int under25) {
        mUnder25 = under25;
    }

    public int getUnder25() {
        return mUnder25;
    }

    public void setBothTeamToScores(List<BothTeamToScore> bothTeamToScores) {
        mBothTeamToScores = bothTeamToScores;
    }

    public List<BothTeamToScore> getBothTeamToScores() {
        return mBothTeamToScores;
    }

    public void setMoneylines(List<Moneyline> moneylines) {
        mMoneylines = moneylines;
    }

    public List<Moneyline> getMoneylines() {
        return mMoneylines;
    }

    public void setFirstHalves(List<FirstHalf> firstHalves) {
        mFirstHalves = firstHalves;
    }

    public List<FirstHalf> getFirstHalves() {
        return mFirstHalves;
    }

    public OddsTable(Parcel in) {
        mToWinToNils = new ArrayList<ToWinToNil>();
        in.readTypedList(mToWinToNils, ToWinToNil.CREATOR);
        mBookmakerName = in.readString();
        mBookmakerId = in.readInt();
        mHandicapSpreads = new ArrayList<HandicapSpread>();
        in.readTypedList(mHandicapSpreads, HandicapSpread.CREATOR);
        mSecondHalves = new ArrayList<SecondHalf>();
        in.readTypedList(mSecondHalves, SecondHalf.CREATOR);
        mOver25 = in.readInt();
        mUnder25 = in.readInt();
        mBothTeamToScores = new ArrayList<BothTeamToScore>();
        in.readTypedList(mBothTeamToScores, BothTeamToScore.CREATOR);
        mMoneylines = new ArrayList<Moneyline>();
        in.readTypedList(mMoneylines, Moneyline.CREATOR);
        mFirstHalves = new ArrayList<FirstHalf>();
        in.readTypedList(mFirstHalves, FirstHalf.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OddsTable> CREATOR = new Creator<OddsTable>() {
        public OddsTable createFromParcel(Parcel in) {
            return new OddsTable(in);
        }

        public OddsTable[] newArray(int size) {
        return new OddsTable[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mToWinToNils);
        dest.writeString(mBookmakerName);
        dest.writeInt(mBookmakerId);
        dest.writeTypedList(mHandicapSpreads);
        dest.writeTypedList(mSecondHalves);
        dest.writeInt(mOver25);
        dest.writeInt(mUnder25);
        dest.writeTypedList(mBothTeamToScores);
        dest.writeTypedList(mMoneylines);
        dest.writeTypedList(mFirstHalves);
    }


}