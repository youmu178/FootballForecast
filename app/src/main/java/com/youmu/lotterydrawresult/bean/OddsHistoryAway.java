package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class OddsHistoryAway implements Parcelable{

    private static final String FIELD_BTG_ODDS = "btg_odds";
    private static final String FIELD_ODDS = "odds";
    private static final String FIELD_DATE = "date";


    @SerializedName(FIELD_BTG_ODDS)
    private double mBtgOdd;
    @SerializedName(FIELD_ODDS)
    private double mOdd;
    @SerializedName(FIELD_DATE)
    private Long mDate;


    public OddsHistoryAway(){

    }

    public void setBtgOdd(double btgOdd) {
        mBtgOdd = btgOdd;
    }

    public double getBtgOdd() {
        return mBtgOdd;
    }

    public void setOdd(double odd) {
        mOdd = odd;
    }

    public double getOdd() {
        return mOdd;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public Long getDate() {
        return mDate;
    }

    public OddsHistoryAway(Parcel in) {
        mBtgOdd = in.readDouble();
        mOdd = in.readDouble();
        mDate = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OddsHistoryAway> CREATOR = new Creator<OddsHistoryAway>() {
        public OddsHistoryAway createFromParcel(Parcel in) {
            return new OddsHistoryAway(in);
        }

        public OddsHistoryAway[] newArray(int size) {
        return new OddsHistoryAway[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mBtgOdd);
        dest.writeDouble(mOdd);
        dest.writeLong(mDate);
    }


}