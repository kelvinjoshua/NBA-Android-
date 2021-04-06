
package com.example.firstip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class NbaSearchResponse {

    @SerializedName("api")
    @Expose
    public Api api;

    /**
     * No args constructor for use in serialization
     * public NbaSearchResponse() {
     *     }
     */


    /**
     * 
     * @param api
     */
    public NbaSearchResponse(Api api) {
        super();
        this.api = api;
    }

    public Api getApi() {
        return api;
    }


    public void setApi(Api api) {
        this.api = api;
    }

}
