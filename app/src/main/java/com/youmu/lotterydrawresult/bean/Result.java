package com.youmu.lotterydrawresult.bean;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class Result implements Parcelable{

    private static final String FIELD_GAME_TIP = "gameTip";
    private static final String FIELD_AWAY_FINAL_SCORE = "awayFinalScore";
    private static final String FIELD_ID = "id";
    private static final String FIELD_WAS_PREDICTION_CORRECT = "was_prediction_correct";
    private static final String FIELD_TIP = "tip";
    private static final String FIELD_GAMEID = "gameid";
    private static final String FIELD_HOME_FINAL_SCORE = "homeFinalScore";
    private static final String FIELD_FINAL_SCORE = "final_score";


    @SerializedName(FIELD_GAME_TIP)
    private String mGameTip;
    @SerializedName(FIELD_AWAY_FINAL_SCORE)
    private int mAwayFinalScore;
    @SerializedName(FIELD_ID)
    private long mId;
    @SerializedName(FIELD_WAS_PREDICTION_CORRECT)
    private String mWasPredictionCorrect;
    @SerializedName(FIELD_TIP)
    private List<Tip> mTips;
    @SerializedName(FIELD_GAMEID)
    private int mGameid;
    @SerializedName(FIELD_HOME_FINAL_SCORE)
    private int mHomeFinalScore;
    @SerializedName(FIELD_FINAL_SCORE)
    private FinalScore mFinalScore;


    public Result(){

    }

    public void setGameTip(String gameTip) {
        mGameTip = gameTip;
    }

    public String getGameTip() {
        return mGameTip;
    }

    public void setAwayFinalScore(int awayFinalScore) {
        mAwayFinalScore = awayFinalScore;
    }

    public int getAwayFinalScore() {
        return mAwayFinalScore;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setWasPredictionCorrect(String wasPredictionCorrect) {
        mWasPredictionCorrect = wasPredictionCorrect;
    }

    public String getWasPredictionCorrect() {
        return mWasPredictionCorrect;
    }

    public void setTips(List<Tip> tips) {
        mTips = tips;
    }

    public List<Tip> getTips() {
        return mTips;
    }

    public void setGameid(int gameid) {
        mGameid = gameid;
    }

    public int getGameid() {
        return mGameid;
    }

    public void setHomeFinalScore(int homeFinalScore) {
        mHomeFinalScore = homeFinalScore;
    }

    public int getHomeFinalScore() {
        return mHomeFinalScore;
    }

    public void setFinalScore(FinalScore finalScore) {
        mFinalScore = finalScore;
    }

    public FinalScore getFinalScore() {
        return mFinalScore;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Result){
            return ((Result) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return ((Long)mId).hashCode();
    }

    public Result(Parcel in) {
        mGameTip = in.readString();
        mAwayFinalScore = in.readInt();
        mId = in.readLong();
        mWasPredictionCorrect = in.readString();
        mTips = new ArrayList<Tip>();
        in.readTypedList(mTips, Tip.CREATOR);
        mGameid = in.readInt();
        mHomeFinalScore = in.readInt();
        mFinalScore = in.readParcelable(FinalScore.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
        return new Result[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mGameTip);
        dest.writeInt(mAwayFinalScore);
        dest.writeLong(mId);
        dest.writeString(mWasPredictionCorrect);
        dest.writeTypedList(mTips);
        dest.writeInt(mGameid);
        dest.writeInt(mHomeFinalScore);
        dest.writeParcelable(mFinalScore, flags);
    }


}