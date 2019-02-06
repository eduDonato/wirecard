package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

@SerializedName("id")
@Expose
private String id;
@SerializedName("event")
@Expose
private String event;
@SerializedName("status")
@Expose
private String status;
@SerializedName("operation")
@Expose
private String operation;
@SerializedName("amount")
@Expose
private Amount_____ amount;
@SerializedName("description")
@Expose
private String description;
@SerializedName("occurrence")
@Expose
private Occurrence occurrence;
@SerializedName("scheduledFor")
@Expose
private String scheduledFor;
@SerializedName("settledAt")
@Expose
private String settledAt;
@SerializedName("updatedAt")
@Expose
private String updatedAt;
@SerializedName("createdAt")
@Expose
private String createdAt;
@SerializedName("_links")
@Expose
private Links____ links;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getEvent() {
return event;
}

public void setEvent(String event) {
this.event = event;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getOperation() {
return operation;
}

public void setOperation(String operation) {
this.operation = operation;
}

public Amount_____ getAmount() {
return amount;
}

public void setAmount(Amount_____ amount) {
this.amount = amount;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Occurrence getOccurrence() {
return occurrence;
}

public void setOccurrence(Occurrence occurrence) {
this.occurrence = occurrence;
}

public String getScheduledFor() {
return scheduledFor;
}

public void setScheduledFor(String scheduledFor) {
this.scheduledFor = scheduledFor;
}

public String getSettledAt() {
return settledAt;
}

public void setSettledAt(String settledAt) {
this.settledAt = settledAt;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public Links____ getLinks() {
return links;
}

public void setLinks(Links____ links) {
this.links = links;
}

}