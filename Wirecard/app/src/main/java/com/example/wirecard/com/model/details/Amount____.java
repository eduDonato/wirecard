package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount____ {

@SerializedName("total")
@Expose
private Integer total;
@SerializedName("fees")
@Expose
private Integer fees;
@SerializedName("currency")
@Expose
private String currency;

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public Integer getFees() {
return fees;
}

public void setFees(Integer fees) {
this.fees = fees;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

}