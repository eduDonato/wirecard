package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_____ {

@SerializedName("self")
@Expose
private Self_____ self;
@SerializedName("checkout")
@Expose
private Checkout checkout;

public Self_____ getSelf() {
return self;
}

public void setSelf(Self_____ self) {
this.self = self;
}

public Checkout getCheckout() {
return checkout;
}

public void setCheckout(Checkout checkout) {
this.checkout = checkout;
}

}