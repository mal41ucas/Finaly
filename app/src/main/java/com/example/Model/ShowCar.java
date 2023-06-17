package com.example.Model;

import android.graphics.drawable.Drawable;

public class ShowCar {

    int img;
    String carName,carPrice,carTraveledDistance;
    Boolean favorite;

    public ShowCar(int img, String carName, String carPrice, String carTraveledDistance, Boolean favorite) {
        this.img = img;
        this.carName = carName;
        this.carPrice = carPrice;
        this.carTraveledDistance = carTraveledDistance;
        this.favorite = favorite;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarTraveledDistance() {
        return carTraveledDistance;
    }

    public void setCarTraveledDistance(String carTraveledDistance) {
        this.carTraveledDistance = carTraveledDistance;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}
