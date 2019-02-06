package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event___ {

@SerializedName("type")
@Expose
private String type;
@SerializedName("createdAt")
@Expose
private String createdAt;
@SerializedName("description")
@Expose
private String description;

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

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

}