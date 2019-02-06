package com.example.wirecard.com.model.orders;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

@SerializedName("id")
@Expose
private String id;
@SerializedName("ownId")
@Expose
private String ownId;
@SerializedName("status")
@Expose
private String status;
@SerializedName("blocked")
@Expose
private Boolean blocked;
@SerializedName("amount")
@Expose
private Amount amount;
@SerializedName("receivers")
@Expose
private List<Receiver> receivers = null;
@SerializedName("customer")
@Expose
private Customer customer;
@SerializedName("items")
@Expose
private List<Item> items = null;
@SerializedName("payments")
@Expose
private List<Payment> payments = null;
@SerializedName("events")
@Expose
private List<Event> events = null;
@SerializedName("_links")
@Expose
private Links_ links;
@SerializedName("createdAt")
@Expose
private String createdAt;
@SerializedName("updatedAt")
@Expose
private String updatedAt;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getOwnId() {
return ownId;
}

public void setOwnId(String ownId) {
this.ownId = ownId;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Boolean getBlocked() {
return blocked;
}

public void setBlocked(Boolean blocked) {
this.blocked = blocked;
}

public Amount getAmount() {
return amount;
}

public void setAmount(Amount amount) {
this.amount = amount;
}

public List<Receiver> getReceivers() {
return receivers;
}

public void setReceivers(List<Receiver> receivers) {
this.receivers = receivers;
}

public Customer getCustomer() {
return customer;
}

public void setCustomer(Customer customer) {
this.customer = customer;
}

public List<Item> getItems() {
return items;
}

public void setItems(List<Item> items) {
this.items = items;
}

public List<Payment> getPayments() {
return payments;
}

public void setPayments(List<Payment> payments) {
this.payments = payments;
}

public List<Event> getEvents() {
return events;
}

public void setEvents(List<Event> events) {
this.events = events;
}

public Links_ getLinks() {
return links;
}

public void setLinks(Links_ links) {
this.links = links;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

}