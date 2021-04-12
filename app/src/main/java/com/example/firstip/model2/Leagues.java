
package com.example.firstip.model2;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Leagues {

    @SerializedName("standard")
    @Expose
    private Standard standard;
    public Leagues(){}
    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

}
