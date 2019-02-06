package com.example.wirecard.com.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Checkout {

@SerializedName("payCheckout")
@Expose
private PayCheckout payCheckout;
@SerializedName("payCreditCard")
@Expose
private PayCreditCard payCreditCard;
@SerializedName("payBoleto")
@Expose
private PayBoleto payBoleto;
@SerializedName("payOnlineBankDebitItau")
@Expose
private PayOnlineBankDebitItau payOnlineBankDebitItau;

public PayCheckout getPayCheckout() {
return payCheckout;
}

public void setPayCheckout(PayCheckout payCheckout) {
this.payCheckout = payCheckout;
}

public PayCreditCard getPayCreditCard() {
return payCreditCard;
}

public void setPayCreditCard(PayCreditCard payCreditCard) {
this.payCreditCard = payCreditCard;
}

public PayBoleto getPayBoleto() {
return payBoleto;
}

public void setPayBoleto(PayBoleto payBoleto) {
this.payBoleto = payBoleto;
}

public PayOnlineBankDebitItau getPayOnlineBankDebitItau() {
return payOnlineBankDebitItau;
}

public void setPayOnlineBankDebitItau(PayOnlineBankDebitItau payOnlineBankDebitItau) {
this.payOnlineBankDebitItau = payOnlineBankDebitItau;
}

}