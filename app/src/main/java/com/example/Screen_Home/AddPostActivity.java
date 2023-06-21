package com.example.Screen_Home;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.Adapter.SelectImageAdapter;
import com.example.Database.CarDao;
import com.example.Database.getCarDatabase;
import com.example.Model.Car;
import com.example.Screen_Fragment.HomeFragment;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityAddPostBinding;


import java.util.ArrayList;
import java.util.Random;

public class AddPostActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAddPostBinding binding;
    ArrayList<Uri> list;
    String carTypeOfFuel;
    String carGearType;
    int year,carMileage,price;

    Car car;
    Random random;

    CarDao carDao;

    private static getCarDatabase carDatabase;

    SelectImageAdapter adaptor;
    String colum[] = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        random = new Random();

        carDatabase = Room.databaseBuilder(this, getCarDatabase.class, "car-database").allowMainThreadQueries().build();
        carDao = HomeFragment.getCarDatabase().carDao();

        int id = random.nextInt(10);
        String carName = binding.edModel.getText().toString();
        try {
            year = Integer.parseInt(binding.edYear.getText().toString());
            carMileage = Integer.parseInt(binding.edMileage.getText().toString());
            price = Integer.parseInt(binding.edPrice.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error in Parse", Toast.LENGTH_SHORT).show();
        }

        // Check for Fuel Type
        if (binding.radioPetrol.isChecked()) {
            carTypeOfFuel = "بنزين";
        }
        if (binding.radioDiesel.isChecked()) {
            carTypeOfFuel = "ديزل";
        }
        if (binding.radioElectric.isChecked()) {
            carTypeOfFuel = "كهرباء";
        }
        if (binding.radioHybrid.isChecked()) {
            carTypeOfFuel = "هجين";
        }

        // Check for Gear Type
        if (binding.radioAutomatic.isChecked()) {
            carGearType = "أوتوماتيك";
        }
        if (binding.radioManual.isChecked()) {
            carGearType = "يدوي";
        }
        String carDescription = binding.edDescription.getText().toString();
        String position = binding.edLocation.getText().toString();
        String manufactureType = binding.edType.getText().toString();
//        int numberOfCylinder = Integer.parseInt(binding.edCylinders.getText().toString());


        car = new Car(id,
                carName,
                false,
                carMileage,
                price,
                "",
                year,
                15,
                carDescription,
                carTypeOfFuel,
                "",
                carGearType,
                manufactureType,
                position);

        binding.btnSave.setOnClickListener(v -> {
            carDao.insertCar(car);
            finish();
        });

        binding.back.setOnClickListener(v -> {
            finish();
        });

        list = new ArrayList<>();
        adaptor = new SelectImageAdapter(list);
        binding.rcHomeFragment.setAdapter(adaptor);
        binding.buttonGellary.setOnClickListener(this);
        if ((ActivityCompat.checkSelfPermission(
                AddPostActivity.this, colum[0]) != PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat.checkSelfPermission(
                        AddPostActivity.this, colum[1]) != PackageManager.PERMISSION_GRANTED)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(colum, 123);
            }
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonGellary:
                openGalley();
                break;
        }

    }

    private void openGalley() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selcet Picture"), 123);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            if (data.getClipData() != null) {
                int x = data.getClipData().getItemCount();
                for (int i = 0; i < x; i++) {
                    list.add(data.getClipData().getItemAt(i).getUri());
                }
                adaptor.notifyDataSetChanged();
                binding.tvCountImage.setText(list.size() + "/" + binding.rcHomeFragment.getAdapter().getItemCount());
            } else if (data.getData() != null) {
                String imgurl = data.getData().getPath();
                list.add(Uri.parse(imgurl));
            }
        }
    }

}