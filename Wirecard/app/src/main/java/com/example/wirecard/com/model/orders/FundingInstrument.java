package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FundingInstrument {

@SerializedName("method")
@Expose
private String method;
@SerializedName("brand")
@Expose
private Object brand;

public String getMethod() {
return method;
}

public void setMethod(String method) {
this.method = method;
}

public Object getBrand() {
return brand;
}

public void setBrand(Object brand) {
this.brand = brand;
}

}