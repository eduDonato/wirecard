package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingAddress_ {

@SerializedName("zipCode")
@Expose
private String zipCode;
@SerializedName("street")
@Expose
private String street;
@SerializedName("streetNumber")
@Expose
private String streetNumber;
@SerializedName("city")
@Expose
private String city;
@SerializedName("district")
@Expose
private String district;
@SerializedName("state")
@Expose
private String state;
@SerializedName("country")
@Expose
private String country;

public String getZipCode() {
return zipCode;
}

public void setZipCode(String zipCode) {
this.zipCode = zipCode;
}

public String getStreet() {
return street;
}

public void setStreet(String street) {
this.street = street;
}

public String getStreetNumber() {
return streetNumber;
}

public void setStreetNumber(String streetNumber) {
this.streetNumber = streetNumber;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getDistrict() {
return district;
}

public void setDistrict(String district) {
this.district = district;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

}