package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class HomeAvg implements Parcelable{

    private static final String FIELD_VALUE = "value";
    private static final String FIELD_TITLE = "title";


    @SerializedName(FIELD_VALUE)
    private double mValue;
    @SerializedName(FIELD_TITLE)
    private String mTitle;


    public HomeAvg(){

    }

    public void setValue(double value) {
        mValue = value;
    }

    public double getValue() {
        return mValue;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public HomeAvg(Parcel in) {
        mValue = in.readDouble();
        mTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeAvg> CREATOR = new Creator<HomeAvg>() {
        public HomeAvg createFromParcel(Parcel in) {
            return new HomeAvg(in);
        }

        public HomeAvg[] newArray(int size) {
        return new HomeAvg[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mValue);
        dest.writeString(mTitle);
    }


}