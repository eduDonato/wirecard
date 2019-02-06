package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RefundingInstrument_ {

@SerializedName("creditCard")
@Expose
private CreditCard____ creditCard;
@SerializedName("method")
@Expose
private String method;

public CreditCard____ getCreditCard() {
return creditCard;
}

public void setCreditCard(CreditCard____ creditCard) {
this.creditCard = creditCard;
}

public String getMethod() {
return method;
}

public void setMethod(String method) {
this.method = method;
}

}