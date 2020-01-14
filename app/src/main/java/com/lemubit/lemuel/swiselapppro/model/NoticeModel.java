package com.lemubit.lemuel.swiselapppro.model;

import org.parceler.Parcel;

@Parcel
public class NoticeModel {
    String status;
    public String[] message;
    Data[] data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
