package com.example.Screen_Home;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.Adapter.ShowCarAdapter;
import com.example.Database.CarDao;
import com.example.Database.getCarDatabase;
import com.example.Model.Car;
import com.example.Model.ShowCar;
import com.example.Screen_Fragment.HomeFragment;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityMyCarsBinding;

import java.util.ArrayList;
import java.util.List;

public class MyCarsActivity extends AppCompatActivity {

    ActivityMyCarsBinding binding;
    private static getCarDatabase carDatabase;

    CarDao carDao;
    ArrayList<Car> cars;

    ShowCarAdapter showCarAdapter;
    ArrayList<ShowCar> showCars;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        cars = new ArrayList<>();
//        carDatabase = Room.databaseBuilder(getBaseContext(), getCarDatabase.class, "car-database").allowMainThreadQueries().build();
//        carDao = HomeFragment.getCarDatabase().carDao();
        binding.back.setOnClickListener(view -> {
            finish();
        });

        showCars = new ArrayList<>();

        ShowCar car1 = new ShowCar(R.drawable.cover_1, preferences.getInt("imgUser",1), "بي أم", "41200", "430", preferences.getString("name",""), "اوتوماتيك", "غزة", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car2 = new ShowCar(R.drawable.cover_2, preferences.getInt("imgUser",1), "نمبرجين", "37800", "430", preferences.getString("name",""), "اوتوماتيك", "غزة", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car3 = new ShowCar(R.drawable.cover_3, preferences.getInt("imgUser",1), "تسلا", "96200", "430", preferences.getString("name",""), "اوتوماتيك", "غزة", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car4 = new ShowCar(R.drawable.cover_4, preferences.getInt("imgUser",1), "نمبرجين", "109700", "430", preferences.getString("name",""), "اوتوماتيك", "غزة", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car5 = new ShowCar(R.drawable.cover_5, preferences.getInt("imgUser",1), "أودي", "85400", "430", preferences.getString("name",""), "اوتوماتيك", "غزة", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        showCars.add(car1);
        showCars.add(car2);
        showCars.add(car3);
        showCars.add(car4);
        showCars.add(car5);
        showCars.add(car1);
        showCars.add(car2);
        showCars.add(car3);
        showCars.add(car4);
        showCars.add(car5);

        showCarAdapter = new ShowCarAdapter(getBaseContext(), showCars);
        binding.rcMyCars.setAdapter(showCarAdapter);
//        List<Car> carList = carDao.getAllCars();
//
//        showCarAdapter = new ShowCarAdapter(getBaseContext(), carList);
//        binding.rcMyCars.setAdapter(showCarAdapter);
    }
}