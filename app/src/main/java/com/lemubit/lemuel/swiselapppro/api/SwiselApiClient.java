package com.lemubit.lemuel.swiselapppro.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lemubit.lemuel.swiselapppro.util.Url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwiselApiClient {
    private SwiselAppEndPoints swiselAppEndPoints;

    public SwiselApiClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.getUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        swiselAppEndPoints = retrofit.create(SwiselAppEndPoints.class);
    }

    public SwiselAppEndPoints getSwiselAppEndPoints() {
        return swiselAppEndPoints;
    }
}
