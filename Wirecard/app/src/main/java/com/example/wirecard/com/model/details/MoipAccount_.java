package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoipAccount_ {

@SerializedName("id")
@Expose
private String id;
@SerializedName("login")
@Expose
private String login;
@SerializedName("fullname")
@Expose
private String fullname;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getLogin() {
return login;
}

public void setLogin(String login) {
this.login = login;
}

public String getFullname() {
return fullname;
}

public void setFullname(String fullname) {
this.fullname = fullname;
}

}