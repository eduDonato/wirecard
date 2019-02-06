package com.example.wirecard.com.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestLogin {

    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("client_secret")
    @Expose
    private String clientSecret;
    @SerializedName("grant_type")
    @Expose
    private String grantType;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("scope")
    @Expose
    private String scope;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
