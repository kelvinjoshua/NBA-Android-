package com.example.firstip.network;

import com.example.firstip.models.NbaSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RapidApi {
    //relative urls
    ////.url("https://api-nba-v1.p.rapidapi.com/teams/confName/East")

    @GET("https://api-nba-v1.p.rapidapi.com/teams/confName/East")
    //call object to perfom http request
    Call<NbaSearchResponse> getTeams(
            );
    //models west
    // Call<NbaSearchResponse>


}
