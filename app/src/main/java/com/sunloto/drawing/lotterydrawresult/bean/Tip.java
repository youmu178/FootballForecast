package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class Tip implements Parcelable{





    public Tip(){

    }

    public Tip(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tip> CREATOR = new Creator<Tip>() {
        public Tip createFromParcel(Parcel in) {
            return new Tip(in);
        }

        public Tip[] newArray(int size) {
        return new Tip[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }


}