package com.lemubit.lemuel.swiselapppro.model.result;

import com.lemubit.lemuel.swiselapppro.model.result.Data;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class ResultModel {
    public String status;
    public ArrayList<Object> message = new ArrayList<>();
    public Data[] data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Object> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<Object> message) {
        this.message = message;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
