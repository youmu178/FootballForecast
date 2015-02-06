package com.sunloto.drawing.lotterydrawresult.bean;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class User implements Parcelable{

    private static final String FIELD_UID = "uid";
    private static final String FIELD_CHANNEL = "channel";
    private static final String FIELD_MOBILE = "mobile";
    private static final String FIELD_USERNAME = "username";
    private static final String FIELD_STATE = "state";
    private static final String FIELD_PASSWORD = "password";
    private static final String FIELD_USERID = "userid";
    private static final String FIELD_S_STOP_TIME = "s_stop_time";
    private static final String FIELD_REGISTER_DT = "register_dt";
    private static final String FIELD_EMAILACT = "emailact";
    private static final String FIELD_MOBILEACT = "mobileact";
    private static final String FIELD_EFFECT_TIME = "effectTime";
    private static final String FIELD_EMAIL = "email";


    @SerializedName(FIELD_UID)
    private int mUid;
    @SerializedName(FIELD_CHANNEL)
    private int mChannel;
    @SerializedName(FIELD_MOBILE)
    private String mMobile;
    @SerializedName(FIELD_USERNAME)
    private String mUsername;
    @SerializedName(FIELD_STATE)
    private int mState;
    @SerializedName(FIELD_PASSWORD)
    private String mPassword;
    @SerializedName(FIELD_USERID)
    private int mUserid;
    @SerializedName(FIELD_S_STOP_TIME)
    private String mSStopTime;
    @SerializedName(FIELD_REGISTER_DT)
    private Long mRegisterDt;
    @SerializedName(FIELD_EMAILACT)
    private int mEmailact;
    @SerializedName(FIELD_MOBILEACT)
    private int mMobileact;
    @SerializedName(FIELD_EFFECT_TIME)
    private int mEffectTime;
    @SerializedName(FIELD_EMAIL)
    private String mEmail;


    public User(){

    }

    public void setUid(int uid) {
        mUid = uid;
    }

    public int getUid() {
        return mUid;
    }

    public void setChannel(int channel) {
        mChannel = channel;
    }

    public int getChannel() {
        return mChannel;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setState(int state) {
        mState = state;
    }

    public int getState() {
        return mState;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setUserid(int userid) {
        mUserid = userid;
    }

    public int getUserid() {
        return mUserid;
    }

    public void setSStopTime(String sStopTime) {
        mSStopTime = sStopTime;
    }

    public String getSStopTime() {
        return mSStopTime;
    }

    public void setRegisterDt(Long registerDt) {
        mRegisterDt = registerDt;
    }

    public Long getRegisterDt() {
        return mRegisterDt;
    }

    public void setEmailact(int emailact) {
        mEmailact = emailact;
    }

    public int getEmailact() {
        return mEmailact;
    }

    public void setMobileact(int mobileact) {
        mMobileact = mobileact;
    }

    public int getMobileact() {
        return mMobileact;
    }

    public void setEffectTime(int effectTime) {
        mEffectTime = effectTime;
    }

    public int getEffectTime() {
        return mEffectTime;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getEmail() {
        return mEmail;
    }

    public User(Parcel in) {
        mUid = in.readInt();
        mChannel = in.readInt();
        mMobile = in.readString();
        mUsername = in.readString();
        mState = in.readInt();
        mPassword = in.readString();
        mUserid = in.readInt();
        mSStopTime = in.readString();
        mRegisterDt = in.readLong();
        mEmailact = in.readInt();
        mMobileact = in.readInt();
        mEffectTime = in.readInt();
        mEmail = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
        return new User[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mUid);
        dest.writeInt(mChannel);
        dest.writeString(mMobile);
        dest.writeString(mUsername);
        dest.writeInt(mState);
        dest.writeString(mPassword);
        dest.writeInt(mUserid);
        dest.writeString(mSStopTime);
        dest.writeLong(mRegisterDt);
        dest.writeInt(mEmailact);
        dest.writeInt(mMobileact);
        dest.writeInt(mEffectTime);
        dest.writeString(mEmail);
    }


}