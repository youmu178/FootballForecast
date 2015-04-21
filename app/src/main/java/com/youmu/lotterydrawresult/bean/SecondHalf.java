package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class SecondHalf implements Parcelable{

    private static final String FIELD_ODDS = "odds";
    private static final String FIELD_TITLE = "title";


    @SerializedName(FIELD_ODDS)
    private double mOdd;
    @SerializedName(FIELD_TITLE)
    private String mTitle;


    public SecondHalf(){

    }

    public void setOdd(double odd) {
        mOdd = odd;
    }

    public double getOdd() {
        return mOdd;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public SecondHalf(Parcel in) {
        mOdd = in.readDouble();
        mTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SecondHalf> CREATOR = new Creator<SecondHalf>() {
        public SecondHalf createFromParcel(Parcel in) {
            return new SecondHalf(in);
        }

        public SecondHalf[] newArray(int size) {
        return new SecondHalf[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mOdd);
        dest.writeString(mTitle);
    }


}