package com.example.Screen_Home;

import static com.example.Model.NamePrefStatic.EMAIL_REGISTER;
import static com.example.Model.NamePrefStatic.PHONE_NUMBER;
import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.Database.CarDao;
import com.example.Database.getCarDatabase;
import com.example.Model.Car;
import com.example.Model.ShowCar;
import com.example.Screen_Fragment.HomeFragment;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityViewCarsBinding;

public class ViewCarsActivity extends AppCompatActivity {

    ActivityViewCarsBinding binding;
//    CarDao carDao;
//    private static getCarDatabase carDatabase;
//    Car car ;
//    ShowCar showCar;
    SharedPreferences preferences;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        phone = preferences.getString(PHONE_NUMBER, "");

        Intent intent = getIntent();
        String carName = intent.getStringExtra("carName");
        String carPrice = intent.getStringExtra("carPrice");
        String carDesc = intent.getStringExtra("desc");
        String travel = intent.getStringExtra("travel");
        String map = intent.getStringExtra("map");
        String gear = intent.getStringExtra("gear");
        int image = intent.getIntExtra("img",1);

        binding.tvNameCar.setText(carName);
        binding.tvPriceCar.setText(carPrice);
        binding.tvDeatilsCar.setText(carDesc);
        binding.tvMileage.setText(travel);
        binding.tvGear.setText(gear);
        binding.tvMap.setText(map);
        binding.imgCar.setImageResource(image);
//        carDatabase = Room.databaseBuilder(this, getCarDatabase.class, "car-database").allowMainThreadQueries().build();
//        carDao = ViewCarsActivity.getCarDatabase().carDao();
//        if (intent != null) {
//            int carId = intent.getIntExtra("carId", 0);
//            car =  carDao.getCarById(carId);
//            car = new Car(car.getId(),
//                    car.getCarName(),
//                    car.isFavorite(),
//                    car.getMileage(),
//                    car.getPrice(),
//                    car.getCarModel(),
//                    car.getYear(),
//                    car.getEngineCapacity(),
//                    car.getDescription(),
//                    car.getTypeOfFuel(),
//                    car.getColour(),
//                    car.getTypeOfGear(),
//                    car.getManufactureType(),
//                    car.getPosition());
//            Toast.makeText(this, ""+car.getId(), Toast.LENGTH_LONG).show();
//            binding.tvNameCar.setText(car.getCarName());
//            binding.tvPriceCar.setText(car.getPrice() + " USD");
//            binding.tvDeatilsCar.setText(car.getDescription());
//            binding.tvGear.setText(car.getTypeOfGear());
//            binding.tvPetrol.setText(car.getTypeOfFuel());
//            binding.tvLocation.setText(car.getPosition());
//            binding.tvMileage.setText(car.getMileage()+"\\km");
//            if (car.isFavorite()){
//                binding.checkboxFavoriteCar.setForeground(getDrawable(R.drawable.favorite_checked_24));
//            }
//        }

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
            goToPhoneCalls.setData(Uri.parse("tel:"+phone));
            startActivity(goToPhoneCalls);
        });


    }
//        public static getCarDatabase getCarDatabase() {
//            return carDatabase;
//        }
}