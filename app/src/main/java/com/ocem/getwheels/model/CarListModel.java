package com.ocem.getwheels.model;

public class CarListModel {

    int id;
    String image;
    String name;
    String seat;
    String price;

    public CarListModel(int id, String image, String name, String seat, String price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.seat = seat;
        this.price = price;
    }

// getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarListModel{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", seat='" + seat + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}