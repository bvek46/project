package com.ocem.getwheels.Modelresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehileCategoryResponse {

    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("vehiclecategories")
    @Expose
    private List<Vehiclecategory> vehiclecategorie;

    // constructor
    public VehileCategoryResponse(String success, List<Vehiclecategory> vehiclecategorie) {
        this.success = success;
        this.vehiclecategorie = vehiclecategorie;
    }

    // getter and setter
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Vehiclecategory> getVehiclecategorie() {
        return vehiclecategorie;
    }

    public void setVehiclecategorie(List<Vehiclecategory> vehiclecategorie) {
        this.vehiclecategorie = vehiclecategorie;
    }

    // toString
    @Override
    public String toString() {
        return "VechileCategoryResponse{" +
                "success='" + success + '\'' +
                ", vehiclecategorie=" + vehiclecategorie +
                '}';
    }
}
