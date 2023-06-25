package com.example.Model;

import androidx.room.PrimaryKey;


// Unused Class...
// Should be Deleted.

public class ShowCar {

    @PrimaryKey(autoGenerate = true)
    int id;
    int img, imgPerson;
    String carName, carPrice, carTraveledDistance, namePerson, typeGear, location, description;
    Boolean favorite;

    public ShowCar(int img, int imgPerson, String carName, String carPrice, String carTraveledDistance, String namePerson, String typeGear, String location, Boolean favorite, String description) {
        this.img = img;
        this.imgPerson = imgPerson;
        this.carName = carName;
        this.carPrice = carPrice;
        this.carTraveledDistance = carTraveledDistance;
        this.namePerson = namePerson;
        this.typeGear = typeGear;
        this.location = location;
        this.favorite = favorite;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeGear() {
        return typeGear;
    }

    public void setTypeGear(String typeGear) {
        this.typeGear = typeGear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgPerson() {
        return imgPerson;
    }

    public void setImgPerson(int imgPerson) {
        this.imgPerson = imgPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
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
