package com.example.firstip.network;

import com.example.firstip.models.NbaSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RapidApi {
    //relative urls
    @GET("teams/confName")
    //call object to perfom http request
    Call<NbaSearchResponse> getTeams(
            @Query("confname") String East
            );
    //models west
    // Call<NbaSearchResponse>
}
