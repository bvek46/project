package com.ocem.getwheels.Modelresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehiclecategory {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("model_name")
    @Expose
    private String modelName;

    @SerializedName("no_of_person")
    @Expose
    private String noOfPerson;

    @SerializedName("transmission")
    @Expose
    private String transmission;

    @SerializedName("fuel_capacity")
    @Expose
    private String fuelCapacity;

    @SerializedName("pickup_location")
    @Expose
    private String pickupLocation;

    @SerializedName("from_date")
    @Expose
    private String fromDate;

    @SerializedName("to_date")
    @Expose
    private String toDate;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("cost_per_day")
    @Expose
    private String costPerDay;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    // constructor
    public Vehiclecategory(Integer id, String modelName, String noOfPerson, String transmission,
                           String fuelCapacity, String pickupLocation, String fromDate,
                           String toDate, String description, String type, String image, String costPerDay,
                           String createdAt, String updatedAt) {
        this.id = id;
        this.modelName = modelName;
        this.noOfPerson = noOfPerson;
        this.transmission = transmission;
        this.fuelCapacity = fuelCapacity;
        this.pickupLocation = pickupLocation;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.type = type;
        this.image = image;
        this.costPerDay = costPerDay;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(String noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(String costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    // toString
    @Override
    public String toString() {
        return "Vehiclecategory{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", noOfPerson='" + noOfPerson + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelCapacity='" + fuelCapacity + '\'' +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", costPerDay='" + costPerDay + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
