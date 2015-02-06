package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class UserInfo implements Parcelable{

    private static final String FIELD_STATE = "state";
    private static final String FIELD_USER = "user";


    @SerializedName(FIELD_STATE)
    private boolean mState;
    @SerializedName(FIELD_USER)
    private User mUser;


    public UserInfo(){

    }

    public void setState(boolean state) {
        mState = state;
    }

    public boolean isState() {
        return mState;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public User getUser() {
        return mUser;
    }

    public UserInfo(Parcel in) {
        mState = in.readInt() == 1 ? true: false;
        mUser = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        public UserInfo[] newArray(int size) {
        return new UserInfo[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mState ? 1 : 0);
        dest.writeParcelable(mUser, flags);
    }


}