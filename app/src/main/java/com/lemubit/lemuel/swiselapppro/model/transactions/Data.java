package com.lemubit.lemuel.swiselapppro.model.transactions;

import org.parceler.Parcel;

@Parcel
public class Data {
    public String amount;
    public String reference;
    public String description;
    public String created;



    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
