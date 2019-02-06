package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Receiver_ {

@SerializedName("moipAccount")
@Expose
private MoipAccount_ moipAccount;
@SerializedName("type")
@Expose
private String type;
@SerializedName("amount")
@Expose
private Amount______ amount;
@SerializedName("feePayor")
@Expose
private Boolean feePayor;

public MoipAccount_ getMoipAccount() {
return moipAccount;
}

public void setMoipAccount(MoipAccount_ moipAccount) {
this.moipAccount = moipAccount;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Amount______ getAmount() {
return amount;
}

public void setAmount(Amount______ amount) {
this.amount = amount;
}

public Boolean getFeePayor() {
return feePayor;
}

public void setFeePayor(Boolean feePayor) {
this.feePayor = feePayor;
}

}