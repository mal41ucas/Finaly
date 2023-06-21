package com.example.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.Model.Car;

import java.util.List;

@Dao
public interface CarDao {
    @Insert
    void insertCar(Car car);


    @Query("DELETE FROM cars WHERE id = :carId")
    void deleteCar(int carId);

    @Query("SELECT * FROM cars WHERE id = :carId")
    Car getCarById(int carId);

    @Query("SELECT * FROM cars")
    List<Car> getAllCars();
}
