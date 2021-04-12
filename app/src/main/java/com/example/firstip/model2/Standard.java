
package com.example.firstip.model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Standard {

    @SerializedName("confName")
    @Expose
    private String confName;
    @SerializedName("divName")
    @Expose
    private String divName;

    public Standard(){}
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
