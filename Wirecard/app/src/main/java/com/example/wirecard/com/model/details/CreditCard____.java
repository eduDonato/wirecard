package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditCard____ {

@SerializedName("brand")
@Expose
private String brand;
@SerializedName("first6")
@Expose
private String first6;
@SerializedName("last4")
@Expose
private String last4;
@SerializedName("store")
@Expose
private Boolean store;

public String getBrand() {
return brand;
}

public void setBrand(String brand) {
this.brand = brand;
}

public String getFirst6() {
return first6;
}

public void setFirst6(String first6) {
this.first6 = first6;
}

public String getLast4() {
return last4;
}

public void setLast4(String last4) {
this.last4 = last4;
}

public Boolean getStore() {
return store;
}

public void setStore(Boolean store) {
this.store = store;
}

}