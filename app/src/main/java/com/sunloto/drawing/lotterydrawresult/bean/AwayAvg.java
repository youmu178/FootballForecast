package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class AwayAvg implements Parcelable{

    private static final String FIELD_VALUE = "value";
    private static final String FIELD_TITLE = "title";


    @SerializedName(FIELD_VALUE)
    private double mValue;
    @SerializedName(FIELD_TITLE)
    private String mTitle;


    public AwayAvg(){

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

    public AwayAvg(Parcel in) {
        mValue = in.readDouble();
        mTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AwayAvg> CREATOR = new Creator<AwayAvg>() {
        public AwayAvg createFromParcel(Parcel in) {
            return new AwayAvg(in);
        }

        public AwayAvg[] newArray(int size) {
        return new AwayAvg[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mValue);
        dest.writeString(mTitle);
    }


}