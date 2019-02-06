package com.example.wirecard.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    public static final String KEY_USER = "user";

    private String user;
    private String password;
    private String accessToken;
    private String moipAccount;
    private String id;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    protected User(Parcel in) {
        this.user = in.readString();
        this.password = in.readString();
        this.accessToken = in.readString();
        this.moipAccount = in.readString();
        this.id = in.readString();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMoipAccount() {
        return moipAccount;
    }

    public void setMoipAccount(String moipAccount) {
        this.moipAccount = moipAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.user);
        dest.writeString(this.password);
        dest.writeString(this.accessToken);
        dest.writeString(this.id);
        dest.writeString(this.moipAccount);
    }

    public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
