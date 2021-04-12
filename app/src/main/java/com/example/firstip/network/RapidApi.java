package com.example.firstip.network;

import com.example.firstip.models.NbaSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RapidApi {
    //relative urls
    //the relative url for the endpoint  HTTP/1.1
    @GET("teams/confName/West")
    //call object to perfom http request

    //client perfoming the request
    Call<NbaSearchResponse> getApi(
    );
    //models west
    // Call<NbaSearchResponse>


}
