package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class ProbabilityToWin implements Parcelable{





    public ProbabilityToWin(){

    }

    public ProbabilityToWin(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProbabilityToWin> CREATOR = new Creator<ProbabilityToWin>() {
        public ProbabilityToWin createFromParcel(Parcel in) {
            return new ProbabilityToWin(in);
        }

        public ProbabilityToWin[] newArray(int size) {
        return new ProbabilityToWin[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }


}