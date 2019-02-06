package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

@SerializedName("product")
@Expose
private Object product;

public Object getProduct() {
return product;
}

public void setProduct(Object product) {
this.product = product;
}

}