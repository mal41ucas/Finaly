package com.example.Screen_Home;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.Adapter.ShowCarAdapter;
import com.example.Database.CarDao;
import com.example.Database.getCarDatabase;
import com.example.Model.Car;
import com.example.Screen_Fragment.HomeFragment;
import com.example.projectcar.databinding.ActivityMyCarsBinding;

import java.util.ArrayList;
import java.util.List;

public class MyCarsActivity extends AppCompatActivity {

    ActivityMyCarsBinding binding;
    private static getCarDatabase carDatabase;

    CarDao carDao;
    ShowCarAdapter showCarAdapter;
    ArrayList<Car> cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cars = new ArrayList<>();
        carDatabase = Room.databaseBuilder(getBaseContext(), getCarDatabase.class, "car-database").allowMainThreadQueries().build();
        carDao = HomeFragment.getCarDatabase().carDao();
        binding.back.setOnClickListener(view ->{
            finish();
        });

        List<Car> carList = carDao.getAllCars();

        showCarAdapter = new ShowCarAdapter(getBaseContext(), carList);
        binding.rcMyCars.setAdapter(showCarAdapter);
    }
}