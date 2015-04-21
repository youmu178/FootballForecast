package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class AwayRanking implements Parcelable{

    private static final String FIELD_TITLE = "title";
    private static final String FIELD_POSITION = "position";
    private static final String FIELD_DATA = "data";


    @SerializedName(FIELD_TITLE)
    private String mTitle;
    @SerializedName(FIELD_POSITION)
    private int mPosition;
    @SerializedName(FIELD_DATA)
    private String mDatum;


    public AwayRanking(){

    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setDatum(String datum) {
        mDatum = datum;
    }

    public String getDatum() {
        return mDatum;
    }

    public AwayRanking(Parcel in) {
        mTitle = in.readString();
        mPosition = in.readInt();
        mDatum = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AwayRanking> CREATOR = new Creator<AwayRanking>() {
        public AwayRanking createFromParcel(Parcel in) {
            return new AwayRanking(in);
        }

        public AwayRanking[] newArray(int size) {
        return new AwayRanking[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeInt(mPosition);
        dest.writeString(mDatum);
    }


}