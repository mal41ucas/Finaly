package com.example.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cars")
public class Car {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "car_name")
    private String carName;

    private boolean isFavorite;
    private float mileage;
    private double price;

    @ColumnInfo(name = "car_model")
    private String carModel;

    private int year;

    @ColumnInfo(name = "engine_capacity")
    private double engineCapacity;

    private String description;

    @ColumnInfo(name = "type_of_fuel")
    private String typeOfFuel;

    private String colour;

    @ColumnInfo(name = "type_of_gear")
    private String typeOfGear;

    @ColumnInfo(name = "manufacture_type")
    private String manufactureType;

    private String position;

    public Car(int id,
               String carName,
               boolean isFavorite,
               float mileage,
               double price,
               String carModel,
               int year,
               double engineCapacity,
               String description,
               String typeOfFuel,
               String colour,
               String typeOfGear,
               String manufactureType,
               String position) {
        this.id = id;
        this.carName = carName;
        this.isFavorite = isFavorite;
        this.mileage = mileage;
        this.price = price;
        this.carModel = carModel;
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.description = description;
        this.typeOfFuel = typeOfFuel;
        this.colour = colour;
        this.typeOfGear = typeOfGear;
        this.manufactureType = manufactureType;
        this.position = position;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTypeOfGear() {
        return typeOfGear;
    }

    public void setTypeOfGear(String typeOfGear) {
        this.typeOfGear = typeOfGear;
    }

    public String getManufactureType() {
        return manufactureType;
    }

    public void setManufactureType(String manufactureType) {
        this.manufactureType = manufactureType;
    }
}
