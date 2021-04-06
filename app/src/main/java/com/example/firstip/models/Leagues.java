
package com.example.firstip.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Leagues {

    @SerializedName("standard")
    @Expose
    private Standard standard;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Leagues() {
    }

    /**
     * 
     * @param standard
     */
    public Leagues(Standard standard) {
        super();
        this.standard = standard;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

}
