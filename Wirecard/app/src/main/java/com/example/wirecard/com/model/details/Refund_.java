package com.example.wirecard.com.model.details;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Refund_ {

@SerializedName("id")
@Expose
private String id;
@SerializedName("status")
@Expose
private String status;
@SerializedName("events")
@Expose
private List<Event__> events = null;
@SerializedName("amount")
@Expose
private Amount____ amount;
@SerializedName("receiversDebited")
@Expose
private List<ReceiversDebited_> receiversDebited = null;
@SerializedName("type")
@Expose
private String type;
@SerializedName("refundingInstrument")
@Expose
private RefundingInstrument_ refundingInstrument;
@SerializedName("createdAt")
@Expose
private String createdAt;
@SerializedName("_links")
@Expose
private Links___ links;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public List<Event__> getEvents() {
return events;
}

public void setEvents(List<Event__> events) {
this.events = events;
}

public Amount____ getAmount() {
return amount;
}

public void setAmount(Amount____ amount) {
this.amount = amount;
}

public List<ReceiversDebited_> getReceiversDebited() {
return receiversDebited;
}

public void setReceiversDebited(List<ReceiversDebited_> receiversDebited) {
this.receiversDebited = receiversDebited;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public RefundingInstrument_ getRefundingInstrument() {
return refundingInstrument;
}

public void setRefundingInstrument(RefundingInstrument_ refundingInstrument) {
this.refundingInstrument = refundingInstrument;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public Links___ getLinks() {
return links;
}

public void setLinks(Links___ links) {
this.links = links;
}

}