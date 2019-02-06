package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount_____ {

@SerializedName("total")
@Expose
private Integer total;
@SerializedName("fee")
@Expose
private Integer fee;
@SerializedName("liquid")
@Expose
private Integer liquid;
@SerializedName("currency")
@Expose
private String currency;

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public Integer getFee() {
return fee;
}

public void setFee(Integer fee) {
this.fee = fee;
}

public Integer getLiquid() {
return liquid;
}

public void setLiquid(Integer liquid) {
this.liquid = liquid;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

}