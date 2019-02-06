package com.example.wirecard.com.model.details;

import com.example.wirecard.com.model.ResponseInterface;
import com.example.wirecard.com.model.orders.Amount;
import com.example.wirecard.com.model.orders.Customer;
import com.example.wirecard.com.model.orders.Item;
import com.example.wirecard.com.model.orders.Payment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseOrderDetails implements ResponseInterface {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ownId")
    @Expose
    private String ownId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("amount")
    @Expose
    private Amount amount;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("payments")
    @Expose
    private List<Payment> payments = null;
    @SerializedName("escrows")
    @Expose
    private List<Object> escrows = null;
    @SerializedName("refunds")
    @Expose
    private List<Refund_> refunds = null;
    @SerializedName("entries")
    @Expose
    private List<Entry> entries = null;
    @SerializedName("events")
    @Expose
    private List<Event___> events = null;
    @SerializedName("receivers")
    @Expose
    private List<Receiver_> receivers = null;
    @SerializedName("shippingAddress")
    @Expose
    private ShippingAddress_ shippingAddress;
    @SerializedName("_links")
    @Expose
    private Links_____ links;

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Object> getEscrows() {
        return escrows;
    }

    public void setEscrows(List<Object> escrows) {
        this.escrows = escrows;
    }

    public List<Refund_> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund_> refunds) {
        this.refunds = refunds;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Event___> getEvents() {
        return events;
    }

    public void setEvents(List<Event___> events) {
        this.events = events;
    }

    public List<Receiver_> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver_> receivers) {
        this.receivers = receivers;
    }

    public ShippingAddress_ getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress_ shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Links_____ getLinks() {
        return links;
    }

    public void setLinks(Links_____ links) {
        this.links = links;
    }

}