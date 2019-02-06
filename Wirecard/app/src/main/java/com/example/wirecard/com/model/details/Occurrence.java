package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Occurrence {

@SerializedName("in")
@Expose
private String in;
@SerializedName("to")
@Expose
private String to;

public String getIn() {
return in;
}

public void setIn(String in) {
this.in = in;
}

public String getTo() {
return to;
}

public void setTo(String to) {
this.to = to;
}

}