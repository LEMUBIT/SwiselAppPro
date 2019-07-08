package com.lemubit.lemuel.swiselapppro.model.login;

import com.lemubit.lemuel.swiselapppro.model.login.Data;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class LoginModel {
   public String status;
   public ArrayList<Object> message = new ArrayList<>();
   public Data data;


    public String getStatus() {
        return status;
    }

    public ArrayList<Object> getMessage(){return message;}

    public Data getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Data dataObject) {
        this.data = dataObject;
    }
}

