
package com.example.firstip.model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class NbaSearchResponse {

    @SerializedName("api")
    @Expose
    private Api api;
    public NbaSearchResponse(){}
    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

}
