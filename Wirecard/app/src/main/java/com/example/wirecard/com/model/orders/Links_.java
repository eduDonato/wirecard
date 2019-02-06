package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ {

@SerializedName("self")
@Expose
private Self self;

public Self getSelf() {
return self;
}

public void setSelf(Self self) {
this.self = self;
}

}