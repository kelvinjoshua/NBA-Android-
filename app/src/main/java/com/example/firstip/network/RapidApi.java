package com.example.firstip.network;

import com.example.firstip.models.Api;
import com.example.firstip.models.NbaSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface

RapidApi {
    //relative urls
    @GET("https://api-nba-v1.p.rapidapi.com/teams/confName/East")

    //call object to perfom http request
    Call<NbaSearchResponse> getApi(

    );
    //models west
    // Call<NbaSearchResponse>


}
