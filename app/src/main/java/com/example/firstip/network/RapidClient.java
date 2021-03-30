package com.example.firstip.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.firstip.Constants.RAPID_BASE_URL;
import static com.example.firstip.Constants.RAPID_NBA_KEY;

public class RapidClient {
    private static Retrofit retrofit =null;
    public static RapidApi getClient(){

        if(retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor(){
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Authorization", RAPID_NBA_KEY)
                            .build();
                    return chain.proceed(newRequest);
                }
            }).build();//build each request with access Credentials
            retrofit = new Retrofit.Builder().baseUrl(RAPID_BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(RapidApi.class);//create a RapidApi instance to be invoked/make contact with retrofit instance
    };


}
