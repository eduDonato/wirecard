package com.example.wirecard.com.model.orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payment {

@SerializedName("id")
@Expose
private String id;
@SerializedName("installmentCount")
@Expose
private Integer installmentCount;
@SerializedName("fundingInstrument")
@Expose
private FundingInstrument fundingInstrument;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public Integer getInstallmentCount() {
return installmentCount;
}

public void setInstallmentCount(Integer installmentCount) {
this.installmentCount = installmentCount;
}

public FundingInstrument getFundingInstrument() {
return fundingInstrument;
}

public void setFundingInstrument(FundingInstrument fundingInstrument) {
this.fundingInstrument = fundingInstrument;
}

}