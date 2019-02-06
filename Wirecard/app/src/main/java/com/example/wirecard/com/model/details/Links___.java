package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links___ {

@SerializedName("self")
@Expose
private Self___ self;
@SerializedName("order")
@Expose
private Order__ order;
@SerializedName("payment")
@Expose
private Payment__ payment;

public Self___ getSelf() {
return self;
}

public void setSelf(Self___ self) {
this.self = self;
}

public Order__ getOrder() {
return order;
}

public void setOrder(Order__ order) {
this.order = order;
}

public Payment__ getPayment() {
return payment;
}

public void setPayment(Payment__ payment) {
this.payment = payment;
}

}