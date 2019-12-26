package com.sample.places_room.network;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*
never forget singleton pattern...
 */

public class SingletonService {
    private static final String BASE_API_URL = "https://ghibliapi.herokuapp.com/";
    private static Retrofit mRetrofit2 = null;

    private SingletonService() {
    }


    public static Retrofit getRetrofit2() {
        if (mRetrofit2 == null) {
            mRetrofit2 = new Retrofit.Builder()
                    .baseUrl("https://ghibliapi.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .build();
        }
        return mRetrofit2;
    }
}
