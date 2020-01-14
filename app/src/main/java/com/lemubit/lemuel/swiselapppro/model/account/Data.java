package com.lemubit.lemuel.swiselapppro.model.account;

import org.parceler.Parcel;

@Parcel
public class Data {
    public String id;
    public String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
