package com.example.Screen_Home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
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

public class AddPostActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SELECT_IMAGE = 1;
    ActivityAddPostBinding binding;
    ArrayList<Uri> list;
    String carTypeOfFuel;
    String carGearType;
    int year, carMileage, price;
    Car car;
    Random random;
    CarDao carDao;
    private static getCarDatabase carDatabase;
    private Uri selectedImageUri;


//    SelectImageAdapter adaptor;
//    String colum[] = {
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_EXTERNAL_STORAGE};

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
//        try {
//            year = Integer.parseInt(binding.edYear.getText().toString());
//            carMileage = Integer.parseInt(binding.edMileage.getText().toString());
//            price = Integer.parseInt(binding.edPrice.getText().toString());
//        } catch (NumberFormatException e) {
//            Toast.makeText(this, "Error in Parse", Toast.LENGTH_SHORT).show();
//        }

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
            if (!TextUtils.isEmpty(binding.edModel.getText().toString())) {
                if (!TextUtils.isEmpty(binding.edYear.getText().toString())) {
                    if (!TextUtils.isEmpty(binding.edPrice.getText().toString())) {
                        if (!TextUtils.isEmpty(binding.edType.getText().toString())) {
                            if (!TextUtils.isEmpty(binding.edMileage.getText().toString())) {
                                if (!TextUtils.isEmpty(binding.edLocation.getText().toString())) {
                                    if (!TextUtils.isEmpty(binding.edDescription.getText().toString())) {
                                        if (!TextUtils.isEmpty(binding.edDors.getText().toString())) {
                                            if (!TextUtils.isEmpty(binding.edCylinders.getText().toString())) {
                                                if (binding.radioManual.isChecked() || binding.radioAutomatic.isChecked()) {
                                                    if (binding.radioPetrol.isChecked() || binding.radioHybrid.isChecked()
                                                            || binding.radioElectric.isChecked() || binding.radioDiesel.isChecked()) {
                                                        carDao.insertCar(car);
                                                        finish();
                                                    } else
                                                        Toast.makeText(this, "الرجاء اختيار نوع الوقود", Toast.LENGTH_SHORT).show();
                                                } else
                                                    Toast.makeText(this, "الرجاء اختيار نوع المحرك", Toast.LENGTH_SHORT).show();
                                            } else
                                                Toast.makeText(this, "الرجاء ادخال الاسطوانات", Toast.LENGTH_SHORT).show();
                                        } else
                                            Toast.makeText(this, "الرجاء ادخال عدد الابواب", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(this, "الرجاء ادخال التفاصيل", Toast.LENGTH_SHORT).show();
                                } else
                                    Toast.makeText(this, "الرجاء ادخال العنوان", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(this, "الرجاء ادخال عدد الكيلو مترات", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(this, "الرجاء ادخال النوع", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(this, "الرجاء ادخال السعر", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "الرجاء ادخال السنه", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "الرجاء ادخال الموديل", Toast.LENGTH_SHORT).show();
        });

        binding.back.setOnClickListener(v -> {
            finish();
        });

        ActivityResultLauncher<String> imagePickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), result -> {
            if (result != null) {
                selectedImageUri = result;
                // Do something with the selected image URI (e.g., display it in an ImageView)
                binding.imgAddCar.setImageURI(selectedImageUri);
            }
        });

        binding.buttonGallery.setOnClickListener(v -> {
            imagePickerLauncher.launch("image/*");
        });


//        binding.buttonGallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create an Intent to pick an image from the gallery
//                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE);
//            }
//        });
        //        list = new ArrayList<>();
//        adaptor = new SelectImageAdapter(list);
//        binding.rcHomeFragment.setAdapter(adaptor);
//        binding.buttonGellary.setOnClickListener(this);
//        if ((ActivityCompat.checkSelfPermission(
//                AddPostActivity.this, colum[0]) != PackageManager.PERMISSION_GRANTED) &&
//                (ActivityCompat.checkSelfPermission(
//                        AddPostActivity.this, colum[1]) != PackageManager.PERMISSION_GRANTED)) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                requestPermissions(colum, 123);
//            }
//        }
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()) {
//            case R.id.buttonGellary:
//                openGalley();
//                break;
//        }
//
//    }
//
//    private void openGalley() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Selcet Picture"), 123);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 123 && resultCode == RESULT_OK) {
//            if (data.getClipData() != null) {
//                int x = data.getClipData().getItemCount();
//                for (int i = 0; i < x; i++) {
//                    list.add(data.getClipData().getItemAt(i).getUri());
//                }
//                adaptor.notifyDataSetChanged();
//                binding.tvCountImage.setText(list.size() + "/" + binding.rcHomeFragment.getAdapter().getItemCount());
//            } else if (data.getData() != null) {
//                String imgurl = data.getData().getPath();
//                list.add(Uri.parse(imgurl));
//            }
//        }
//    }
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
//            // The user has selected an image
//            Uri selectedImageUri = data.getData();
//
//            // Do something with the selected image URI (e.g., display it in an ImageView)
//            ImageView imageView = findViewById(R.id.imageView);
//            imageView.setImageURI(selectedImageUri);
//        }
//    }

}