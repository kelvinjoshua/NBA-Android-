
package com.example.firstip.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Standard {

    @SerializedName("confName")
    @Expose
    private String confName;
    @SerializedName("divName")
    @Expose
    private String divName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Standard() {
    }

    /**
     * 
     * @param confName
     * @param divName
     */
    public Standard(String confName, String divName) {
        super();
        this.confName = confName;
        this.divName = divName;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }

}
