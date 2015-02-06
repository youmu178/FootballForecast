package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class OuOdd implements Parcelable{

    private static final String FIELD_UNDER = "under";
    private static final String FIELD_OVER = "over";
    private static final String FIELD_TIME = "time";


    @SerializedName(FIELD_UNDER)
    private int mUnder;
    @SerializedName(FIELD_OVER)
    private int mOver;
    @SerializedName(FIELD_TIME)
    private Long mTime;


    public OuOdd(){

    }

    public void setUnder(int under) {
        mUnder = under;
    }

    public int getUnder() {
        return mUnder;
    }

    public void setOver(int over) {
        mOver = over;
    }

    public int getOver() {
        return mOver;
    }

    public void setTime(Long time) {
        mTime = time;
    }

    public Long getTime() {
        return mTime;
    }

    public OuOdd(Parcel in) {
        mUnder = in.readInt();
        mOver = in.readInt();
        mTime = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OuOdd> CREATOR = new Creator<OuOdd>() {
        public OuOdd createFromParcel(Parcel in) {
            return new OuOdd(in);
        }

        public OuOdd[] newArray(int size) {
        return new OuOdd[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mUnder);
        dest.writeInt(mOver);
        dest.writeLong(mTime);
    }


}