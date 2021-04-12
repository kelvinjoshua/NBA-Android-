
package com.example.firstip.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Leagues {

    @SerializedName("standard")
    @Expose
    private Standard standard;
    //default empty constructor
    public Leagues (){

    }
    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

}
