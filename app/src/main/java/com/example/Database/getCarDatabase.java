package com.example.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.Model.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class getCarDatabase extends RoomDatabase {
    public abstract CarDao carDao();
}
