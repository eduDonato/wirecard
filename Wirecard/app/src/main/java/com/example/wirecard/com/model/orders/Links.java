package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

@SerializedName("next")
@Expose
private Next next;
@SerializedName("previous")
@Expose
private Previous previous;

public Next getNext() {
return next;
}

public void setNext(Next next) {
this.next = next;
}

public Previous getPrevious() {
return previous;
}

public void setPrevious(Previous previous) {
this.previous = previous;
}

}