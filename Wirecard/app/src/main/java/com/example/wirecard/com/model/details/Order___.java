package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order___ {

@SerializedName("href")
@Expose
private String href;
@SerializedName("title")
@Expose
private String title;

public String getHref() {
return href;
}

public void setHref(String href) {
this.href = href;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

}