package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class MlineOdd implements Parcelable{

    private static final String FIELD_HOME = "home";
    private static final String FIELD_DRAW = "draw";
    private static final String FIELD_AWAY = "away";
    private static final String FIELD_TIME = "time";


    @SerializedName(FIELD_HOME)
    private int mHome;
    @SerializedName(FIELD_DRAW)
    private int mDraw;
    @SerializedName(FIELD_AWAY)
    private int mAway;
    @SerializedName(FIELD_TIME)
    private Long mTime;


    public MlineOdd(){

    }

    public void setHome(int home) {
        mHome = home;
    }

    public int getHome() {
        return mHome;
    }

    public void setDraw(int draw) {
        mDraw = draw;
    }

    public int getDraw() {
        return mDraw;
    }

    public void setAway(int away) {
        mAway = away;
    }

    public int getAway() {
        return mAway;
    }

    public void setTime(Long time) {
        mTime = time;
    }

    public Long getTime() {
        return mTime;
    }

    public MlineOdd(Parcel in) {
        mHome = in.readInt();
        mDraw = in.readInt();
        mAway = in.readInt();
        mTime = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MlineOdd> CREATOR = new Creator<MlineOdd>() {
        public MlineOdd createFromParcel(Parcel in) {
            return new MlineOdd(in);
        }

        public MlineOdd[] newArray(int size) {
        return new MlineOdd[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mHome);
        dest.writeInt(mDraw);
        dest.writeInt(mAway);
        dest.writeLong(mTime);
    }


}