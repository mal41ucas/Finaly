package com.example.Screen_Home;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.Database.CarDao;
import com.example.Database.getCarDatabase;
import com.example.Model.Car;
import com.example.Screen_Fragment.HomeFragment;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityViewCarsBinding;

public class ViewCarsActivity extends AppCompatActivity {

    ActivityViewCarsBinding binding;
    CarDao carDao;
    private static getCarDatabase carDatabase;
    Car car ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        carDatabase = Room.databaseBuilder(this, getCarDatabase.class, "car-database").allowMainThreadQueries().build();
        carDao = ViewCarsActivity.getCarDatabase().carDao();
        if (intent != null) {
            int carId = intent.getIntExtra("carId", 0);
            car =  carDao.getCarById(carId);
            car = new Car(car.getId(),
                    car.getCarName(),
                    car.isFavorite(),
                    car.getMileage(),
                    car.getPrice(),
                    car.getCarModel(),
                    car.getYear(),
                    car.getEngineCapacity(),
                    car.getDescription(),
                    car.getTypeOfFuel(),
                    car.getColour(),
                    car.getTypeOfGear(),
                    car.getManufactureType(),
                    car.getPosition());
            Toast.makeText(this, ""+car.getId(), Toast.LENGTH_LONG).show();
            binding.tvNameCar.setText(car.getCarName());
            binding.tvPriceCar.setText(car.getPrice() + " USD");
            binding.tvDeatilsCar.setText(car.getDescription());
            binding.tvGear.setText(car.getTypeOfGear());
            binding.tvPetrol.setText(car.getTypeOfFuel());
            binding.tvLocation.setText(car.getPosition());
            binding.tvMileage.setText(car.getMileage()+"\\km");
            if (car.isFavorite()){
                binding.checkboxFavoriteCar.setForeground(getDrawable(R.drawable.favorite_checked_24));
            }
        }

        binding.back.setOnClickListener(view -> {
            finish();
        });

        binding.checkboxFavoriteCar.setOnClickListener(v -> {
            if (binding.checkboxFavoriteCar.isChecked()) {
                binding.checkboxFavoriteCar.setForeground(getDrawable(R.drawable.favorite_checked_24));
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
            }
            if (!binding.checkboxFavoriteCar.isChecked()) {
                binding.checkboxFavoriteCar.setForeground(getDrawable(R.drawable.favorite_un_checked_24));
                Toast.makeText(this, "Un Checked", Toast.LENGTH_SHORT).show();
            }
        });

        binding.fABCall.setOnClickListener(view -> {
            Intent goToPhoneCalls = new Intent(Intent.ACTION_DIAL);
            goToPhoneCalls.setData(Uri.parse("tel:0599791805"));
            startActivity(goToPhoneCalls);
        });


    }
        public static getCarDatabase getCarDatabase() {
            return carDatabase;
        }
}