package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class UserInfo implements Parcelable{

    private static final String FIELD_STATE = "state";
    private static final String FIELD_USER = "user";
    private static final String FIELD_MESSAGE = "message";
    private static final String FIELD_ERROR = "error";


    @SerializedName(FIELD_STATE)
    private boolean mState;
    @SerializedName(FIELD_USER)
    private User mUser;
    @SerializedName(FIELD_MESSAGE)
    private String mMessage;
    @SerializedName(FIELD_ERROR)
    private String mError;

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

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getmError() {
        return mError;
    }

    public void setmError(String mError) {
        this.mError = mError;
    }

    public UserInfo(Parcel in) {
        mState = in.readInt() == 1 ? true: false;
        mMessage = in.readString();
        mError = in.readString();
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
        dest.writeString(mMessage);
        dest.writeString(mError);
    }


}