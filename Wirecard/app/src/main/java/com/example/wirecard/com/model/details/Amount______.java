package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount______ {

@SerializedName("total")
@Expose
private Integer total;
@SerializedName("currency")
@Expose
private String currency;
@SerializedName("fees")
@Expose
private Integer fees;
@SerializedName("refunds")
@Expose
private Integer refunds;

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

public Integer getFees() {
return fees;
}

public void setFees(Integer fees) {
this.fees = fees;
}

public Integer getRefunds() {
return refunds;
}

public void setRefunds(Integer refunds) {
this.refunds = refunds;
}

}