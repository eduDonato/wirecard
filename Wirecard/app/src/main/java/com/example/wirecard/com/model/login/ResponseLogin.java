package com.example.wirecard.com.model.login;

import com.example.wirecard.com.model.ResponseInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin implements ResponseInterface {

    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("expires_in")
    @Expose
    private String expiresIn;
    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("moipAccount")
    @Expose
    private MoipAccount moipAccount;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public MoipAccount getMoipAccount() {
        return moipAccount;
    }

    public void setMoipAccount(MoipAccount moipAccount) {
        this.moipAccount = moipAccount;
    }

}
