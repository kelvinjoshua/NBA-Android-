package com.example.firstip.network;

import com.example.firstip.Constants;

import java.io.IOException;
import java.util.logging.Level;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.firstip.Constants.RAPID_BASE_URL;
import static com.example.firstip.Constants.RAPID_NBA_KEY;

public class RapidClient {
    private static Retrofit retrofit =null;
    public static RapidApi getClient(){

        if(retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).addInterceptor(new Interceptor(){
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("x-rapidapi-key", "9459dc53cbmsh04768043878e318p1a90f3jsn027f304452b8")
                            //.addHeader("x-rapidapi-key", RAPID_NBA_KEY)
                            .addHeader("x-rapidapi-host", "api-nba-v1.p.rapidapi.com")
                            .build();
                    return chain.proceed(newRequest);
                }
            }).build();//build each request with access Credentials
            retrofit = new Retrofit.Builder().baseUrl(RAPID_BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(RapidApi.class);//create a RapidApi instance to be invoked/make contact with retrofit instance
    };
/*
*  RapidApi client = RapidClient.getClient();
        //Response response = client.newCall(request).execute();
        Call<NbaSearchResponse> call = client.getTeams(confname);

        //processing request
        call.enqueue(new Callback<NbaSearchResponse>() {
            @Override
            public void onResponse(Call<NbaSearchResponse> call, Response<NbaSearchResponse> response) {
                //response = okHttpClient.newCall(request).execute();
                //hideProgressBar();
                //Response response = client.newCall(request).execute();
                if(response.isSuccessful()){
                    assert response.body() != null;
                    eastTeams = response.body().getTeams();
                    //instantiate an adapter and associate it to our recycler view
                    teamAdapter = new Adapter(Teams.this, eastTeams);
                    ;
                    //teamAdapter.notifyDataSetChanged();
                    //create layout manager for respective recycler view
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Teams.this);//our layout with the recyclerview activity-teams
                   //our recycler needs a layout manager and an adapter
                    recycler.setLayoutManager(layoutManager);
                    recycler.setHasFixedSize(true);
                    recycler.setAdapter(teamAdapter);
                   showTeams();
                }*/

}/*
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://api-nba-v1.p.rapidapi.com/leagues/")
            .get()
            .addHeader("x-rapidapi-key", "9459dc53cbmsh04768043878e318p1a90f3jsn027f304452b8")
            .addHeader("x-rapidapi-host", "api-nba-v1.p.rapidapi.com")
            .build();

    Response response = client.newCall(request).execute(); */