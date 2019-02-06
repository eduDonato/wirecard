package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

@SerializedName("type")
@Expose
private String type;
@SerializedName("createdAt")
@Expose
private String createdAt;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

}