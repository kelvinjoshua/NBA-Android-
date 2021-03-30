
package com.example.firstip.models;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class NbaSearchResponse {

    @SerializedName("api")
    @Expose
    private Api api;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NbaSearchResponse() {
    }

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
