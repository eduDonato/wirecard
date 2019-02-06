package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayCheckout {

@SerializedName("redirectHref")
@Expose
private String redirectHref;

public String getRedirectHref() {
return redirectHref;
}

public void setRedirectHref(String redirectHref) {
this.redirectHref = redirectHref;
}

}