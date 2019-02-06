package com.example.wirecard.com.model.orders;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

@SerializedName("_links")
@Expose
private Links links;
@SerializedName("summary")
@Expose
private Summary summary;
@SerializedName("orders")
@Expose
private List<Order> orders = null;

public Links getLinks() {
return links;
}

public void setLinks(Links links) {
this.links = links;
}

public Summary getSummary() {
return summary;
}

public void setSummary(Summary summary) {
this.summary = summary;
}

public List<Order> getOrders() {
return orders;
}

public void setOrders(List<Order> orders) {
this.orders = orders;
}

}