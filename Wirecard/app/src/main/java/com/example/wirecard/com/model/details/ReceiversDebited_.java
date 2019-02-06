package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReceiversDebited_ {

@SerializedName("amount")
@Expose
private Integer amount;
@SerializedName("moipAccount")
@Expose
private String moipAccount;

public Integer getAmount() {
return amount;
}

public void setAmount(Integer amount) {
this.amount = amount;
}

public String getMoipAccount() {
return moipAccount;
}

public void setMoipAccount(String moipAccount) {
this.moipAccount = moipAccount;
}

}