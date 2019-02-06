package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links____ {

@SerializedName("payment")
@Expose
private Payment___ payment;
@SerializedName("order")
@Expose
private Order___ order;
@SerializedName("self")
@Expose
private Self____ self;

public Payment___ getPayment() {
return payment;
}

public void setPayment(Payment___ payment) {
this.payment = payment;
}

public Order___ getOrder() {
return order;
}

public void setOrder(Order___ order) {
this.order = order;
}

public Self____ getSelf() {
return self;
}

public void setSelf(Self____ self) {
this.self = self;
}

}