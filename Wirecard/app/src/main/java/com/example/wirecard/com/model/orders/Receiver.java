package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Receiver {

@SerializedName("type")
@Expose
private String type;
@SerializedName("moipAccount")
@Expose
private MoipAccount moipAccount;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public MoipAccount getMoipAccount() {
return moipAccount;
}

public void setMoipAccount(MoipAccount moipAccount) {
this.moipAccount = moipAccount;
}

}