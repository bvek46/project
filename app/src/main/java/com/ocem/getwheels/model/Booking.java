package com.ocem.getwheels.model;

public class Booking {
    int image;
    String name;
    String paymentMethod;
    String paymentStatus;
    Integer billingAmt;

    public Booking(int image, String name, String paymentMethod, String paymentStatus, Integer billingAmt) {
        this.image = image;
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.billingAmt = billingAmt;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getBillingAmt() {
        return billingAmt;
    }

    public void setBillingAmt(Integer billingAmt) {
        this.billingAmt = billingAmt;
    }
}

