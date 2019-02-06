package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary {

@SerializedName("count")
@Expose
private Integer count;
@SerializedName("amount")
@Expose
private Integer amount;

public Integer getCount() {
return count;
}

public void setCount(Integer count) {
this.count = count;
}

public Integer getAmount() {
return amount;
}

public void setAmount(Integer amount) {
this.amount = amount;
}

}