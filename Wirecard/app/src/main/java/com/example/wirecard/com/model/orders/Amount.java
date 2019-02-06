package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount {

@SerializedName("total")
@Expose
private Integer total;
@SerializedName("addition")
@Expose
private Integer addition;
@SerializedName("fees")
@Expose
private Integer fees;
@SerializedName("deduction")
@Expose
private Integer deduction;
@SerializedName("otherReceivers")
@Expose
private Integer otherReceivers;
@SerializedName("currency")
@Expose
private String currency;

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public Integer getAddition() {
return addition;
}

public void setAddition(Integer addition) {
this.addition = addition;
}

public Integer getFees() {
return fees;
}

public void setFees(Integer fees) {
this.fees = fees;
}

public Integer getDeduction() {
return deduction;
}

public void setDeduction(Integer deduction) {
this.deduction = deduction;
}

public Integer getOtherReceivers() {
return otherReceivers;
}

public void setOtherReceivers(Integer otherReceivers) {
this.otherReceivers = otherReceivers;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

}