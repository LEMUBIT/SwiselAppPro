package com.lemubit.lemuel.swiselapppro.model.transactions;

import org.parceler.Parcel;

@Parcel
public class TransactionsModel {
    public Data[] data;

    public String[] message;

    public String status;

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
