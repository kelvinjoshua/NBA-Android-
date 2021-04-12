package com.example.firstip.network;

import com.example.firstip.model2.NbaSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface

RapidApi {
    //relative urls
    @GET("teams/confName/West")
    //call object to perfom http request
    Call<NbaSearchResponse> getApi(
            //@Query()
    );
    //models west
    // Call<NbaSearchResponse>


}
