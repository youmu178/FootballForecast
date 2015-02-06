package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class HomeRanking implements Parcelable{

    private static final String FIELD_TITLE = "title";
    private static final String FIELD_POSITION = "position";
    private static final String FIELD_DATA = "data";


    @SerializedName(FIELD_TITLE)
    private String mTitle;
    @SerializedName(FIELD_POSITION)
    private int mPosition;
    @SerializedName(FIELD_DATA)
    private String mDatum;


    public HomeRanking(){

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

    public HomeRanking(Parcel in) {
        mTitle = in.readString();
        mPosition = in.readInt();
        mDatum = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeRanking> CREATOR = new Creator<HomeRanking>() {
        public HomeRanking createFromParcel(Parcel in) {
            return new HomeRanking(in);
        }

        public HomeRanking[] newArray(int size) {
        return new HomeRanking[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeInt(mPosition);
        dest.writeString(mDatum);
    }


}