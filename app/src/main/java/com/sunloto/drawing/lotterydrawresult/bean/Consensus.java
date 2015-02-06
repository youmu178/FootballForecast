package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class Consensus implements Parcelable{





    public Consensus(){

    }

    public Consensus(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Consensus> CREATOR = new Creator<Consensus>() {
        public Consensus createFromParcel(Parcel in) {
            return new Consensus(in);
        }

        public Consensus[] newArray(int size) {
        return new Consensus[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }


}