package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Previous {

@SerializedName("href")
@Expose
private String href;

public String getHref() {
return href;
}

public void setHref(String href) {
this.href = href;
}

}