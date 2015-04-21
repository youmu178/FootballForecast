package com.youmu.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class Pick implements Parcelable{

    private static final String FIELD_TEAM = "team";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_DESCRIPTION = "description";


    @SerializedName(FIELD_TEAM)
    private String mTeam;
    @SerializedName(FIELD_TITLE)
    private String mTitle;
    @SerializedName(FIELD_DESCRIPTION)
    private String mDescription;


    public Pick(){

    }

    public void setTeam(String team) {
        mTeam = team;
    }

    public String getTeam() {
        return mTeam;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public Pick(Parcel in) {
        mTeam = in.readString();
        mTitle = in.readString();
        mDescription = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pick> CREATOR = new Creator<Pick>() {
        public Pick createFromParcel(Parcel in) {
            return new Pick(in);
        }

        public Pick[] newArray(int size) {
        return new Pick[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTeam);
        dest.writeString(mTitle);
        dest.writeString(mDescription);
    }


}